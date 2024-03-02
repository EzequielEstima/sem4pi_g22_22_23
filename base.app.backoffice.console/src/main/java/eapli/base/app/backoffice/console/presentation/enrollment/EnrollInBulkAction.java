package eapli.base.app.backoffice.console.presentation.enrollment;

import eapli.framework.actions.Action;

public class EnrollInBulkAction implements Action {
    @Override
    public boolean execute() {
        return new EnrollInBulkUI().show();
    }
}
