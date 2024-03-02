package eapli.base.exams.dto;

import eapli.base.exams.domain.Exam;

public class ExamDTOWithExamTitleDateIntervalMapper {

    public ExamDTOWithExamTitleDateInterval toDto(Exam exam){
        ExamDTOWithExamTitleDateIntervalBuilder examDTOWithExamIdDateIntervalBuilder = new ExamDTOWithExamTitleDateIntervalBuilder();

        return examDTOWithExamIdDateIntervalBuilder.withExamId(exam.returnExamTitleString())
                .withInitialDate(exam.returnInitialDateString())
                .withFinalDate(exam.returnFinalDateString())
                .build();
    }
}
