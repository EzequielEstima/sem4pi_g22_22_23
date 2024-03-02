package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.questionmanagement.domain.Question;
import eapli.base.questionmanagement.domain.QuestionIdentifier;
import eapli.base.questionmanagement.repositories.QuestionRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.List;

public class JpaQuestionRepository extends JpaAutoTxRepository<Question, QuestionIdentifier, QuestionIdentifier> implements QuestionRepository {

    public JpaQuestionRepository(final TransactionalContext autoTx) {
        super(autoTx, "questionId");
    }

    public JpaQuestionRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "questionId");
    }

    @Override
    public List<Question> listQuestionsByCourseId(String course_id) {
        //query string search all classes in a course where the teacher is in list of teachers
        return createQuery("SELECT q FROM Course c JOIN c.questionList q WHERE c.courseId.course_Id = :course_id", Question.class).
                setParameter("course_id", course_id).getResultList();

    }

    @Override
    public Long findMaxId() {
        if (count() > 0) {
            return createQuery("SELECT MAX(q.questionId.question_Id) FROM Question q", Long.class).getSingleResult();
        } else {
            return 0L;
        }
    }
}