package eapli.base.usermanagement.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;


@Entity
public class Teacher implements AggregateRoot<Acronym> {

    @EmbeddedId
    private Acronym acronym;

    @Embedded
    private DateOfBirth date;

    @Embedded
    private TaxPayerNumber taxPayerNumber;

    public Teacher( Acronym acronym, DateOfBirth date, TaxPayerNumber taxPayerNumber) {
        if(acronym==null||date==null||taxPayerNumber==null){
            throw new IllegalArgumentException("parameters cannot be null");
        }
        this.acronym = acronym;
        this.date = date;
        this.taxPayerNumber = taxPayerNumber;
    }


    public Teacher() {
        // for ORM only
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(acronym, teacher.acronym) && Objects.equals(date, teacher.date) && Objects.equals(taxPayerNumber, teacher.taxPayerNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acronym, date, taxPayerNumber);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Teacher)) {
            return false;
        }

        final Teacher that = (Teacher) other;

        return acronym.equals(that.acronym) && date.equals(that.date) && taxPayerNumber.equals(that.taxPayerNumber);
    }

    @Override
    public int compareTo(Acronym other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "acronym=" + acronym +
                ", date=" + date +
                ", taxPayerNumber=" + taxPayerNumber +
                '}';
    }

    @Override
    public Acronym identity() {
        return this.acronym;
    }

    @Override
    public boolean hasIdentity(Acronym id) {
        return AggregateRoot.super.hasIdentity(id);
    }

    public String returnAcronymString() {
        return this.acronym.toString();
    }
}
