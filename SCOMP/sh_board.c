#include <sys/mman.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <semaphore.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <time.h>
#include <wait.h>

#define N_COLUMNS 2
#define N_ROWS 2
#define N_OPERATIONS 10

#define READ_OPT 1
#define READ_TIME 3

#define WRITE_OPT 2
#define WRITE_TIME 5

#define CHANGE_OPT 3
#define CHANGE_TIME 7

typedef struct {
    int board[N_ROWS][N_COLUMNS];
} board;


int main(){
    int fd;
    board *shared_mem;
    
    fd = shm_open("/shm_board", O_CREAT|O_RDWR, S_IRUSR|S_IWUSR);
    
    if(fd == -1){
        perror("shm_open()");
        exit(1);
    }

    ftruncate(fd,sizeof(board));

    shared_mem = (board *) mmap(NULL, sizeof(board), PROT_READ|PROT_WRITE , MAP_SHARED, fd, 0);

    if (shared_mem == NULL){
        perror("mmap()");
        exit(1);
    }

    sem_t *sem_board,*sem_print_board;

    sem_board = sem_open("sem_board",O_CREAT,0644,1);
    sem_print_board = sem_open("sem_print_board",O_CREAT,0644,0);

    if (sem_board == SEM_FAILED || sem_print_board == SEM_FAILED){
        perror("sem_open()");
        exit(1);
    }
    

    
    for(int i = 0; i < N_OPERATIONS+1; i++){
        pid_t pid = fork();

        if(pid == 0){
            /*Child that prints the board every time that an operation occurs*/
            if (i == 0){
                for(int j = 0; j < N_OPERATIONS; j++){
                    sem_wait(sem_print_board);
                    for (int a = 0; a < N_ROWS; a++){
                        for(int b = 0; b < N_COLUMNS; b++){
                            printf("[%d]", shared_mem->board[a][b]);
                        }
                        printf("\n");
                    }
                    sem_post(sem_board);
                }
                
            }else{
                
                /*
                Option 1 - Read from post-it
                Option 2 - Write in post-it
                Option 3 - Swapp post-its 
                */
                

                /*Generate random option*/
                int option;
                time_t t;			/* needed to initialize random number generator (RNG) */

                /* 
                - Intializes RNG (srand():stdlib.h; time(): time.h) 
                - getpid() used to generate another seed so the values aren't all the same 
                */

                srand ((unsigned) time (&t) + getpid());

                /*Generates the random values (type of client)*/

                option = (rand () % 3) + 1;

                /*Generate random post-it to do operation on*/

                int row = rand () % N_ROWS;
                int column = rand () % N_COLUMNS;

                sem_wait(sem_board);

                /*Do operation*/
                switch (option){
                    case READ_OPT:
                        printf("Reading from post-it in (%d,%d) ...\n",row,column);
                        sleep(READ_TIME);
                        printf("Read Value : %d\n", shared_mem->board[row][column]);
                        break;
                    case WRITE_OPT:
                        printf("Writing in post-it in (%d,%d) ...\n",row,column);
                        int value = (rand () % 999) + 1;
                        shared_mem->board[row][column] = value;
                        sleep(WRITE_TIME);
                        printf("Wrote %d in post-it in (%d,%d) ...\n",value,row,column);
                        break;
                    case CHANGE_OPT:;
                        /*Generate other post-it*/
                        int row2 = rand () % N_ROWS;
                        int column2 = rand () % N_COLUMNS;
                        printf("Swapping contents from post-its (%d,%d) and (%d,%d) ...\n",row,column,row2,column2);
                        int aux = shared_mem->board[row][column];
                        shared_mem->board[row][column] = shared_mem->board[row2][column2];
                        shared_mem->board[row2][column2] = aux;
                        sleep(CHANGE_TIME);
                        break;
                }
                sem_post(sem_print_board);
            }
            exit(0);
        }
    }
    for (int i = 0; i < N_OPERATIONS+1; i++){
        wait(NULL);
    }
    
    /*Disconnects the shared memory area from the process address space*/
    if(munmap(shared_mem,sizeof(board)) < 0){
        perror("munmap()");
        exit(1);
    }
    
    /* Removes memory area from file system as it is no longer needed*/
    if(shm_unlink("/shm_board") < 0){
        perror("shm_unlink()");
        exit(1);
    }
    
    if (sem_unlink("sem_board") == -1){
        perror("sem_unlink()");
        exit(1);
    }

    if (sem_unlink("sem_print_board") == -1){
        perror("sem_unlink()");
        exit(1);
    }
    return 0;
}