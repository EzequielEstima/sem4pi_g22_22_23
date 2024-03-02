package eapli.base.app.sharedboardServer.Requests;

import eapli.base.board.application.ArchiveBoardController;
import eapli.base.exceptions.AlreadyDeactivatedException;
import eapli.base.sharedBoard.SBPMessageFormat;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class ArchiveBoardRequest {
    public void archiveBoard(String message, DataOutputStream outputStream) throws IOException {
        List<String> archiveBoardParam = SBPMessageFormat.decodeParam(message.getBytes());
        try{
            new ArchiveBoardController().archiveBoard(archiveBoardParam.get(0));
            outputStream.writeUTF(new String(SBPMessageFormat.createAcknowledgeRequest()));
        }catch (AlreadyDeactivatedException e){
            outputStream.writeUTF(new String(SBPMessageFormat.creteErrorRequest(e.getMessage())));
        }
    }
}
