package presentation.postIt;

import eapli.framework.actions.Action;

import java.net.Socket;

public class CreatePostItAction implements Action {

    private final Socket socket;
    public CreatePostItAction(Socket socket){
        this.socket = socket;
    }

    @Override
    public boolean execute() {
        return new CreatePostItUI(socket).show();
    }
}
