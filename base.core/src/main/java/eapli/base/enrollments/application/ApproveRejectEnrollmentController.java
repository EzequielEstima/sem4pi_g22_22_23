package eapli.base.enrollments.application;

import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.enrollments.application.services.ApproveRejectEnrollmentService;
import eapli.base.usermanagement.dto.StudentDTOWithMechNumber;

import java.util.List;

public class ApproveRejectEnrollmentController {
    ApproveRejectEnrollmentService service = new ApproveRejectEnrollmentService();
    public List<CourseDTOWithIdTitle> listCoursesWithEnrollments(){
        return service.listCoursesWithEnrollments();
    }

    public List<StudentDTOWithMechNumber> listStudentsPendingInCourse(CourseDTOWithIdTitle courseDTO){
        return service.listStudentsPendingInCourse(courseDTO);
    }

    public void changeEnrollmentStatus(CourseDTOWithIdTitle courseDTO, StudentDTOWithMechNumber studentDTO, String newStatus){
        service.changeEnrollmentStatus(courseDTO, studentDTO, newStatus);
    }

    public void verifyIfWillExceedEnrollmentLimits(CourseDTOWithIdTitle courseDTO){
        service.verifyIfWillExceedEnrollmentLimits(courseDTO);
    }
}
