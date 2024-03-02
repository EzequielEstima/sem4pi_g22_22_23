package eapli.base.enrollments.domain;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.usermanagement.domain.Student;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class Enrollment implements AggregateRoot<EnrollmentId> {
    @Id
    private EnrollmentId enrollmentId;

    private EnrollmentStatus enrollmentStatus;
    @ManyToOne
    @JoinColumn
    private Course course;
    @ManyToOne
    @JoinColumn
    private Student student;

    protected Enrollment() {
        //only for ORM
    }

    public Enrollment(EnrollmentId enrollmentId, EnrollmentStatus enrollmentStatus, Course course, Student student) {
        this.enrollmentId = enrollmentId;
        this.enrollmentStatus = enrollmentStatus;
        this.course = course;
        this.student = student;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Enrollment)) {
            return false;
        }

        final Enrollment that = (Enrollment) other;

        return enrollmentId.equals(that.enrollmentId) && enrollmentStatus.equals(that.enrollmentStatus);
    }

    @Override
    public EnrollmentId identity() {
        return this.enrollmentId;
    }

    public boolean changeStatus(String newStatus){
        if(!enrollmentStatus.returnEnrollmentStatusString().equalsIgnoreCase(newStatus) && enrollmentStatus.returnEnrollmentStatusString().equalsIgnoreCase("Pending")){
            this.enrollmentStatus = new EnrollmentStatus(EnrollmentStatusValue.valueOf(newStatus));
            return true;
        }
        throw new IllegalArgumentException("The status of the enrollment cannot change to that one!");
    }

    public String returnEnrollmentStatusString(){
        return enrollmentStatus.returnEnrollmentStatusString();
    }
}
