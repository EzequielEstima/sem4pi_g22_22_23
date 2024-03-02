package presentation.postIt;

import eapli.base.sharedBoard.SBPMessageFormat;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import presentation.shareBoard.StringPrinter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class ChangePostItContentUI extends AbstractUI {
    private final Socket socket;

    public ChangePostItContentUI(Socket socket) {
        this.socket = socket;
    }

    @Override
    protected boolean doShow() {
        DataOutputStream dos;
        DataInputStream dis;
        try{
            dos = new DataOutputStream(socket.getOutputStream());
            // request the list of boards that the user participates
            dos.writeUTF(new String(SBPMessageFormat.createListBoardIParticipateRequestSend()));
            dis = new DataInputStream(socket.getInputStream());
            // receive the list of boards that the user participates
            String message = dis.readUTF();
            if (SBPMessageFormat.decodeFormat(message.getBytes())[SBPMessageFormat.CODE_OFFSET]
                    == SBPMessageFormat.LIST_BOARD_I_PARTICIPATE_RCV) {

                // decode the message
                List<String> boardList = SBPMessageFormat.decodeParam(message.getBytes());
                if (boardList.isEmpty()){
                    System.out.println("[ERROR]\n");
                    System.out.println("You are not participating in any board at this moment");
                    return false;
                }

                // Show boards and select one
                SelectWidget<String> selector = new SelectWidget<>("Please select the board", boardList, new StringPrinter());
                selector.show();

                String selectedBoard = selector.selectedElement();
                if (selectedBoard == null){
                    return false;
                }
                int row = Console.readInteger("Select the row");
                int column = Console.readInteger("Select the column");
                String content = Console.readLine("Insert the text of the post-it or insert the path of a file to upload a image");
                while (content.isEmpty() || content.isBlank()) {
                    content =Console.readLine("Insert the text of the post-it or insert the path of a file to upload a image");
                }

                dos.writeUTF(new String(SBPMessageFormat.createChangePostItContentRequest(selectedBoard,content,row,column)));
                message = dis.readUTF();
                if(SBPMessageFormat.decodeFormat(message.getBytes())[SBPMessageFormat.CODE_OFFSET] == SBPMessageFormat.ACK_CODE){
                    System.out.println("Operation success!");
                } else {
                    List<String> errorMessage = SBPMessageFormat.decodeParam(message.getBytes());
                    System.out.println(errorMessage.get(0));
                }


            }

        } catch (IOException e) {
            System.out.println("Your connection to the server has been lost.\n");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Change post-it content";
    }
}
