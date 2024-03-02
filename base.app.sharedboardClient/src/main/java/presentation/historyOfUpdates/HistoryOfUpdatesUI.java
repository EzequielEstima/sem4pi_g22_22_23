package presentation.historyOfUpdates;

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

public class HistoryOfUpdatesUI extends AbstractUI {
    private Socket socket;
    public HistoryOfUpdatesUI(Socket socket){
        this.socket = socket;
    }
    @Override
    protected boolean doShow() {
        DataOutputStream dos;
        DataInputStream dis;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(new String(SBPMessageFormat.createListAllBoardsIParticipateAndCanRead()));
            dis = new DataInputStream(socket.getInputStream());
            String message = dis.readUTF();
            if(SBPMessageFormat.decodeFormat(message.getBytes())[SBPMessageFormat.CODE_OFFSET] == SBPMessageFormat.LIST_BOARD) {
                List<String> boardList = SBPMessageFormat.decodeParam(message.getBytes());
                if (!boardList.isEmpty()) {
                    SelectWidget<String> selected = new SelectWidget<>("Select the board.", boardList, new StringPrinter());
                    selected.show();
                    if(selected.selectedOption() != 0){
                        String board = selected.selectedElement();
                        byte[] historyOfUpdatesRequest = SBPMessageFormat.createHistoryOfUpdatesRequest(board);
                        dos.writeUTF(new String(historyOfUpdatesRequest));
                        String taskListMessage = dis.readUTF();
                        if(SBPMessageFormat.decodeFormat(taskListMessage.getBytes())[SBPMessageFormat.CODE_OFFSET] == SBPMessageFormat.TASK_LIST_CODE){
                            List<String> taskList = SBPMessageFormat.decodeParam(taskListMessage.getBytes());
                            int size = taskList.size();

                            System.out.printf("\nHistory Of Updates of board %s:\n", board);
                            System.out.println("(Type of Operation | Author | Operation Additional Info)");
                            for(int i = 0; i<size; i++){
                                System.out.printf("%d. %s\n", i+1, taskList.get(i).toString());
                            }

                        } else {
                            List<String> errorMessage = SBPMessageFormat.decodeParam(message.getBytes());
                            System.out.println(errorMessage.get(0));
                        }
                    }
                }else{
                    System.out.printf("Sorry, you don't participate in any boards.\n\n");
                }
            }
        } catch (IOException e) {
            System.out.printf("Your connection to the server has been lost.\n\n");
        }
        return false;
    }

    @Override
    public String headline() {
        return "History Of Updates";
    }
}
