package eapli.base.courseclasses.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class Duration implements ValueObject {
    private int minDuration;

    public Duration(int minDuration) {
        if(minDuration <= 0){
            throw new IllegalArgumentException("Duration cannot be less or equal to 0");
        }
        this.minDuration = minDuration;
    }

    protected Duration() {
        //only for ORM
    }

    public int returnMinutes(){
        return minDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duration duration = (Duration) o;
        return minDuration == duration.minDuration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minDuration);
    }
}
