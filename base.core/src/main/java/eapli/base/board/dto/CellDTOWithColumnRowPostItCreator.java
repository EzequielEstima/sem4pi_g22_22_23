package eapli.base.board.dto;

public class CellDTOWithColumnRowPostItCreator {

    public String rowIdentifier;
    public String rowTitle;
    public String columnIdentifier;
    public String columnTitle;
    public String content;
    public String date;
    public String email;
    public String name;

    public CellDTOWithColumnRowPostItCreator(String rowIdentifier, String rowTitle, String columnIdentifier, String columnTitle, String content, String date, String email, String name) {
        this.rowIdentifier = rowIdentifier;
        this.rowTitle = rowTitle;
        this.columnIdentifier = columnIdentifier;
        this.columnTitle = columnTitle;
        this.content = content;
        this.date = date;
        this.email = email;
        this.name = name;
    }

    @Override
    public String toString() {
        return rowIdentifier + ',' +
                rowTitle + ',' +
                columnIdentifier + ',' +
                columnTitle + ',' +
                content + ',' +
                date + ',' +
                email + ',' +
                name;
    }
}
