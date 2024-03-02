package eapli.base.boardparticipantmanagement.domain;

import eapli.base.board.domain.Board;
import eapli.base.exceptions.ParameterNullBlankException;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class BoardParticipant implements AggregateRoot<BoardParticipantId> {
    @EmbeddedId
    private BoardParticipantId boardParticipantId;
    private Permission permission;
    @OneToOne
    private Board board;

    protected BoardParticipant(BoardParticipantId boardParticipantId, Permission permission, Board board) throws ParameterNullBlankException {
        verifyNullBlankParameters(boardParticipantId, permission, board);
        this.boardParticipantId = boardParticipantId;
        this.permission = permission;
        this.board = board;
    }

    protected BoardParticipant() {
        //only for ORM
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof BoardParticipant)) {
            return false;
        }
        final BoardParticipant that = (BoardParticipant) other;

        return boardParticipantId.equals(that.boardParticipantId) && board.equals(that.board);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardParticipant that = (BoardParticipant) o;
        return Objects.equals(boardParticipantId, that.boardParticipantId) && Objects.equals(permission, that.permission) && Objects.equals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardParticipantId, permission, board);
    }

    public String returnBoardTitleString(){
        return board.returnBoardTitleString();
    }
    @Override
    public BoardParticipantId identity() {
        return null;
    }

    public boolean verifyNullBlankParameters(BoardParticipantId boardParticipantId, Permission permission, Board board) throws ParameterNullBlankException {
        if(boardParticipantId == null){
            throw new ParameterNullBlankException("BoardParticipantId cannot be null");
        }
        if(permission == null){
            throw new ParameterNullBlankException("The permission needs to be assigned.");
        }
        if(board == null){
            throw new ParameterNullBlankException("A board needs to be chosen.");
        }
        return true;
    }

    public boolean hasWritePermission() {
        return permission.hasWritePermission();
    }

    public boolean isBoardParticipant(Board board) {
        return this.board.equals(board);
    }

    @Override
    public String toString() {
        return boardParticipantId.toString();
    }
}
