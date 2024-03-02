package eapli.base.app.user.console.presentation.exams;

import eapli.base.exams.application.ListStudentGradesController;
import eapli.base.exams.dto.ExamResolutionDTOExamTitleGrade;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ListStudentGradesUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        List<ExamResolutionDTOExamTitleGrade> listExamResolutionDTO = new ListStudentGradesController().listMyGrades();
        if (!listExamResolutionDTO.isEmpty()) {
            System.out.println();
            System.out.println("Grade | Exam Title");
            System.out.println("------------------");
            for (ExamResolutionDTOExamTitleGrade dto: listExamResolutionDTO) {
                System.out.printf("%-5s | %s\n",dto.grade, dto.examTitle);
            }
        }
        System.out.println();
        System.out.println();
        return false;
    }

    @Override
    public String headline() {
        return "List Students Grades";
    }
}
