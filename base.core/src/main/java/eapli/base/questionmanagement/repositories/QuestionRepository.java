package eapli.base.questionmanagement.repositories;

import eapli.base.questionmanagement.domain.Question;
import eapli.base.questionmanagement.domain.QuestionIdentifier;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface QuestionRepository extends DomainRepository<QuestionIdentifier, Question> {
    List<Question> listQuestionsByCourseId(String courseId);

    Long findMaxId();
}
