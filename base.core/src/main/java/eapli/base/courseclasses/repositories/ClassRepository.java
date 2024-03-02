package eapli.base.courseclasses.repositories;

import eapli.base.courseclasses.domain.Class;
import eapli.base.courseclasses.domain.ClassId;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface ClassRepository extends DomainRepository<ClassId, Class> {

    /**
     * Finds all classes who match a person and a date
     * @param  teacher teacher who lecture the classes
     * @return list of classes
     */
    List<Class> findAllClassesByTeacher(Teacher teacher);

    /**
     * Finds a class by its id
     * @param id class id
     * @return class
     */
    Class findById(long id);
    /**
     * Finds all classes of a teacher
     * @param teacher teacher who lecture the classes
     * @return list of classes
     */
    List<Class> findAll(Teacher teacher);

    List<Class> findClassesInACourse(Course course);
}
