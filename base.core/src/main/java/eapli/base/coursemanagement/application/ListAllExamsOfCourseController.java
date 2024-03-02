package eapli.base.coursemanagement.application;

import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.coursemanagement.application.services.ListAllExamsOfCourseService;
import eapli.base.exams.dto.ExamDTOWithExamTitleDateInterval;
import eapli.base.formativeexams.dto.FormativeExamDTOWithId;

import java.util.List;

public class ListAllExamsOfCourseController {

    private final ListAllExamsOfCourseService listAllExamsOfCourseService = new ListAllExamsOfCourseService();

    public List<CourseDTOWithIdTitle> listAllCourses(){
        return listAllExamsOfCourseService.listAllCourses();
    }
    public List<ExamDTOWithExamTitleDateInterval> listAllExamsFromCourse(CourseDTOWithIdTitle selectedCourseDTO){
        return listAllExamsOfCourseService.listExamsFromCourse(selectedCourseDTO);
    }

    public List<FormativeExamDTOWithId> listFormativeExamsFromCourse(CourseDTOWithIdTitle selectedCourseDTO){
        return listAllExamsOfCourseService.listFormativeExamsFromCourse(selectedCourseDTO);
    }
}
