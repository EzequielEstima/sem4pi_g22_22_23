package eapli.base.formativeexams.repositories;

import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.exams.domain.Exam;
import eapli.base.formativeexams.domain.FormativeExam;
import eapli.base.formativeexams.domain.FormativeExamID;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface FormativeExamRepository extends DomainRepository<FormativeExamID, FormativeExam> {

    public List<FormativeExam> findFormativeExamsFromCourse(CourseIdentifier courseId);

}
