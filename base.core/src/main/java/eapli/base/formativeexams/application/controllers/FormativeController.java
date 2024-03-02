package eapli.base.formativeexams.application.controllers;

import eapli.base.coursemanagement.application.services.ListCourseService;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.formativeexams.application.services.FormativeService;

import java.util.List;

public class FormativeController {
    // TODO
    private final FormativeService formativeService = new FormativeService();
private final ListCourseService listCourseService = new ListCourseService();
    public List<CourseDTOWithIdTitle> listCoursesDto(){
        return listCourseService.listCourse();
    }
    public boolean createFormativeExam(String questions, int number, CourseDTOWithIdTitle courseDTO){
        return formativeService.createFormativeExam(questions, number, courseDTO);
    }
}
