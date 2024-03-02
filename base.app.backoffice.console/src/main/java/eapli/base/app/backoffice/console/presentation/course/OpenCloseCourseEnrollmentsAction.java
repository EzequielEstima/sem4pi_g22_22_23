package eapli.base.app.backoffice.console.presentation.course;

import eapli.framework.actions.Action;
public class OpenCloseCourseEnrollmentsAction implements Action{

    @Override
    public boolean execute() {
        return new  OpenCloseCourseEnrollmentsUI().show();
    }
}
