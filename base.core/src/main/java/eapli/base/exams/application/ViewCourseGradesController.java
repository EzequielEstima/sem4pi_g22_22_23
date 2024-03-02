package eapli.base.exams.application;

import eapli.base.exams.application.services.ViewCourseGradesService;

import java.util.List;
import java.util.Map;

public class ViewCourseGradesController {

private static ViewCourseGradesService viewCourseGradesService = new ViewCourseGradesService();

    public List<String> listTeacherCourses(){
        return viewCourseGradesService.listTeacherCourses();
    }

    public Map<Integer, List<String>> listGradesFromTeacherCourse(List<String> courses){
        return viewCourseGradesService.listGradesFromTeacherCourse(courses);
    }

}
