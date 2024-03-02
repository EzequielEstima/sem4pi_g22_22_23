package eapli.base.exams.repositories;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.exams.domain.Exam;
import eapli.base.exams.domain.ExamTitle;
import eapli.base.usermanagement.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Date;
import java.util.List;

public interface ExamRepository extends DomainRepository<ExamTitle, Exam> {

    List<Exam> listFutureExamsByCourse(Course course, Date currentDate);

    List<Exam> findExamsFromCourse(CourseIdentifier courseId);

    List<Exam> findTeacherExams(Teacher teacher);
}