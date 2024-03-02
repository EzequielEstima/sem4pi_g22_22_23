package eapli.base.boardhistory.domain;

public enum OperationValue {
    CREATE { @Override public String toString() { return "Create"; } },
    ADD { @Override public String toString() { return "Add"; } },
    CHANGE_POST_IT_CONTENT { @Override public String toString() { return "Change post-it content"; } },
    CHANGE_POST_IT_POSITION { @Override public String toString() { return "Change post-it position"; } },
    UNDO_CHANGE{ @Override public String toString() { return "Undo Change"; } },
    ARCHIVE{ @Override public String toString() { return "Archive"; } },
    SHARE_BOARD{@Override public String toString(){return "Share Board";}}

}
