package eapli.base.exams.application;

import eapli.base.exams.application.services.ListStudentGradesService;
import eapli.base.exams.dto.ExamResolutionDTOExamTitleGrade;

import java.util.List;

public class ListStudentGradesController {

    public List<ExamResolutionDTOExamTitleGrade> listMyGrades(){
        return new ListStudentGradesService().listMyGrades();
    }
}
