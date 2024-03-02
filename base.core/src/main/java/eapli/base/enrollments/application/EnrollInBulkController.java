package eapli.base.enrollments.application;

import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.enrollments.application.services.EnrollInBulkService;

import java.util.List;

public class EnrollInBulkController {

    private final EnrollInBulkService enrollInBulkService = new EnrollInBulkService();
    private final RequestEnrollmentController requestEnrollmentController = new RequestEnrollmentController();

    public boolean importCsvData(String fileName){
       return enrollInBulkService.importCsvData(fileName);
    }

    public List<CourseDTOWithIdTitle> listAllStudentAvailableCourses(){
        return requestEnrollmentController.listAllStudentAvailableCourses();
    }

    public void enrollStudentsInBulkToCourse(CourseDTOWithIdTitle selectedCourseDTO){
        enrollInBulkService.enrollStudentsInBulkToCourse(selectedCourseDTO);
    }

}
