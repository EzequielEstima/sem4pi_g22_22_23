package eapli.base.board.domain;

public class CellBuilder {

    private CellId cellId;
    private Row row;
    private Column column;

    public CellBuilder withCellId(long cellId){
       this.cellId = new CellId(cellId);
       return this;
    }

    public CellBuilder withRow(int rowIdentifier){
        this.row = new Row(new RowIdentifier(rowIdentifier));
        return this;
    }

    public CellBuilder withColumn(int columnIdentifier){
        this.column = new Column(new ColumnIdentifier(columnIdentifier));
        return this;
    }

    protected Cell build(){
        return new Cell(cellId, row, column);
    }
}
