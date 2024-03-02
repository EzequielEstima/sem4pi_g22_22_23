package eapli.base.coursemanagement.application;

import eapli.base.coursemanagement.application.services.CreateCourseService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class CreateCourseController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public boolean createCourse(String courseId, String courseTitle, String courseName, String description, int maxEnrollments, int minEnrollments){

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.MANAGER);

        CreateCourseService service = new CreateCourseService();
        return service.createCourse(courseId,courseTitle,courseName,description,maxEnrollments,minEnrollments);
    }
}
