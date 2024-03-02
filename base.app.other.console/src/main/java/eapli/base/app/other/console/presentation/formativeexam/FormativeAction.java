package eapli.base.app.other.console.presentation.formativeexam;

import eapli.framework.actions.Action;

public class FormativeAction implements Action {
    @Override
    public boolean execute() {
        return new FormativeUI().show();
    }
}
