package eapli.base.persistence.impl.inmemory;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.usermanagement.domain.Acronym;
import eapli.base.usermanagement.domain.Teacher;
import eapli.base.usermanagement.repositories.TeacherRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;


public class InMemoryTeacherRepository extends InMemoryDomainRepository<Teacher, Acronym>  implements TeacherRepository {

    /**
     * @return the list of Teachers in the system who are teachers
     */
    @Override
    public Iterable<Teacher> findAllTeachers() {
        return findAll();
    }

    @Override
    public Teacher findTeacherByAcronym(String acronym) {
        return matchOne(e -> e.returnAcronymString().equals(acronym)).orElse(null);
    }

    @Override
    public Teacher findTeacherBySystemUser(SystemUser systemUser) {
        return null;
    }

    @Override
    public List<Teacher> findTeachersInACourse(Course course) {
        return null;
    }

}
