package eapli.base.enrollments.domain;
/*
    Enrollment status lifecycle
    Pending --> accepted or Pending --> rejected
    */
public enum EnrollmentStatusValue{
    PENDING{ @Override public String toString() { return "Pending"; } },
    ACCEPTED{ @Override public String toString() { return "Accepted"; } },
    REJECTED{ @Override public String toString() { return "Rejected"; } }
}
