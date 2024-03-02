package eapli.base.usermanagement.domain;

import eapli.base.board.domain.Board;
import eapli.base.boardparticipantmanagement.domain.BoardParticipant;
import eapli.base.exceptions.DuplicateCreationException;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Person implements AggregateRoot<ID_Person> {

    @Embedded
    private FullName fullName;

    @EmbeddedId
    private ID_Person id;


    @OneToOne(cascade = CascadeType.ALL)
    private SystemUser systemUser;

    @OneToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    private BoardOwner boardOwner;

    @OneToMany(cascade = CascadeType.REFRESH)
    private List<BoardParticipant> boardParticipantList;
    public Person(final SystemUser user, final FullName fullName, ID_Person id) {
        if (fullName == null || user == null || id == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.fullName = fullName;
        this.id =  id;
    }

    public Person(final SystemUser user, final FullName fullName, ID_Person id,Teacher teacher) {
        if (fullName == null || user == null || id == null || teacher == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.fullName = fullName;
        this.id =  id;
        this.teacher = teacher;
    }

    public Person(final SystemUser user, final FullName fullName, ID_Person id,Student student) {
        if (fullName == null || user == null || id == null || student == null) {
            throw new IllegalArgumentException();
        }
        this.systemUser = user;
        this.fullName = fullName;
        this.id =  id;
        this.student = student;
    }

    protected Person() {
        // for ORM only
    }

    public SystemUser user() {
        return this.systemUser;
    }

    public FullName fullName() {
        return this.fullName;
    }

    public String returnFullNameString(){
        return fullName.toString();
    }

    public String returnShortNameString(){
        return systemUser.name().toString();
    }
    public String returnEmailString(){
        return systemUser.email().toString();
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Person)) {
            return false;
        }

        final Person that = (Person) other;

        return Objects.equals(fullName, that.fullName) && Objects.equals(id, that.id) && Objects.equals(systemUser, that.systemUser) && Objects.equals(teacher, that.teacher) && Objects.equals(student, that.student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(fullName, person.fullName) && Objects.equals(id, person.id) && Objects.equals(systemUser, person.systemUser) && Objects.equals(teacher, person.teacher) && Objects.equals(student, person.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, id, systemUser, teacher, student);
    }

    @Override
    public int compareTo(ID_Person other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public ID_Person identity() {
        return this.id;
    }

    @Override
    public boolean hasIdentity(ID_Person id) {
        return AggregateRoot.super.hasIdentity(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName=" + fullName +
                ", id=" + id +
                ", systemUser=" + systemUser +
                '}';
    }
    public boolean isATeacher() {
        return this.teacher != null;
    }

    public boolean addBoardOwner(BoardOwner boardOwner){
        if(isBoardOwner()) return false;
        this.boardOwner=boardOwner;
        return true;
    }

    public boolean isBoardOwner(){
        if(boardOwner!=null) return true;
        return false;
    }

    public boolean addBoardParticipant(BoardParticipant participant) throws DuplicateCreationException {
        if(boardParticipantList == null){
            boardParticipantList = new ArrayList<>();
        }
        for(BoardParticipant boardParticipant : boardParticipantList){
            if(boardParticipant.returnBoardTitleString().equals(participant.returnBoardTitleString())){
                throw new DuplicateCreationException("ERROR: The person you tried to add to the board is already in your board!");
            }
        }
        boardParticipantList.add(participant);
        return true;
    }

    public boolean isBoardOwner(Board board) {
        if(boardOwner!=null){
            return boardOwner.isBoardOwner(board);
        }
        return false;
    }

    public boolean isBoardParticipant(Board board) {
        if(boardParticipantList!=null){
            for(BoardParticipant boardParticipant : boardParticipantList){
                if(boardParticipant.isBoardParticipant(board)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Gets boardParticipant Object that is participating in board
     * Used to know which board participant of a board the object person is
     * @param board the board that the person participates/owns
     * @return board participant obj, null otherwise (if null it must be board owner)
     */
    public BoardParticipant boardParticipantOfBoard(Board board) {
        if (boardParticipantList != null) {
            for (BoardParticipant bp : boardParticipantList){
                if (bp.isBoardParticipant(board)){
                    return bp;
                }
            }
        }
        return null;
    }

    /**
     * Gets board owner Object that is participating in board
     * Used to know which board owner of a board the object person is
     * @param board the board that the person participates/owns
     * @return board owner obj, null otherwise (if null it must be board participant)
     */
    public BoardOwner boardOwnerOfBoard(Board board) {
        if (boardOwner != null) {
            if (boardOwner.isBoardOwner(board)){
                return boardOwner;
            }
        }
        return null;
    }
}
