package eapli.base.app.backoffice.console.presentation.enrollment;

import eapli.framework.actions.Action;

public class ApproveRejectEnrollmentAction implements Action {
    @Override
    public boolean execute() {
        return new ApproveRejectEnrollmentUI().show();
    }
}
