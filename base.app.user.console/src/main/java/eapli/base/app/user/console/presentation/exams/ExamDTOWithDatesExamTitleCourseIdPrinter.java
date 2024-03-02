package eapli.base.app.user.console.presentation.exams;

import eapli.base.exams.dto.ExamDTOWithDatesExamTitleCourseId;
import eapli.framework.visitor.Visitor;

public class ExamDTOWithDatesExamTitleCourseIdPrinter implements Visitor<ExamDTOWithDatesExamTitleCourseId> {
    @Override
    public void visit(ExamDTOWithDatesExamTitleCourseId visitee) {
        System.out.printf("%-20s | %-20s | %-20s | %-20s", visitee.courseId, visitee.examTitle, visitee.initialDate, visitee.finalDate);
    }
}
