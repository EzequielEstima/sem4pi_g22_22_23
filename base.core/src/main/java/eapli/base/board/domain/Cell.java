package eapli.base.board.domain;

import eapli.base.postitmanager.domain.PostIt;

import javax.persistence.*;

@Entity
public class Cell implements Comparable<Cell>{
    @EmbeddedId
    private CellId cellId;
    private Row row;
    private Column column;

    @OneToOne(cascade = CascadeType.ALL)
    private PostIt postIt;

    protected Cell(CellId cellId, Row row, Column column){
        if(cellId == null || row == null || column == null){
            throw new IllegalArgumentException("The cell cannot be created with null Value Objects");
        }
        this.cellId = cellId;
        this.row = row;
        this.column = column;
    }

    protected Cell(){
        // Only for ORM
    }

    public String returnRowTitleString() {
        return row.returnRowTitleString();
    }

    public String returnRowIdentifierString() {
        return row.returnRowIdentifierString();
    }

    public String returnColumnTitleString() {
        return column.returnColumnTitleString();
    }

    public String returnColumnIdentifierString() {
        return column.returnColumnIdentifierString();
    }

    public String returnPostItContentString(){
        if (postIt == null) return " ";
        return postIt.returnContentString();
    }

    public String returnPostItDateString(){
        if (postIt == null) return " ";
        return postIt.returnDateString();
    }

    @Override
    public int compareTo(Cell o) {
        return this.cellId.compareTo(o.cellId);
    }

    public void addPostIt(PostIt postIt) {
        this.postIt = postIt;
    }
    public boolean isColumn(int column) {
        return this.column.returnColumnIdentifierString().equals(Integer.toString(column));
    }
    public boolean isRow(int row) {
        return this.row.returnRowIdentifierString().equals(Integer.toString(row));
    }
    public boolean hasPostIt() {
        return this.postIt != null;
    }

    public PostIt currentPostIt() {
        return this.postIt;
    }

    public void removePostIt() {
        this.postIt = null;
    }
}
