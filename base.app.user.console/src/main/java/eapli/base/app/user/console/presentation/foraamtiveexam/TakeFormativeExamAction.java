package eapli.base.app.user.console.presentation.foraamtiveexam;

import eapli.framework.actions.Action;

public class TakeFormativeExamAction implements Action {
    @Override
    public boolean execute() {
        return new TakeFormativeExamUI().show();
    }
}
