package eapli.base.coursemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class Description implements ValueObject {
    private String description;

    public Description(String description) {
        if(validateCourseDescriptionString(description)){
            this.description = description;
        }
    }

    private boolean validateCourseDescriptionString(String description) {
        return ensureDescriptionIsNotNull(description) &&
                ensureDescriptionIsNotEmpty(description) &&
                ensureDescriptionIsNotBlank(description);
    }

    private boolean ensureDescriptionIsNotNull(String description) {
        if (description == null){
            throw new IllegalArgumentException("Course description cannot be null");
        }
        return true;
    }

    private boolean ensureDescriptionIsNotEmpty(String description) {
        if (description.isEmpty()){
            throw new IllegalArgumentException("Course description cannot be empty");
        }
        return true;
    }

    private boolean ensureDescriptionIsNotBlank(String description) {
        if (description.isBlank()){
            throw new IllegalArgumentException("Course description cannot be blank");
        }
        return true;
    }

    protected Description() {
        //only for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}
