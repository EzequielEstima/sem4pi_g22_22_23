package eapli.base.app.common.console.presentation.board;

import eapli.framework.actions.Action;

public class CreateBoardAction implements Action {
    @Override
    public boolean execute() {
        return new CreateBoardUI().doShow();
    }
}
