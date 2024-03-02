package eapli.base.exams.dto;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.exams.domain.Exam;

public class ExamDTOWithDatesExamTitleCourseIdMapper {

    public static ExamDTOWithDatesExamTitleCourseId toDto(Exam exam, Course course){
        ExamDTOWithDatesExamTitleCourseIdBuilder examDTOWithDatesExamTitleCourseIdBuilder = new ExamDTOWithDatesExamTitleCourseIdBuilder();
        return examDTOWithDatesExamTitleCourseIdBuilder.withDatesExamIdCourseId(exam.returnInitialDateString(), exam.returnFinalDateString(), exam.returnExamTitleString(),course.returnCourseIdentifierString()).build();
    }
}
