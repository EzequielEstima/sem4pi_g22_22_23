package eapli.base.persistence.impl.inmemory;

import eapli.base.questionmanagement.domain.Question;
import eapli.base.questionmanagement.domain.QuestionIdentifier;
import eapli.base.questionmanagement.repositories.QuestionRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryQuestionRepository extends InMemoryDomainRepository<Question, QuestionIdentifier> implements QuestionRepository {
    @Override
    public List<Question> listQuestionsByCourseId(String courseId) {
        return null;
    }

    @Override
    public Long findMaxId() {
        return 0L;
    }
}
