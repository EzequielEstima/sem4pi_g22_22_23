package eapli.base.app.other.console.presentation.courseClass;

import eapli.framework.actions.Action;

public class CreateClassAction implements Action {
    @Override
    public boolean execute() {
        return new CreateClassUI().doShow();
    }
}
