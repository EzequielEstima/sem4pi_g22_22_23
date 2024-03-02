package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.exams.domain.Exam;
import eapli.base.formativeexams.domain.FormativeExam;
import eapli.base.formativeexams.domain.FormativeExamID;
import eapli.base.formativeexams.repositories.FormativeExamRepository;
import eapli.base.questionmanagement.domain.Question;
import eapli.base.questionmanagement.domain.QuestionIdentifier;
import eapli.base.questionmanagement.repositories.QuestionRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

public class JpaFormativeExamRepository extends JpaAutoTxRepository<FormativeExam, FormativeExamID, FormativeExamID> implements FormativeExamRepository {

    public JpaFormativeExamRepository(final TransactionalContext autoTx) {
        super(autoTx, "formativeExamID");
    }

    public JpaFormativeExamRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "formativeExamID");
    }

    @Override
    public List<FormativeExam> findFormativeExamsFromCourse(CourseIdentifier courseId){
        TypedQuery<FormativeExam> query = createQuery("SELECT f FROM Course c JOIN c.formativeExams f WHERE c.courseId =: courseIdentifier", FormativeExam.class);
        query.setParameter("courseIdentifier", courseId);
        return query.getResultList();
    }
}
