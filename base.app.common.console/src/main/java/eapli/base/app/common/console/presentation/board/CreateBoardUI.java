package eapli.base.app.common.console.presentation.board;

import eapli.base.board.application.CreateBoardController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class CreateBoardUI extends AbstractUI {
    private final CreateBoardController createBoardController = new CreateBoardController();
    @Override
    protected boolean doShow() {
        String boardTitle = Console.readLine("Insert Board Title:");
        int rowNumber = Console.readInteger("Insert Row number:");
        int columnNumber = Console.readInteger("Insert Column number:");

        System.out.print("\n\n");

        printInsertedInfo(boardTitle, rowNumber, columnNumber);

        System.out.print("\n");
        boolean confirmation = Console.readBoolean("Are you sure you want to create a board with this information?(y/n)");

        if (confirmation) {
            try {
                createBoardController.createBoard(boardTitle, rowNumber, columnNumber);
            } catch ( IllegalArgumentException e ) {
                System.out.println("\n[ERROR]\n");
                System.out.println(e.getMessage());
                System.out.print("\n");
            }
        }
        return true;
    }

    private void printInsertedInfo(String boardTitle, int rowNumber, int columnNumber) {
        System.out.printf("Board Tile: %s\n",boardTitle);
        System.out.printf("Row number: %d\n",rowNumber);
        System.out.printf("Column number: %d\n",columnNumber);
    }

    @Override
    public String headline() {
        return "Create Board";
    }
}
