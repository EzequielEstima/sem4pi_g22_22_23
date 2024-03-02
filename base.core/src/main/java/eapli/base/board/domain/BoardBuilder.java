package eapli.base.board.domain;

import java.util.ArrayList;
import java.util.List;

public class BoardBuilder {

    private BoardTitle boardTitle;
    private List<Cell> cellList;

    public BoardBuilder withBoardTitle(String boardTitle){
        this.boardTitle = new BoardTitle(boardTitle);
        return  this;
    }

    public BoardBuilder withCellList(long index, int rowNumber, int columnNumber){
        CellBuilder cellBuilder = new CellBuilder();
        List<Cell> cells = new ArrayList<>();

        for (int row = 1; row <= rowNumber; row++) {
            for (int column = 1; column <= columnNumber; column++) {
                index++;

                cells.add(cellBuilder.withCellId(index)
                        .withRow(row)
                        .withColumn(column)
                        .build());

            }
        }

        this.cellList = cells;
        return this;
    }

    public Board build(){
        return new Board(this.boardTitle, this.cellList);
    }
}
