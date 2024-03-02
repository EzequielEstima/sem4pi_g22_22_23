package eapli.base.boardhistory.domain;

import eapli.base.boardparticipantmanagement.domain.BoardParticipant;
import eapli.base.postitmanager.domain.PostIt;
import eapli.base.usermanagement.domain.BoardOwner;

import javax.persistence.*;

@Entity
public class Task{
    @EmbeddedId
    private TaskId taskId;
    private Operation operation;
    @ManyToOne
    private BoardOwner  boardOwner;
    @ManyToOne
    private BoardParticipant boardParticipant;
    @OneToOne
    private PostIt postIt;

    private Integer oldRow;

    private Integer oldColumn;

    private Integer newRow;

    private Integer newColumn;

    protected Task(TaskId taskId, Operation operation, BoardOwner boardOwner, BoardParticipant boardParticipant, PostIt postIt, Integer oldRow, Integer oldColumn, Integer newRow, Integer newColumn) {
        if(taskId == null || operation == null || (boardParticipant == null && boardOwner == null)){
            throw new IllegalArgumentException("The task cannot be created with null Value Objects");
        }
        this.taskId = taskId;
        this.operation = operation;
        this.boardOwner = boardOwner;
        this.boardParticipant = boardParticipant;
        this.postIt = postIt;
        this.oldRow = oldRow;
        this.oldColumn = oldColumn;
        this.newRow = newRow;
        this.newColumn = newColumn;
    }

    protected Task(){

    }

    public String returnTaskIdString(){
        return taskId.returnTaskIdString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Operation: " + operation);

        if(boardOwner!=null && boardParticipant!=null){
            sb.append(" | BoardOwner: " + boardOwner + " | BoardParticipant: " + boardParticipant);
        }else{
            if(boardOwner!=null){
                sb.append(" | BoardOwner: " + boardOwner);
            }else {
                sb.append(" | BoardParticipant: " + boardParticipant);
            }
        }


        if(postIt!=null){
            sb.append(" | Post-It: " + postIt);
        }

        if(operation.toString().equals("Change post-it position")){
            sb.append(" | Old Positions: row = " + oldRow + " column = " + oldColumn);
            sb.append(" | New Positions: row = " + newRow + " column = " + newColumn);
        }

        return sb.toString();
    }

    public boolean isAddPostIt() {
        return operation.operationValue().equals(OperationValue.ADD);
    }

    public boolean isDoneByThisOwner(BoardOwner boardOwner) {
        if (this.boardOwner == null) {
            return false;
        } else {
            return this.boardOwner.equals(boardOwner);
        }
    }

    public boolean isDoneByThisParticipant(BoardParticipant boardParticipant) {
        if (this.boardParticipant == null){
            return false;
        }else{
            return this.boardParticipant.equals(boardParticipant);
        }


    }

    public boolean isInThisPostIt(PostIt currentPostIt) {
        return this.postIt.returnPostItIdentifier() == currentPostIt.returnPostItIdentifier();
    }

    public boolean verifyIfTaskWasMovePostIt() {
        return operation.operationValue().equals(OperationValue.CHANGE_POST_IT_POSITION);
    }

    public int[] getLastPosition() {
        int[] lastPosition = new int[2];
        lastPosition[0] = oldRow;
        lastPosition[1] = oldColumn;
        return lastPosition;
    }
}
