package eapli.base.app.sharedboardServer.Requests;

import eapli.base.board.application.HistoryOfUpdatesController;
import eapli.base.sharedBoard.SBPMessageFormat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class HistoryOfUpdatesRequest {

    public void historyOfUpdates(String message, DataOutputStream outputStream) throws IOException {
        List<String> boardParam = SBPMessageFormat.decodeParam(message.getBytes());
        try {
            List<String> taskList = new HistoryOfUpdatesController().historyOfUpdates(boardParam.get(0));
            byte[] taskListRequest = SBPMessageFormat.createTaskListRequest(taskList);
            outputStream.writeUTF(new String(taskListRequest));
        }catch (Exception e){
            outputStream.writeUTF(new String(SBPMessageFormat.creteErrorRequest(e.getMessage())));
        }
    }
}
