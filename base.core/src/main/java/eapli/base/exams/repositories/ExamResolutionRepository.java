package eapli.base.exams.repositories;

import eapli.base.exams.domain.Exam;
import eapli.base.exams.domain.ExamResolution;
import eapli.base.exams.domain.ExamResolutionId;
import eapli.base.exams.domain.ExamTitle;
import eapli.base.usermanagement.domain.Student;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

import java.util.List;

public interface ExamResolutionRepository extends DomainRepository<ExamResolutionId, ExamResolution> {
    Long findMaxId();

    boolean containsOfExamAndStudent(Exam exam, Student student);

    List<ExamResolution> findStudentGrades(SystemUser systemUser);

    List<ExamResolution> findExamResolutionsByExamId(ExamTitle examTitle);
}
