package eapli.base.app.sharedboardServer.Requests;

import eapli.base.board.application.ListUserNotificationsController;
import eapli.base.sharedBoard.SBPMessageFormat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class ListNotificationsRequest {
    public void listUserNotifications(DataOutputStream outputStream) throws IOException {
        try{
            List<String> notificationList = new ListUserNotificationsController().listUserNotifications();
            outputStream.writeUTF(new String(SBPMessageFormat.createNotificationListReceiveRequest(notificationList)));
        }catch (Exception e){
            e.printStackTrace();
            outputStream.writeUTF(new String(SBPMessageFormat.creteErrorRequest(e.getMessage())));
        }
    }
}
