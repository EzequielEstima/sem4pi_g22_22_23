package eapli.base.boardhistory.domain;

import eapli.base.boardparticipantmanagement.domain.BoardParticipant;
import eapli.base.postitmanager.domain.PostIt;
import eapli.base.usermanagement.domain.BoardOwner;

public class BoardHistoryBuilder {

    private BoardHistoryId boardHistoryId;
    private Task task;
    public BoardHistoryBuilder withBoardHistoryId(long boardHistoryId){
        this.boardHistoryId = new BoardHistoryId(boardHistoryId);
        return this;
    }
    public BoardHistoryBuilder withTask(long taskId, OperationValue operation, BoardOwner boardOwner){
        TaskBuilder taskBuilder = new TaskBuilder();
        this.task = taskBuilder.withTaskId(taskId)
                .withOperation(operation)
                .withBoardOwner(boardOwner)
                .build();
        return this;
    }
    public BoardHistoryBuilder withTask(long taskId, OperationValue operation, BoardOwner boardOwner, PostIt postIt){
        TaskBuilder taskBuilder = new TaskBuilder();
        this.task = taskBuilder.withTaskId(taskId)
                .withOperation(operation)
                .withBoardOwner(boardOwner)
                .withPostIt(postIt)
                .build();
        return this;
    }
    public BoardHistoryBuilder withTask(long taskId, OperationValue operation, BoardParticipant boardParticipant, PostIt postIt){
        TaskBuilder taskBuilder = new TaskBuilder();
        this.task = taskBuilder.withTaskId(taskId)
                .withOperation(operation)
                .withBoardParticipant(boardParticipant)
                .withPostIt(postIt)
                .build();
        return this;
    }
    public BoardHistory build(){
        return new BoardHistory(this.boardHistoryId,this.task);
    }
}
