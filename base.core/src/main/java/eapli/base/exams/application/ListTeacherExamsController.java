package eapli.base.exams.application;

import eapli.base.exams.application.services.ListTeacherExamsService;
import eapli.base.exams.dto.ExamDTOWithDatesExamTitleCourseId;

import java.util.List;

public class ListTeacherExamsController {

    private ListTeacherExamsService listTeacherExamsService = new ListTeacherExamsService();

    public List<ExamDTOWithDatesExamTitleCourseId> listTeacherExams(){
        return  listTeacherExamsService.listTeacherExam();
    }
}
