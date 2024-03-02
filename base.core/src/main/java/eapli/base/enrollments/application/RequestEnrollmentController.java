package eapli.base.enrollments.application;

import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.enrollments.application.services.RequestEnrollmentService;

import java.util.List;

public class RequestEnrollmentController {

    private RequestEnrollmentService service = new RequestEnrollmentService();

    public List<CourseDTOWithIdTitle> listAllStudentAvailableCourses(){
        return service.listAllStudentAvailableCourses();
    }

    public boolean createEnrollment(CourseDTOWithIdTitle courseDTO){
        return service.createEnrollment(courseDTO);
    }
}
