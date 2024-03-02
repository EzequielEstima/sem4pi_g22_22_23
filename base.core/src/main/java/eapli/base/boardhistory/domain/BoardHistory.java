package eapli.base.boardhistory.domain;

import eapli.base.boardparticipantmanagement.domain.BoardParticipant;
import eapli.base.postitmanager.domain.PostIt;
import eapli.base.usermanagement.domain.BoardOwner;
import eapli.framework.domain.model.AggregateRoot;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BoardHistory implements AggregateRoot<BoardHistoryId> {
    @EmbeddedId
    private BoardHistoryId boardHistoryId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Task> taskList = new ArrayList<>();

    protected BoardHistory(BoardHistoryId boardHistoryId, Task task){
        if(boardHistoryId == null | task == null){
            throw new IllegalArgumentException("The board history cannot be created with null Value Objects");
        }
        this.boardHistoryId = boardHistoryId;
        addTask(task);
    }

    protected BoardHistory(){

    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof BoardHistory)) {
            return false;
        }

        final BoardHistory that = (BoardHistory) other;

        return this.boardHistoryId.equals(that.boardHistoryId);
    }

    @Override
    public BoardHistoryId identity() {
        return boardHistoryId;
    }

    public boolean addTask(Task task){
        if(taskList.contains(task)){
            throw new IllegalArgumentException("The History already has this task.");
        }
        taskList.add(task);
        return true;
    }

    public boolean checkIfPostItCanBeUpdatedByUser(PostIt currentPostIt, BoardParticipant boardParticipant, BoardOwner boardOwner) {
        for (Task task : taskList){
            if (task.isAddPostIt() && task.isInThisPostIt(currentPostIt)){
                if (boardParticipant == null){
                    return task.isDoneByThisOwner(boardOwner);
                } else if (boardOwner == null) {
                    return task.isDoneByThisParticipant(boardParticipant);
                }
            }
        }
        return false;
    }
}
