package eapli.base.exams.application;

import eapli.base.exams.application.services.TakeExamService;
import eapli.base.exceptions.InvalidIdException;
import eapli.base.exceptions.NegativeParameterException;
import eapli.base.exceptions.ParameterNullBlankException;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;

public class TakeExamController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public List<String> takeExam(String examId, String filePath) throws NegativeParameterException, InvalidIdException, ParameterNullBlankException {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.STUDENT);

        return new TakeExamService().takeExam(examId,filePath);
    }
}
