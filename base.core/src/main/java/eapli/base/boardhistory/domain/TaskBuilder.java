package eapli.base.boardhistory.domain;

import eapli.base.boardparticipantmanagement.domain.BoardParticipant;
import eapli.base.postitmanager.domain.PostIt;
import eapli.base.usermanagement.domain.BoardOwner;

public class TaskBuilder {
    private TaskId taskId;
    private Operation operation;
    private BoardOwner boardOwner;
    private BoardParticipant boardParticipant;
    private PostIt postIt;
    private Integer oldRow;
    private Integer oldColumn;
    private Integer newRow;
    private Integer newColumn;

    public TaskBuilder withTaskId(long taskId){
        this.taskId = new TaskId(taskId);
        return this;
    }

    public TaskBuilder withOperation(OperationValue operation){
        this.operation = new Operation(operation);
        return this;
    }

    public TaskBuilder withBoardOwner(BoardOwner boardOwner){
        this.boardOwner = boardOwner;
        return this;
    }

    public TaskBuilder withBoardParticipant(BoardParticipant boardParticipant) {
        this.boardParticipant = boardParticipant;
        return this;
    }
    public TaskBuilder withPostIt(PostIt postIt){
        this.postIt = postIt;
        return this;
    }
    public TaskBuilder withOldRow(Integer oldRow){
        this.oldRow = oldRow;
        return this;
    }
    public TaskBuilder withOldColumn(Integer oldColumn){
        this.oldColumn = oldColumn;
        return this;
    }
    public TaskBuilder withNewRow(Integer newRow){
        this.newRow = newRow;
        return this;
    }
    public TaskBuilder withNewColumn(Integer newColumn){
        this.newColumn = newColumn;
        return this;
    }

    public Task build(){
        return new Task(this.taskId, this.operation, this.boardOwner, this.boardParticipant, this.postIt, this.oldRow, this.oldColumn, this.newRow, this.newColumn);
    }
}
