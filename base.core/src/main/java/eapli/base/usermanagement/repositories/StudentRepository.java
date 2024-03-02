package eapli.base.usermanagement.repositories;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.usermanagement.domain.MecanographicNumber;
import eapli.base.usermanagement.domain.Student;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

public interface StudentRepository extends DomainRepository<MecanographicNumber, Student> {


    /**
     * returns the total number of Students registered in a specific year
     * @param year
     *              the year to search for
     * @return
     */
    int findTotalMecanographicNumberByYear(String year);

    Student findStudentBySystemUser(SystemUser systemUser);

    List<Student> findStudentsInACourse(Course course);
}
