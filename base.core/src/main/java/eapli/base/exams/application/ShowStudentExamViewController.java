package eapli.base.exams.application;

import eapli.base.exams.application.services.ShowStudentExamViewService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class ShowStudentExamViewController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public String showStudentExamView(String examTitle){

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.STUDENT);

        return new ShowStudentExamViewService().showStudentExamView(examTitle);
    }
}
