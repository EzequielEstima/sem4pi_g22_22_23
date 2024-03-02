package eapli.base.courseclasses.repositories;

import eapli.base.courseclasses.domain.*;
import eapli.base.courseclasses.domain.Class;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Optional;

public interface ExtraClassRepository extends DomainRepository<ExtraClassId, ExtraClass> {
    List<ExtraClass> findExtraClassesInACourse(Course course);

    List<ExtraClass> findAllClassesByTeacher(Teacher teacher);
}
