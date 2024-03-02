package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.usermanagement.domain.MecanographicNumber;
import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.repositories.StudentRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class JpaStudentRepository extends JpaAutoTxRepository<Student, MecanographicNumber,MecanographicNumber> implements StudentRepository {

    public JpaStudentRepository(final TransactionalContext autoTx) {
        super(autoTx, "mecanographicNumber");
    }

    public JpaStudentRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "mecanographicNumber");
    }

    @Override
    public int findTotalMecanographicNumberByYear(String year) {

        TypedQuery<Long> query = createQuery("SELECT COUNT(s.mecanographicNumber) FROM Student s WHERE SUBSTRING(s.mecanographicNumber.mecanographicNumber, 1, 4) = :year",
                Long.class);
        query.setParameter("year", year);
        return Math.toIntExact(query.getSingleResult());

    }

    @Override
    public Student findStudentBySystemUser(SystemUser systemUser) {
        TypedQuery<Student> query = createQuery("SELECT s FROM Student s JOIN Person p on s.mecanographicNumber = p.student.mecanographicNumber WHERE p.systemUser = :systemUser",
                Student.class);
        query.setParameter("systemUser", systemUser);
        return query.getSingleResult();
    }

    @Override
    public List<Student> findStudentsInACourse(Course course) {
        TypedQuery<Student> query = createQuery("SELECT s FROM Student s " +
                        "JOIN Enrollment e on e.student = s WHERE e.course = :course and e.enrollmentStatus.enrollmentStatusValue = 'ACCEPTED'",
                Student.class);
        query.setParameter("course", course);
        return query.getResultList();
    }
}
