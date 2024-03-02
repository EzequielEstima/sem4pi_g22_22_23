package presentation.postIt;

import eapli.framework.actions.Action;

import java.net.Socket;

public class UndoLastChangeInPostItAction implements Action {

    private final Socket socket;
    public UndoLastChangeInPostItAction(Socket socket){
        this.socket = socket;
    }

    @Override
    public boolean execute() {
        return new UndoLastChangeInPostItUI(socket).show();
    }
}
