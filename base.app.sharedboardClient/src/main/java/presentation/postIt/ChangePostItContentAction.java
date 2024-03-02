package presentation.postIt;

import eapli.framework.actions.Action;

import java.net.Socket;

public class ChangePostItContentAction implements Action {
    private Socket socket;

    public ChangePostItContentAction(Socket socket) {
        this.socket = socket;
    }

    @Override
    public boolean execute() {
        return new ChangePostItContentUI(socket).show();
    }
}
