package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.usermanagement.domain.Acronym;
import eapli.base.usermanagement.domain.Teacher;
import eapli.base.usermanagement.repositories.TeacherRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class JpaTeacherRepository extends JpaAutoTxRepository<Teacher, Acronym, Acronym> implements TeacherRepository {
    public JpaTeacherRepository(final TransactionalContext autoTx) {
        super(autoTx, "acronym");
    }
    public JpaTeacherRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "acronym");
    }
    @Override
    public Iterable<Teacher> findAllTeachers() {
        return findAll();
    }

    @Override
    public Teacher findTeacherByAcronym(String acronym) {
        return createQuery("SELECT t FROM Teacher t WHERE t.acronym.acronym = :acronym", Teacher.class)
                .setParameter("acronym", acronym).getSingleResult();
    }

    @Override
    public Teacher findTeacherBySystemUser(SystemUser systemUser) {
        return createQuery("SELECT t FROM Teacher t JOIN Person p ON p.teacher = t WHERE p.systemUser = :systemUser", Teacher.class)
                .setParameter("systemUser", systemUser).getSingleResult();
    }

    @Override
    public List<Teacher> findTeachersInACourse(Course course) {
        TypedQuery<Teacher> query = createQuery(
                "SELECT DISTINCT t FROM Teacher t " +
                        "WHERE (t IN (SELECT c.teacherInCharge FROM Course c WHERE c = :course)) " +
                        "OR (t IN (SELECT tl FROM Course c JOIN c.teachersList tl WHERE c = :course))",
                Teacher.class);
        query.setParameter("course", course);
        return query.getResultList();
    }
}
