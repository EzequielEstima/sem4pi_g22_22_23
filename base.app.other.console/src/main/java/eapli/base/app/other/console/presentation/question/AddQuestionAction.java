package eapli.base.app.other.console.presentation.question;

import eapli.framework.actions.Action;

public class AddQuestionAction implements Action {
    @Override
    public boolean execute() {
        return new AddQuestionUI().show();
    }
}
