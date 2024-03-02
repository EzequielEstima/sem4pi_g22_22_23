package presentation.postIt;

import eapli.base.sharedBoard.SBPMessageFormat;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import presentation.shareBoard.StringPrinter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.List;

public class CreatePostItUI extends AbstractUI {

    private final Socket socket;
    public CreatePostItUI(Socket socket){
        this.socket = socket;
    }

    @Override
    protected boolean doShow() {
        DataOutputStream dos;
        DataInputStream dis;
        try {

            dos = new DataOutputStream(socket.getOutputStream());
            // request the list of boards that the user participates
            dos.writeUTF(new String(SBPMessageFormat.createListBoardIParticipateRequestSend()));
            dis = new DataInputStream(socket.getInputStream());
            // receive the list of boards that the user participates
            String message = dis.readUTF();

            // decode the format of the message
            if (SBPMessageFormat.decodeFormat(message.getBytes())[SBPMessageFormat.CODE_OFFSET]
                    == SBPMessageFormat.LIST_BOARD_I_PARTICIPATE_RCV) {

                // decode the message
                List<String> boardList = SBPMessageFormat.decodeParam(message.getBytes());
                if (!boardList.isEmpty()) {
                        String board = showBoardList(boardList);
                        // verify if the user wants to create a post-it in the selected board
                        if(board != null){
                            // request the number of columns of the board
                            dos.writeUTF(new String(SBPMessageFormat.createShowNumberOfCellsRequestSend(board)));
                            // receive the number of columns of the board
                            message = dis.readUTF();

                            if (SBPMessageFormat.decodeFormat(message.getBytes())[SBPMessageFormat.CODE_OFFSET]
                                    == SBPMessageFormat.NUMBER_OF_CELLS_REQUEST_RCV) {
                                // decode the message
                                List<String> data = SBPMessageFormat.decodeParam(message.getBytes());
                                int column = Integer.parseInt(data.get(0));
                                int row = Integer.parseInt(data.get(1));
                                // show the maximum number of columns and rows of the board
                                System.out.println("The board has " + column + " columns and " + row + " rows.");

                                // request the column and row of the post-it
                                int selectedColumn = Console.readInteger("Select column");
                                while (selectedColumn > column || selectedColumn < 1) {
                                    System.out.println("Invalid column.");
                                    selectedColumn = Console.readInteger("Select column");
                                }
                                int selectedRow = Console.readInteger("Select row");
                                while (selectedRow > row || selectedRow < 1) {
                                    System.out.println("Invalid row.");
                                    selectedRow = Console.readInteger("Select row");
                                }
                                // request the text of the post-it
                                String data2 = Console.readLine("Insert the text of the post-it or insert the path of a file to upload a image");
                                while (data2.isEmpty()||data2.isBlank()) {
                                    data2 =Console.readLine("Insert the text of the post-it or insert the path of a file to upload a image");
                                }

                                // request the creation of the post-it
                                dos.writeUTF(new String(SBPMessageFormat.createPostItRequest(board,data2,selectedColumn,selectedRow)));
                                message = dis.readUTF();
                                if(SBPMessageFormat.decodeFormat(message.getBytes())[SBPMessageFormat.CODE_OFFSET] == SBPMessageFormat.ACK_CODE){
                                    System.out.println("Operation success!");
                                } else {
                                    List<String> errorMessage = SBPMessageFormat.decodeParam(message.getBytes());
                                    System.out.println(errorMessage.get(0));
                                }
                            }

                        }
                    }

                }
        } catch (Exception e) {
            System.out.println("Your connection to the server has been lost.");
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Create Post-It";
    }
    private String showBoardList(List<String> boardList) {
        // show the list of boards that the user participates
        SelectWidget<String> selected = new SelectWidget<>("Select the board.", boardList, new StringPrinter());
        selected.show();
        if (selected.selectedOption() != 0) {
            String board = selected.selectedElement();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Are you sure you want to create a Post-It in this Board ");
            stringBuilder.append(board);
            stringBuilder.append("?");
            if (Console.readBoolean(stringBuilder.toString())) {
                return board;
            }
        }
        return null;
    }


}
