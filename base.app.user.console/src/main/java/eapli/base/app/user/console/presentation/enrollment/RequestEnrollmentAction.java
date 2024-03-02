package eapli.base.app.user.console.presentation.enrollment;

import eapli.base.app.user.console.presentation.myuser.SignupRequestUI;
import eapli.framework.actions.Action;

public class RequestEnrollmentAction implements Action {
    @Override
    public boolean execute() {
        return new RequestEnrollmentUI().show();
    }
}
