package eapli.base.board.application.services;

import eapli.base.board.domain.Board;
import eapli.base.board.repositories.BoardRepository;
import eapli.base.boardhistory.domain.OperationValue;
import eapli.base.boardhistory.domain.Task;
import eapli.base.boardhistory.domain.TaskBuilder;
import eapli.base.boardhistory.repositories.BoardHistoryRepository;
import eapli.base.boardparticipantmanagement.domain.BoardParticipant;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.postitmanager.domain.PostIt;
import eapli.base.usermanagement.domain.BoardOwner;
import eapli.base.usermanagement.repositories.BoardOwnerRepository;

public class AddTaskToBoardHistoryService {
    RepositoryFactory repositoryFactory = PersistenceContext.repositories();
    BoardRepository boardRepository = repositoryFactory.boardRepository();
    BoardHistoryRepository boardHistoryRepository = repositoryFactory.boardHistoryRepository();
    BoardOwnerRepository boardOwnerRepository = repositoryFactory.boardOwnerRepository();

    public boolean addShareBoardTaskToHistory(String boardTitle, BoardParticipant boardParticipant){
        Board board = boardRepository.findBoardByTitle(boardTitle);
        Task task = new TaskBuilder().withTaskId(boardHistoryRepository
                        .getLastTaskId()+1).withOperation(OperationValue.SHARE_BOARD)
                .withBoardOwner(boardOwnerRepository.findBoardOwnerByBoard(board))
                .withBoardParticipant(boardParticipant).build();
        board.addTaskToHistory(task);
        boardRepository.save(board);
        return true;
    }

    public boolean addArchiveBoardTaskToHistory(String boardTitle){
        Board board = boardRepository.findBoardByTitle(boardTitle);
        Task task = new TaskBuilder().withTaskId(boardHistoryRepository
                        .getLastTaskId()+1).withOperation(OperationValue.ARCHIVE)
                .withBoardOwner(boardOwnerRepository.findBoardOwnerByBoard(board)).build();
        board.addTaskToHistory(task);
        boardRepository.save(board);
        return true;
    }

    public boolean addChangePostItContentTaskToHistory(String boardTitle, BoardParticipant boardParticipant, BoardOwner boardOwner, PostIt postIt){
        Board board = boardRepository.findBoardByTitle(boardTitle);
        TaskBuilder builder = new TaskBuilder()
                .withTaskId(boardHistoryRepository.getLastTaskId()+1)
                .withOperation(OperationValue.CHANGE_POST_IT_CONTENT)
                .withPostIt(postIt);
        Task task;
        if (boardParticipant != null){
            task = builder.withBoardParticipant(boardParticipant).build();
        }else{
            task = builder.withBoardOwner(boardOwner).build();
        }

        board.addTaskToHistory(task);
        boardRepository.save(board);
        return true;
    }

    public boolean addChangePostItPositionTaskToHistory(String boardTitle, BoardParticipant boardParticipant, BoardOwner boardOwner, PostIt postIt, Integer oldRow, Integer oldColumn, Integer newRow, Integer newColumn ){
        Board board = boardRepository.findBoardByTitle(boardTitle);
        TaskBuilder builder = new TaskBuilder()
                .withTaskId(boardHistoryRepository.getLastTaskId()+1)
                .withOperation(OperationValue.CHANGE_POST_IT_POSITION)
                .withPostIt(postIt)
                .withOldRow(oldRow)
                .withOldColumn(oldColumn)
                .withNewRow(newRow)
                .withNewColumn(newColumn);

        Task task;
        if (boardParticipant != null){
            task = builder.withBoardParticipant(boardParticipant).build();
        }else{
            task = builder.withBoardOwner(boardOwner).build();
        }

        board.addTaskToHistory(task);
        boardRepository.save(board);
        return true;
    }
}
