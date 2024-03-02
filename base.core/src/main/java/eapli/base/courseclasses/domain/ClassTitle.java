package eapli.base.courseclasses.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;

public class ClassTitle implements ValueObject {

    private String class_tile;

    public ClassTitle(String class_tile) {
        if(StringPredicates.isNullOrEmpty(class_tile)){
            throw new IllegalArgumentException("Class title cannot be null");
        }
        if(class_tile.isBlank()){
            throw new IllegalArgumentException("Class title cannot be blank");
        }
        this.class_tile = class_tile;
    }

    protected ClassTitle() {
        //only for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassTitle that = (ClassTitle) o;
        return Objects.equals(class_tile, that.class_tile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(class_tile);
    }

    public String returnTittle() {
        return class_tile;
    }

}
