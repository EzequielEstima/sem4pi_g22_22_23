package eapli.base.board.dto;

public class CellDTOWithColumnRowPostItCreatorBuilder {


    private String rowIdentifier;
    private String rowTitle;
    private String columnIdentifier;
    private String columnTitle;
    private String content;

    public String date;

    public String email;

    public String name;

    public CellDTOWithColumnRowPostItCreatorBuilder withRowTitle(String title){
        this.rowTitle = title;
        return this;
    }
    public CellDTOWithColumnRowPostItCreatorBuilder withRowIdentifier(String identifier){
        this.rowIdentifier = identifier;
        return this;
    }
    public CellDTOWithColumnRowPostItCreatorBuilder withColumnTitle(String title){
        this.columnTitle = title;
        return this;
    }
    public CellDTOWithColumnRowPostItCreatorBuilder withColumnIdentifier(String identifier){
        this.columnIdentifier = identifier;
        return this;
    }
    public CellDTOWithColumnRowPostItCreatorBuilder withContent(String content){
        this.content = content;
        return this;
    }

    public CellDTOWithColumnRowPostItCreatorBuilder withDate(String date){
        this.date = date;
        return this;
    }

    public CellDTOWithColumnRowPostItCreatorBuilder withEmail(String email){
        this.email = email;
        return this;
    }

    public CellDTOWithColumnRowPostItCreatorBuilder withName(String name){
        this.name = name;
        return this;
    }


    public CellDTOWithColumnRowPostItCreator build(){
        return new CellDTOWithColumnRowPostItCreator(rowIdentifier,rowTitle,columnIdentifier,columnTitle,content, date,email,name);
    }

}
