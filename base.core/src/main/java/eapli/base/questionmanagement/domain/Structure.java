package eapli.base.questionmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class Structure implements ValueObject {
    private String structure;

    public Structure(String structure) {
        this.structure = structure;
    }

    public Structure(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Structure)) return false;
        Structure structure1 = (Structure) o;
        return Objects.equals(structure, structure1.structure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(structure);
    }

    @Override
    public String toString() {
        return structure;
    }
}
