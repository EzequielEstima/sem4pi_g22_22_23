package presentation.viewInRealTime;

import eapli.framework.actions.Action;

import java.net.Socket;

public class ViewInRealTimeAction implements Action {

    private final Socket socket;
    public ViewInRealTimeAction (Socket socket){
        this.socket = socket;
    }
    @Override
    public boolean execute() {
        return new ViewInRealTimeUI(socket).doShow();
    }
}
