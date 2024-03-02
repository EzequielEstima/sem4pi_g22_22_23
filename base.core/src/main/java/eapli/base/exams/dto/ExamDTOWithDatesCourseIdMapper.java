package eapli.base.exams.dto;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.exams.domain.Exam;

public class ExamDTOWithDatesCourseIdMapper {

    public static ExamDTOWithDatesCourseId toDTO(Exam exam, Course course){
        ExamDTOWithDatesCourseIdBuilder builder = new ExamDTOWithDatesCourseIdBuilder();
        return builder.withInitialDate(exam.returnInitialDateString())
                .withFinalDate(exam.returnFinalDateString())
                .withCourseIdentifier(course.returnCourseIdentifierString()).build();
    }
}
