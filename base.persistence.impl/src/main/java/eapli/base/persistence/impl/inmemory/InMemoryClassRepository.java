package eapli.base.persistence.impl.inmemory;

import eapli.base.courseclasses.domain.Class;
import eapli.base.courseclasses.domain.ClassId;
import eapli.base.courseclasses.domain.Date;
import eapli.base.courseclasses.repositories.ClassRepository;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.domain.Teacher;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;
import java.util.Optional;

public class InMemoryClassRepository extends InMemoryDomainRepository<Class, ClassId>
        implements ClassRepository {


    @Override
    public List<Class> findAllClassesByTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public Class findById(long id) {
        return matchOne(e -> e.returnId() == id).orElse(null);
    }

    @Override
    public List<Class> findAll(Teacher teacher) {
        return null;
    }

    @Override
    public List<Class> findClassesInACourse(Course course) {
        return null;
    }

}
