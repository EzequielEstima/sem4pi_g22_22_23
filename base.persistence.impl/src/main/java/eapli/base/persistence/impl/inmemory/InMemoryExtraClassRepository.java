package eapli.base.persistence.impl.inmemory;

import eapli.base.courseclasses.domain.ExtraClass;
import eapli.base.courseclasses.domain.ExtraClassId;
import eapli.base.courseclasses.repositories.ExtraClassRepository;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.usermanagement.domain.Teacher;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryExtraClassRepository extends InMemoryDomainRepository<ExtraClass, ExtraClassId>
        implements ExtraClassRepository {
    @Override
    public List<ExtraClass> findExtraClassesInACourse(Course course) {
        return null;
    }

    @Override
    public List<ExtraClass> findAllClassesByTeacher(Teacher teacher) {
        return null;
    }
}
