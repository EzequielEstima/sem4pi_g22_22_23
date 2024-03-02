package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.courseclasses.domain.*;
import eapli.base.courseclasses.domain.Class;
import eapli.base.courseclasses.repositories.ExtraClassRepository;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.domain.Teacher;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JpaExtraClassRepository extends JpaAutoTxRepository<ExtraClass, ExtraClassId,ExtraClassId> implements ExtraClassRepository {

    public JpaExtraClassRepository(final TransactionalContext autoTx) {
        super(autoTx, "extraClassId");
    }
    public JpaExtraClassRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "extraClassId");
    }

    /**
     * Finds all classes of a course
     * @param course course to search for extra classes
     * @return List of ExtraClass
     */
    @Override
    public List<ExtraClass> findExtraClassesInACourse(Course course) {
        return  createQuery("SELECT c FROM ExtraClass c WHERE c IN (SELECT cl FROM Course co JOIN co.extraClassesList cl WHERE co = :course)"
                , ExtraClass.class).
                setParameter("course", course).getResultList();
    }

    /**
     * Finds all classes of a teacher
     * @param teacher teacher to search for extra classes
     * @return List of ExtraClass
     */
    @Override
    public List<ExtraClass> findAllClassesByTeacher(Teacher teacher) {
        return createQuery("SELECT c FROM ExtraClass c WHERE c.extraClassTeacher = :teacher",
                ExtraClass.class)
                .setParameter("teacher", teacher).getResultList();
    }
}
