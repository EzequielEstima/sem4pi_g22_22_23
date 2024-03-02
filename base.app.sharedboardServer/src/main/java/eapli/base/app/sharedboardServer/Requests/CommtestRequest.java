package eapli.base.app.sharedboardServer.Requests;

import eapli.base.sharedBoard.SBPMessageFormat;
import java.io.DataOutputStream;
import java.io.IOException;

public class CommtestRequest {
    public void test(DataOutputStream outputStream) throws IOException {
        outputStream.writeUTF(new String(SBPMessageFormat.createAcknowledgeRequest()));

    }
}
