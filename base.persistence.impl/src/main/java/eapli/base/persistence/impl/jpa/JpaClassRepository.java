package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.courseclasses.domain.Class;
import eapli.base.courseclasses.domain.ClassId;
import eapli.base.courseclasses.domain.Date;
import eapli.base.courseclasses.repositories.ClassRepository;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.meetingmanagement.domain.Meeting;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.domain.Teacher;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JpaClassRepository extends JpaAutoTxRepository<Class, ClassId,ClassId> implements ClassRepository {

    public JpaClassRepository(final TransactionalContext autoTx) {
        super(autoTx, "classId");
    }
    public JpaClassRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "classId");
    }


    @Override
    public List<Class> findAllClassesByTeacher(Teacher teacher) {
        return createQuery("SELECT c FROM Class c WHERE c.classTeacher = :teacher",
                Class.class)
                .setParameter("teacher", teacher).getResultList();
    }

    @Override
    public Class findById(long id) {
        return createQuery("SELECT c FROM Class c WHERE c.classId.class_Id = :id", Class.class)
                .setParameter("id", id).getSingleResult();
    }

    /**
     * Finds all classes of a teacher
     * @param user teacher user
     * @return list of classes
     */
    @Override
    public List<Class> findAll(Teacher user) {
        //query string search all classes in a course where the teacher is in list of teachers
        return  createQuery("SELECT c FROM Class c WHERE c.classTeacher = :user"
                , Class.class).
                setParameter("user", user).getResultList();
    }

    @Override
    public List<Class> findClassesInACourse(Course course) {
        return  createQuery("SELECT c FROM Class c WHERE c IN (SELECT cl FROM Course co JOIN co.classesList cl WHERE co = :course)"
                , Class.class).
                setParameter("course", course).getResultList();
    }

}
