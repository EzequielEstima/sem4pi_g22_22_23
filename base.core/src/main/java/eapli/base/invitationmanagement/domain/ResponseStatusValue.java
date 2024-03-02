package eapli.base.invitationmanagement.domain;

public enum ResponseStatusValue {

    PENDING (1){ @Override public String toString() { return "Pending"; } },
    ACCEPTED (2){ @Override public String toString() { return "Accepted"; } },
    REJECTED (3){ @Override public String toString() { return "Rejected"; } };
    final private int state;
    ResponseStatusValue (int stateNumber){
        this.state = stateNumber;
    }

    public int getState() {
        return state;
    }
}
