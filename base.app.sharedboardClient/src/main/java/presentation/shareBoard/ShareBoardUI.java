package presentation.shareBoard;

import eapli.base.sharedBoard.SBPMessageFormat;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ShareBoardUI extends AbstractUI {
    private final Socket socket;
    public ShareBoardUI (Socket socket){
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
            if(SBPMessageFormat.decodeFormat(message.getBytes())[SBPMessageFormat.CODE_OFFSET] == SBPMessageFormat.LIST_BOARD){
                List<String> boardList = SBPMessageFormat.decodeParam(message.getBytes());
                if(!boardList.isEmpty()){
                    SelectWidget<String> selected = new SelectWidget<>("Select the board.", boardList, new StringPrinter());
                    selected.show();
                    if(selected.selectedOption() != 0){
                        String board = selected.selectedElement();
                        String email = Console.readLine("Please insert the e-mail of the person you intend to share the board with.");
                        List<String> optionList = new ArrayList<>();
                        optionList.add("Read and Write");
                        optionList.add("Read Only");
                        selected = new SelectWidget<>("Select the permission that the person will have on your board.", optionList, new StringPrinter());
                        selected.show();
                        if(selected.selectedOption() != 0) {
                            String permissionString = selected.selectedElement();
                            StringBuilder strBuilder = new StringBuilder();
                            System.out.println("Do you want to proceed? (y/n)");
                            strBuilder.append("Board: ");
                            strBuilder.append(board);
                            System.out.println(strBuilder);
                            strBuilder = new StringBuilder();
                            strBuilder.append("Person's email: ");
                            strBuilder.append(email);
                            System.out.println(strBuilder);
                            strBuilder = new StringBuilder();
                            strBuilder.append("Permission: ");
                            strBuilder.append(permissionString);
                            boolean proceed = Console.readBoolean(strBuilder.toString());
                            if (proceed) {
                                if (permissionString.equals("Read and Write")) {
                                    dos.writeUTF(new String(SBPMessageFormat.createShareBoardRequest(board, email, "t")));
                                } else {
                                    dos.writeUTF(new String(SBPMessageFormat.createShareBoardRequest(board, email, "f")));
                                }
                                message = dis.readUTF();
                                if (SBPMessageFormat.decodeFormat(message.getBytes())[SBPMessageFormat.CODE_OFFSET] == SBPMessageFormat.ACK_CODE) {
                                    System.out.println("Operation success!");
                                } else {
                                    List<String> errorMessage = SBPMessageFormat.decodeParam(message.getBytes());
                                    System.out.println(errorMessage.get(0));
                                }
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
        return "Share Board";
    }
}
