package eapli.base.courseclasses.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;


public class ClassId implements Comparable<ClassId>, ValueObject {

    private Long class_Id;

    public ClassId(Long class_Id) {
        if(class_Id <= 0){
            throw new IllegalArgumentException("Class identifier cannot be 0 or less");
        }
        this.class_Id = class_Id;
    }

    protected ClassId() {
        //only for ORM
    }

    @Override
    public int compareTo(ClassId o) {
        return Long.compare(this.class_Id,o.class_Id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassId classId = (ClassId) o;
        return Objects.equals(class_Id, classId.class_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(class_Id);
    }

    public long returnId() {
        return class_Id;
    }
}
