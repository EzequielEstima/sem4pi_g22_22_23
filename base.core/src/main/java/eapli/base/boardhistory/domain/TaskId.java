package eapli.base.boardhistory.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class TaskId implements Comparable<TaskId>, ValueObject {

    private Long task_Id;

    protected TaskId(long task_Id){
        if(task_Id<=0){
            throw new IllegalArgumentException("The task id cannot be 0 or less.");
        }
        this.task_Id = task_Id;
    }

    protected TaskId(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskId taskId = (TaskId) o;
        return task_Id == taskId.task_Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(task_Id);
    }

    @Override
    public int compareTo(TaskId o) {
        return (int)(task_Id-o.task_Id);
    }

    public String returnTaskIdString(){
        return task_Id.toString();
    }
}

