package eapli.base.usermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class Acronym implements ValueObject, Comparable<Acronym> {

    private String acronym;


    public Acronym(String acronym) {
        if (StringPredicates.isNullOrEmpty(acronym)) {
            throw new IllegalArgumentException(
                    "Acronym should neither be null nor empty");
        }
        if (acronym.length() != 3){
            throw new IllegalArgumentException(
                    "Acronym should have 3 digits");
        }
        if (!acronym.matches("[A-Z]+")) {
            throw new IllegalArgumentException(
                    "Acronym should have all 3 digits in Upper Case");
        }

        this.acronym = acronym;
    }

    public static Acronym valueOf(final String acronym) {
        return new Acronym(acronym);
    }


    protected Acronym() {
        // for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acronym acronym1 = (Acronym) o;
        return Objects.equals(acronym, acronym1.acronym);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acronym);
    }

    @Override
    public String toString() {
        return acronym;
    }

    @Override
    public int compareTo(Acronym o) {
        return acronym.compareTo(o.acronym);

    }
}
