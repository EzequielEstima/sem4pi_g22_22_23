package presentation.archiveBoard;

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

public class ArchiveBoardUI extends AbstractUI {
    private final Socket socket;
    public ArchiveBoardUI(Socket socket){
        this.socket = socket;
    }
    @Override
    protected boolean doShow() {
        DataOutputStream dos;
        DataInputStream dis;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(new String(SBPMessageFormat.createListBoardIOwnRequestSend()));
            dis = new DataInputStream(socket.getInputStream());
            String message = dis.readUTF();
            if(SBPMessageFormat.decodeFormat(message.getBytes())[SBPMessageFormat.CODE_OFFSET] == SBPMessageFormat.LIST_BOARD) {
                List<String> boardList = SBPMessageFormat.decodeParam(message.getBytes());
                if (!boardList.isEmpty()) {
                    SelectWidget<String> selected = new SelectWidget<>("Select the board.", boardList, new StringPrinter());
                    selected.show();
                    if(selected.selectedOption() != 0){
                        String board = selected.selectedElement();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Are you sure you want to archive the board ");
                        stringBuilder.append(board);
                        stringBuilder.append("? (y/n)");
                        boolean proceed = Console.readBoolean(stringBuilder.toString());
                        if(proceed){
                            byte[] archiveBoardRequest = SBPMessageFormat.createArchiveBoardRequest(board);
                            dos.writeUTF(new String(archiveBoardRequest));
                            message = dis.readUTF();
                            if(SBPMessageFormat.decodeFormat(message.getBytes())[SBPMessageFormat.CODE_OFFSET] == SBPMessageFormat.ACK_CODE){
                                System.out.println("Operation success!");
                            } else {
                                List<String> errorMessage = SBPMessageFormat.decodeParam(message.getBytes());
                                System.out.println(errorMessage.get(0));
                            }
                        }
                    }
                }else{
                    System.out.printf("Sorry, you don't own any boards.\n\n");
                }
            }
        } catch (IOException e) {
            System.out.printf("Your connection to the server has been lost.\n\n");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Archive Board";
    }
}
