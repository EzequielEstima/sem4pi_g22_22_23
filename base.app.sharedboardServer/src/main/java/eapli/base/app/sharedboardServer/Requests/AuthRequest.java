package eapli.base.app.sharedboardServer.Requests;

import eapli.base.infrastructure.authz.CredentialHandler;
import eapli.base.sharedBoard.SBPMessageFormat;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class AuthRequest {
    public void authenticate(String message, DataOutputStream outputStream, CredentialHandler credentialHandler) throws IOException {
        List<String> params = SBPMessageFormat.decodeParam(message.getBytes());
        if (credentialHandler.authenticated(params.get(0), params.get(1), null)) {
            byte[] authRequest = SBPMessageFormat.createAcknowledgeRequest();
            outputStream.writeUTF(new String(authRequest));
        } else {
            byte[] authRequest = SBPMessageFormat.
                    creteErrorRequest("Wrong username or password.");
            outputStream.writeUTF(new String(authRequest));
        }
    }
}
