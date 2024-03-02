package eapli.base.app.other.console.presentation.courseClass;

import eapli.framework.actions.Action;

public class ScheduleExtraClassAction implements Action {
    @Override
    public boolean execute() {
        return new ScheduleExtraClassUI().doShow();
    }
}
