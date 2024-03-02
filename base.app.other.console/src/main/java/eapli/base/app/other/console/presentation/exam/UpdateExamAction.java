package eapli.base.app.other.console.presentation.exam;

import eapli.framework.actions.Action;


public class UpdateExamAction implements Action {

    @Override
    public boolean execute() {
        return new UpdateExamUI().doShow();
    }
}
