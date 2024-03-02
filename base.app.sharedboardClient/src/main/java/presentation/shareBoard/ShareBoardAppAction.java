package presentation.shareBoard;

import eapli.framework.actions.Action;

import java.net.Socket;

public class ShareBoardAppAction implements Action {
    private final Socket socket;
    public ShareBoardAppAction (Socket socket){
        this.socket = socket;
    }
    @Override
    public boolean execute() {
        return new ShareBoardUI(socket).show();
    }
}
