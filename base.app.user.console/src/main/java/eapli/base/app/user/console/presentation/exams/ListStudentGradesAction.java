package eapli.base.app.user.console.presentation.exams;

import eapli.framework.actions.Action;

public class ListStudentGradesAction implements Action {


    @Override
    public boolean execute() {
        return new ListStudentGradesUI().doShow();
    }
}
