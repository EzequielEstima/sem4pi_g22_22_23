package eapli.base.app.other.console.presentation.courseclasses;

import eapli.framework.actions.Action;

public class RescheduleClassAction implements Action {
    @Override
    public boolean execute() {
        return new RescheduleClassUI().show();
    }
}
