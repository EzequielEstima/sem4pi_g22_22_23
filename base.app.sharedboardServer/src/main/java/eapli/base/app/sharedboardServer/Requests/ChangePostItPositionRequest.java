package eapli.base.app.sharedboardServer.Requests;

import eapli.base.postitmanager.application.ChangePostItPositionController;
import eapli.base.sharedBoard.SBPMessageFormat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class ChangePostItPositionRequest {
    public void changePostItPosition(String message, DataOutputStream outputStream) throws IOException {
        List<String> params = SBPMessageFormat.decodeParam(message.getBytes());
        try {
            new ChangePostItPositionController().changePostItPosition(params.get(0),Integer.parseInt(params.get(1)), Integer.parseInt(params.get(2)),Integer.parseInt(params.get(3)), Integer.parseInt(params.get(4)));
            outputStream.writeUTF(new String(SBPMessageFormat.createAcknowledgeRequest()));
        }catch(Exception e){
            outputStream.writeUTF(new String(SBPMessageFormat.creteErrorRequest(e.getMessage())));
        }
    }
}
