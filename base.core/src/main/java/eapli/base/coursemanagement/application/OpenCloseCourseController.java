package eapli.base.coursemanagement.application;

import eapli.base.coursemanagement.dto.CourseDTOWithIdTitleStatus;
import eapli.base.coursemanagement.application.services.OpenCloseCourseService;

import java.util.List;

public class OpenCloseCourseController {
    private final OpenCloseCourseService openCloseCourseService = new OpenCloseCourseService();
    public List<CourseDTOWithIdTitleStatus> listOpenableClosableCourses(){
        return openCloseCourseService.listOpenableClosableCourses();
    }

    public void changeCourseStatus(CourseDTOWithIdTitleStatus courseDTO, String newStatus){
        openCloseCourseService.changeCourseStatus(courseDTO, newStatus);
    }
}