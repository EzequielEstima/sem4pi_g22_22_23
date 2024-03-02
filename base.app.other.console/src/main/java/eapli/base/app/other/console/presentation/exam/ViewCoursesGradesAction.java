package eapli.base.app.other.console.presentation.exam;

import eapli.framework.actions.Action;

public class ViewCoursesGradesAction implements Action {
    @Override
    public boolean execute() {
        return new ViewCoursesGradesUI().doShow();
    }
}
