package eapli.base.coursemanagement.domain;

/*
    Course status lifecycle
    close --> open --> open enrollments --> closed enrollments --> closed
    */
enum CourseStatusValue {
    CLOSE (1){ @Override public String toString() { return "Close"; } },
    OPEN (2){ @Override public String toString() { return "Open"; } },
    OPEN_ENROLLMENTS (3){ @Override public String toString() { return "Enrollments open"; } },
    CLOSED_ENROLLMENTS (4){ @Override public String toString() { return "Enrollments closed"; } },
    CLOSED (5){ @Override public String toString() { return "Closed"; } };
    final private int stateNumber;

    CourseStatusValue (int stateNumber){
        this.stateNumber = stateNumber;
    }

    public int getStateNumber() {
        return stateNumber;
    }
}
