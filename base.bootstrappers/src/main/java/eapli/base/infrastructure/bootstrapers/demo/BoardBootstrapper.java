package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.infrastructure.bootstrapers.BoardBootstrapperBase;
import eapli.framework.actions.Action;

import java.util.ArrayList;


public class BoardBootstrapper extends BoardBootstrapperBase implements Action {

    @Override
    public boolean execute() {
        ArrayList<Boolean> results = new ArrayList<>();

        results.add(createBoard("Board1",5,5));

        for(Boolean result : results){
            if(!result) return false;
        }
        return true;
    }

    private boolean createBoard(final String boardTitle,final int rowNumber,final int columnNumber){
        return createBoardBaseBootstrap(boardTitle, rowNumber, columnNumber);
    }
}
