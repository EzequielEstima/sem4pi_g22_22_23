package eapli.base.formativeexams.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class FormativeStructure implements ValueObject {

    private String formative_Structure;

    public FormativeStructure(String formative_Structure) {
        if(StringPredicates.isNullOrEmpty(formative_Structure)){
            throw new IllegalArgumentException("Exam specification cannot be null or empty");
        }
        if(formative_Structure.isBlank()){
            throw new IllegalArgumentException("Exam specification cannot be blank");
        }
        this.formative_Structure = formative_Structure;
    }

    protected FormativeStructure() {
        //only for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormativeStructure that = (FormativeStructure) o;
        return Objects.equals(formative_Structure, that.formative_Structure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formative_Structure);
    }

    public String returnSpecification(){
        return this.formative_Structure;
    }

}
