package presentation.listNotifications;

import eapli.base.sharedBoard.SBPMessageFormat;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class ListNotificationsUI extends AbstractUI {
    private final Socket socket;
    public ListNotificationsUI(Socket socket){
        this.socket = socket;
    }
    @Override
    protected boolean doShow() {
        DataOutputStream dos;
        DataInputStream dis;
        try {
            dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(new String(SBPMessageFormat.createNotificationListSendRequest()));
            dis = new DataInputStream(socket.getInputStream());
            String message = dis.readUTF();
            if(SBPMessageFormat.decodeFormat(message.getBytes())[SBPMessageFormat.CODE_OFFSET] == SBPMessageFormat.LIST_NOTIFICATION_RECEIVE) {
                List<String> notificationList = SBPMessageFormat.decodeParam(message.getBytes());
                if (!notificationList.isEmpty()) {
                    System.out.println("Notifications:");
                    for(String string : notificationList){
                        System.out.println(string);
                    }
                    System.out.println();
                    int input = Console.readInteger("0. Exit");
                    while(input!= 0){
                        System.out.println("If you wish to exit please insert 0");
                        input = Console.readInteger("");
                    }
                }else{
                    System.out.printf("Sorry, you don't have any notifications.\n\n");
                }
            }else{
                System.out.println(SBPMessageFormat.decodeParam(message.getBytes()));
            }
        } catch (IOException e) {
            System.out.printf("Your connection to the server has been lost.\n\n");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Notifications";
    }
}
