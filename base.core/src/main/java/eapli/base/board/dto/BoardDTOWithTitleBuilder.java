package eapli.base.board.dto;

public class BoardDTOWithTitleBuilder {
    private String title;

    public BoardDTOWithTitleBuilder withTitle(String title){
        this.title = title;
        return this;
    }

    public BoardDTOWithTitle build(){
        return new BoardDTOWithTitle(title);
    }
}
