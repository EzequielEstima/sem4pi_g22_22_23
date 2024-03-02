package eapli.base.usermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class FullName implements ValueObject, Comparable<FullName> {

    private String fullname;

    public FullName(String fullname) {
        if (StringPredicates.isNullOrEmpty(fullname)) {
            throw new IllegalArgumentException(
                    "Full name should neither be null nor empty");
        }

        this.fullname = fullname;
    }

    public static FullName valueOf(final String fullname) {
        return new FullName(fullname);
    }


    protected FullName() {
        // for ORM
    }

    @Override
    public String toString() {
        return fullname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName = (FullName) o;
        return Objects.equals(fullname, fullName.fullname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullname);
    }

    @Override
    public int compareTo(FullName o) {
        return fullname.compareTo(o.fullname);
    }
}
