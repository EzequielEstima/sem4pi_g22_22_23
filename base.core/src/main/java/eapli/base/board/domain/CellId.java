package eapli.base.board.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

class CellId implements Comparable<CellId>, ValueObject {

    private long cell_Id;

    protected CellId(long cellId){
        if(cellId<=0){
            throw new IllegalArgumentException("The cell id cannot be 0 or less.");
        }
        this.cell_Id = cellId;
    }

    protected CellId(){
        // for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellId cellId1 = (CellId) o;
        return Objects.equals(cell_Id, cellId1.cell_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cell_Id);
    }

    @Override
    public int compareTo(CellId o) {
        return (int)(cell_Id-o.cell_Id);
    }
}
