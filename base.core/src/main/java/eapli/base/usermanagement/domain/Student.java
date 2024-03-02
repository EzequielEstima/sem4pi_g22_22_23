package eapli.base.usermanagement.domain;

import eapli.base.enrollments.domain.Enrollment;
import eapli.base.exams.domain.ExamResolution;
import eapli.framework.domain.model.AggregateRoot;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Student implements AggregateRoot<MecanographicNumber> {
    @EmbeddedId
    private MecanographicNumber mecanographicNumber;
    @Embedded
    private DateOfBirth date;
    @Embedded
    private TaxPayerNumber taxPayerNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Enrollment> enrollmentList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<ExamResolution> examResolutions = new ArrayList<>();

    public Student( MecanographicNumber mecanographicNumber, DateOfBirth date, TaxPayerNumber taxPayerNumber) {
        this.mecanographicNumber = mecanographicNumber;
        this.date = date;
        this.taxPayerNumber = taxPayerNumber;
    }


    public Student() {
        // for ORM only
    }


    public boolean compareYearMecanographicNumber(String year){
        return mecanographicNumber.compareYear(year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(mecanographicNumber, student.mecanographicNumber) && Objects.equals(date, student.date) && Objects.equals(taxPayerNumber, student.taxPayerNumber) && Objects.equals(enrollmentList, student.enrollmentList) && Objects.equals(examResolutions, student.examResolutions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mecanographicNumber, date, taxPayerNumber, enrollmentList, examResolutions);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Student)) {
            return false;
        }

        final Student that = (Student) other;

        return mecanographicNumber.equals(that.mecanographicNumber) && date.equals(that.date)
                && taxPayerNumber.equals(that.taxPayerNumber) && enrollmentList.equals(that.enrollmentList)
                && examResolutions.equals(that.examResolutions);
    }

    @Override
    public int compareTo(MecanographicNumber other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public String toString() {
        return "Student{" +
                "mecanographicNumber=" + mecanographicNumber +
                ", date=" + date +
                ", taxPayerNumber=" + taxPayerNumber +
                ", enrollmentList=" + enrollmentList +
                '}';
    }

    @Override
    public MecanographicNumber identity() {
        return this.mecanographicNumber;
    }

    @Override
    public boolean hasIdentity(MecanographicNumber id) {
        return AggregateRoot.super.hasIdentity(id);
    }

    public String returnMechanographicNumberString(){
        return mecanographicNumber.toString();
    }

    public boolean addEnrollment(Enrollment newEnrollment) {
        enrollmentList.add(newEnrollment);
        return true;
    }

    public boolean addExamResolution(ExamResolution newExamResolution){
        return examResolutions.add(newExamResolution);
    }
}
