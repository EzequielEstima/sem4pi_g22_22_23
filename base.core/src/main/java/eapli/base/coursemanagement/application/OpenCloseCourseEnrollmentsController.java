package eapli.base.coursemanagement.application;

import eapli.base.coursemanagement.application.services.OpenCloseCourseEnrollmentsService;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitleStatus;

import java.util.List;

public class OpenCloseCourseEnrollmentsController {
    private final OpenCloseCourseEnrollmentsService openCloseEnrollmentsService = new OpenCloseCourseEnrollmentsService();

    public List<CourseDTOWithIdTitleStatus> listAllOpenCloseEnrollmentsAvailableCourses(){
        return openCloseEnrollmentsService.listAllOpenCloseEnrollmentsAvailableCourses();
    }

    public void changeStatus(CourseDTOWithIdTitleStatus selectedCourseDTO, String newStatus){
        openCloseEnrollmentsService.changeStatus(selectedCourseDTO, newStatus);
    }
}
