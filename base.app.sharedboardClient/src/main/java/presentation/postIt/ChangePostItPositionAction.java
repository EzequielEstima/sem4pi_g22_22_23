package presentation.postIt;


import eapli.framework.actions.Action;

import java.net.Socket;

public class ChangePostItPositionAction implements Action {
    private Socket socket;

    public ChangePostItPositionAction(Socket socket) {
        this.socket = socket;
    }

    @Override
    public boolean execute() {
        return new ChangePostItPositionUI(socket).show();
    }
}
