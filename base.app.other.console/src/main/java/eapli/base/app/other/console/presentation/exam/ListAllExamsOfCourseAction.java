package eapli.base.app.other.console.presentation.exam;

import eapli.framework.actions.Action;

import javax.swing.*;

public class ListAllExamsOfCourseAction implements Action {

    @Override
    public boolean execute() {
        return new ListAllExamsOfCourseUI().doShow();
    }
}
