package eapli.base.app.sharedboardServer.Requests;

import eapli.base.board.application.ShareBoardController;
import eapli.base.exceptions.DuplicateCreationException;
import eapli.base.exceptions.ParameterNullBlankException;
import eapli.base.sharedBoard.SBPMessageFormat;
import javax.persistence.NoResultException;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class ShareBoardRequest {
    public void shareBoard(String message, DataOutputStream outputStream) throws IOException{
        List<String> shareBoardParams = SBPMessageFormat.decodeParam(message.getBytes());
        boolean permission;
        if (shareBoardParams.get(2).equals("t")) {
            permission = true;
        } else {
            permission = false;
        }
        try {
            new ShareBoardController().shareBoard(shareBoardParams.get(0), shareBoardParams.get(1), permission);
            outputStream.writeUTF(new String(SBPMessageFormat.createAcknowledgeRequest()));
        }catch (DuplicateCreationException | ParameterNullBlankException e){
            outputStream.writeUTF(new String(SBPMessageFormat.creteErrorRequest(e.getMessage())));
        }catch (NoResultException e){
            outputStream.writeUTF(new String(SBPMessageFormat.
                    creteErrorRequest("ERROR: There are no people in the system with that e-mail")));
        }
    }
}
