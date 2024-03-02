package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.boardhistory.domain.Task;
import eapli.base.exams.domain.Exam;
import eapli.base.exams.domain.ExamResolution;
import eapli.base.exams.domain.ExamResolutionId;
import eapli.base.exams.domain.ExamTitle;
import eapli.base.exams.repositories.ExamResolutionRepository;
import eapli.base.usermanagement.domain.Student;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class JpaExamResolutionRepository extends JpaAutoTxRepository<ExamResolution, ExamResolutionId,ExamResolutionId> implements ExamResolutionRepository {

    public JpaExamResolutionRepository(final TransactionalContext autoTx) {
        super(autoTx, "examResolution_Id");
    }

    public JpaExamResolutionRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "examResolution_Id");
    }

    @Override
    public Long findMaxId() {
        if (count() > 0) {
            return createQuery("SELECT MAX(e.examResolution_Id.examResolution_id) FROM ExamResolution e", Long.class).getSingleResult();
        } else {
            return 0L;
        }
    }

    @Override
    public boolean containsOfExamAndStudent(Exam exam, Student student) {
        final Map<String, Object> params = new HashMap<>();
        params.put("exam", exam);
        params.put("student", student);
        Optional<ExamResolution> opt =  matchOne(" e.student = :student AND e.exam = :exam",params);
        return opt.isPresent();
    }

    @Override
    public List<ExamResolution> findExamResolutionsByExamId(ExamTitle examTitle) {
        return createQuery("SELECT er FROM ExamResolution er WHERE er IN (SELECT eres FROM Exam e JOIN e.examResolutions eres WHERE e.examTitle = :examTitle)", ExamResolution.class)
                .setParameter("examTitle", examTitle)
                .getResultList();
    }

    @Override
    public List<ExamResolution> findStudentGrades(SystemUser systemUser) {
        return  createQuery("SELECT e from ExamResolution e  " +
                        "WHERE e.student IN (Select Distinct p.student from Person p WHERE p.systemUser = :systemUser)"
                , ExamResolution.class).setParameter("systemUser", systemUser).getResultList();
    }
}
