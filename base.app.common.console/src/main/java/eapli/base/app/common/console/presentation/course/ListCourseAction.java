package eapli.base.app.common.console.presentation.course;

import eapli.framework.actions.Action;

public class ListCourseAction implements Action {

    @Override
    public boolean execute() {
        return new ListCourseUI().doShow();
    }
}
