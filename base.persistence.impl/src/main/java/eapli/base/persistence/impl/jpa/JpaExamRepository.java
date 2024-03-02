package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.exams.domain.Exam;
import eapli.base.exams.domain.ExamTitle;
import eapli.base.exams.repositories.ExamRepository;
import eapli.base.usermanagement.domain.Teacher;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class JpaExamRepository extends JpaAutoTxRepository<Exam, ExamTitle, ExamTitle> implements ExamRepository {

    public JpaExamRepository(final TransactionalContext autoTx) {
        super(autoTx, "examId");
    }

    public JpaExamRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "examTitle");
    }
    @Override
    public List<Exam> listFutureExamsByCourse(Course course, Date currentDate){
        return  createQuery("SELECT e from Exam e  WHERE e IN (SELECT e FROM Course c JOIN c.examsList WHERE c =: course) AND e.dateInterval.initialDate > :currentDate"
                , Exam.class).
                setParameter("course", course).setParameter("currentDate", currentDate).getResultList();
    }

    @Override
    public List<Exam> findExamsFromCourse(CourseIdentifier courseId){
        TypedQuery<Exam> query = createQuery("SELECT e FROM Course c JOIN c.examsList e WHERE c.courseId =: courseIdentifier", Exam.class);
        query.setParameter("courseIdentifier", courseId);
        return query.getResultList();
    }

    @Override
    public List<Exam> findTeacherExams(Teacher teacher) {
        TypedQuery<Exam> query = createQuery("SELECT e FROM Exam e Where e.examTeacher=:teacher", Exam.class);
        query.setParameter("teacher", teacher);
        return query.getResultList();
    }
}
