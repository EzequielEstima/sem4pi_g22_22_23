package eapli.base.courseclasses.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class ExtraClassId implements Comparable<ExtraClassId>, ValueObject {

    private Long extraClass_id;

    public ExtraClassId(Long extraClass_id) {
        if(extraClass_id < 0){
            throw new IllegalArgumentException("Extra class identifier cannot be 0 or less");
        }
        this.extraClass_id = extraClass_id;
    }

    protected ExtraClassId() {
        //only for ORM
    }

    @Override
    public int compareTo(ExtraClassId o) {
        return Long.compare(this.extraClass_id, o.extraClass_id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtraClassId that = (ExtraClassId) o;
        return Objects.equals(extraClass_id, that.extraClass_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(extraClass_id);
    }
}
