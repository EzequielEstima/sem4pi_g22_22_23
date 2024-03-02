package eapli.base.usermanagement.repositories;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.usermanagement.domain.Acronym;
import eapli.base.usermanagement.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

public interface TeacherRepository extends DomainRepository<Acronym, Teacher> {

    /**
     * returns the list of Teachers in the system who are teachers
     *
     * @return List<Person>
     */
    Iterable<Teacher> findAllTeachers();

    /**
     * returns the Teacher with the given acronym
     *
     * @param acronym acronym of the Teacher
     * @return Teacher with the given acronym
     */
    Teacher findTeacherByAcronym(String acronym);

    /**
     * returns the Teacher with the given username
     *
     * @param systemUser systemUser of the Teacher
     * @return Teacher with the given systemUser
     */
    Teacher findTeacherBySystemUser(SystemUser systemUser);

    List<Teacher> findTeachersInACourse(Course course);

}
