package eapli.base.persistence.impl.inmemory;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.exams.domain.Exam;
import eapli.base.exams.domain.ExamTitle;
import eapli.base.exams.repositories.ExamRepository;
import eapli.base.usermanagement.domain.Teacher;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.Date;
import java.util.List;


public class InMemoryExamRepository extends InMemoryDomainRepository<Exam, ExamTitle> implements ExamRepository {

    @Override
    public List<Exam> listFutureExamsByCourse(Course course, Date currentDate) {
        return null;
    }

    @Override
    public List<Exam> findExamsFromCourse(CourseIdentifier courseId) {
        return null;
    }

    @Override
    public List<Exam> findTeacherExams(Teacher teacher) {
        return null;
    }
}
