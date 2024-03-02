package presentation.listNotifications;


import eapli.framework.actions.Action;

import java.net.Socket;

public class ListNotificationsAction implements Action {
    private final Socket socket;
    public ListNotificationsAction(Socket socket){
        this.socket = socket;
    }

    @Override
    public boolean execute() {
        return new ListNotificationsUI(socket).show();
    }
}
