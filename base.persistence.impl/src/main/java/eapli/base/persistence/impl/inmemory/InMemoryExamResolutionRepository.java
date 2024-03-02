package eapli.base.persistence.impl.inmemory;

import eapli.base.exams.domain.Exam;
import eapli.base.exams.domain.ExamResolution;
import eapli.base.exams.domain.ExamResolutionId;
import eapli.base.exams.domain.ExamTitle;
import eapli.base.exams.repositories.ExamResolutionRepository;
import eapli.base.usermanagement.domain.Student;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryExamResolutionRepository extends InMemoryDomainRepository<ExamResolution, ExamResolutionId> implements ExamResolutionRepository {

    @Override
    public Long findMaxId() {
        return 0L;
    }

    @Override
    public boolean containsOfExamAndStudent(Exam exam, Student student) {
        return false;
    }

    @Override
    public List<ExamResolution> findStudentGrades(SystemUser systemUser) {
        return null;
    }

    @Override
    public List<ExamResolution> findExamResolutionsByExamId(ExamTitle examTitle) {
        return null;
    }
}
