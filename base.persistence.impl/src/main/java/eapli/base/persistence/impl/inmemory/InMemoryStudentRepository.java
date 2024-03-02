package eapli.base.persistence.impl.inmemory;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.usermanagement.domain.*;
import eapli.base.usermanagement.repositories.StudentRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryStudentRepository extends InMemoryDomainRepository<Student, MecanographicNumber>
        implements StudentRepository {
    @Override
    public int findTotalMecanographicNumberByYear(String year) {
        Iterable<Student> student = findAll();
        int i = 0;
        for (Student s: student){
            if (s.compareYearMecanographicNumber(year)){
                i++;
            }
        }
        return  i;
    }

    @Override
    public Student findStudentBySystemUser(SystemUser systemUser) {
        return null;
    }

    @Override
    public List<Student> findStudentsInACourse(Course course) {
        return null;
    }
}
