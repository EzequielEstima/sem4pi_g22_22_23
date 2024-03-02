package eapli.base.boardparticipantmanagement.domain;

import eapli.base.exceptions.ParameterNullBlankException;
import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class BoardParticipantId  implements Comparable<BoardParticipantId>, ValueObject {
    private Long id;

    protected BoardParticipantId(Long id) throws ParameterNullBlankException {
        verifyIdentifierNotNull(id);
        this.id = id;
    }

    protected BoardParticipantId(){
        //Only for ORM
    }

    @Override
    public int compareTo(BoardParticipantId other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoardParticipantId)) return false;
        BoardParticipantId that = (BoardParticipantId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private boolean verifyIdentifierNotNull(Long id) throws ParameterNullBlankException {
        if(id == null){
            throw new ParameterNullBlankException("Id of boardParticipant cannot be null.");
        }
        return true;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
