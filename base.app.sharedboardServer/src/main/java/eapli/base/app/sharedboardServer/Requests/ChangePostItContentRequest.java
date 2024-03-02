package eapli.base.app.sharedboardServer.Requests;

import eapli.base.postitmanager.application.ChangePostItContentController;
import eapli.base.sharedBoard.SBPMessageFormat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class ChangePostItContentRequest {
    public void changePostItContent(String message, DataOutputStream outputStream) throws IOException {
        List<String> params = SBPMessageFormat.decodeParam(message.getBytes());
        try {
            new ChangePostItContentController().changePostItContent(params.get(0),Integer.parseInt(params.get(1)), Integer.parseInt(params.get(2)),params.get(3));
            outputStream.writeUTF(new String(SBPMessageFormat.createAcknowledgeRequest()));
        }catch(Exception e){
            outputStream.writeUTF(new String(SBPMessageFormat.creteErrorRequest(e.getMessage())));
        }
    }
}
