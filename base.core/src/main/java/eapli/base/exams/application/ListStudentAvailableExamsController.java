package eapli.base.exams.application;

import eapli.base.exams.application.services.ListStudentAvailableExamsService;
import eapli.base.exams.dto.ExamDTOWithDatesExamTitleCourseId;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;

public class ListStudentAvailableExamsController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public List<ExamDTOWithDatesExamTitleCourseId> listStudentAvailableExams(){

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.STUDENT);

        return new ListStudentAvailableExamsService().listStudentAvailableExams();
    }
}
