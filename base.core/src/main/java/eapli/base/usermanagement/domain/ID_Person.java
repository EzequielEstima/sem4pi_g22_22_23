package eapli.base.usermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class ID_Person implements ValueObject, Comparable<ID_Person>{

    private int id_person;

    public ID_Person(int number) {
        if (number <= 0 ) {
            throw new IllegalArgumentException(
                    "ID number must be greater than 0");
        }
        this.id_person = number;
    }

    protected ID_Person() {
        // for ORM
    }

    public static TaxPayerNumber valueOf(final int taxPayerNumber) {
        return new TaxPayerNumber(taxPayerNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ID_Person that = (ID_Person) o;
        return id_person == that.id_person;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_person);
    }

    @Override
    public String toString() {
        return "ID_Person{" +
                "id_person=" + id_person +
                '}';
    }


    @Override
    public int compareTo(ID_Person o) {
        return Integer.compare(id_person, o.id_person);
    }
}
