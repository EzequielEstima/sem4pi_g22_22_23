package eapli.base.persistence.impl.inmemory;

import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.formativeexams.domain.FormativeExam;
import eapli.base.formativeexams.domain.FormativeExamID;
import eapli.base.formativeexams.repositories.FormativeExamRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryFormativeExamRepository extends InMemoryDomainRepository<FormativeExam, FormativeExamID>  implements FormativeExamRepository {

    @Override
    public List<FormativeExam> findFormativeExamsFromCourse(CourseIdentifier courseId) {
        return null;
    }
}
