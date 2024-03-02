package eapli.base.enrollments.application.services;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.coursemanagement.dto.CourseMapper;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.enrollments.domain.Enrollment;
import eapli.base.enrollments.domain.Factories.EnrollmentFactory;
import eapli.base.enrollments.repositories.EnrollmentRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.MecanographicNumber;
import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.repositories.StudentRepository;
import eapli.base.utils.CsvReader;
import java.util.ArrayList;
import java.util.List;

public class EnrollInBulkService {

    private final CourseRepository courseRepository = PersistenceContext.repositories().courseRepository();
    private final StudentRepository studentRepository = PersistenceContext.repositories().studentRepository();
    private final EnrollmentRepository enrollmentRepository = PersistenceContext.repositories().enrollmentRepository();
    private List<String> studentIdList = new ArrayList<>();
    public boolean importCsvData(String fileName){
        CsvReader csvReader = new CsvReader();
        boolean importResult = csvReader.importCsvData(fileName, studentIdList);
        return importResult;
    }

    public void enrollStudentsInBulkToCourse(CourseDTOWithIdTitle selectedCourse){
        Course course = courseRepository.ofIdentity(new CourseIdentifier(selectedCourse.courseIdentifier)).get();

        if(!verifyIfWillExceedEnrollmentLimits(course, studentIdList.size())){
            for (String studentId : studentIdList) {
                Student student;

                try{
                    student = studentRepository.ofIdentity(new MecanographicNumber(studentId)).get();
                    if(!enrollmentRepository.findEnrollmentByCourseIDAndMechNumber(course.identity(), student.identity()).isPresent()){
                        long totalNumberOfEnrollments = enrollmentRepository.count();
                        Enrollment newEnrollment = new EnrollmentFactory().buildEnrollmentFromEnrollInBulk(totalNumberOfEnrollments + 1, course, student);
                        enrollmentRepository.save(newEnrollment);
                        course.addEnrollment(newEnrollment);
                        courseRepository.save(course);
                        student.addEnrollment(newEnrollment);
                        studentRepository.save(student);
                    }
                }catch (Exception e){
                    System.out.printf("The mechanographic number %s doesn't exist in the data base!\n\n", studentId);
                }
            }
        }

    }

    public boolean verifyIfWillExceedEnrollmentLimits(Course course, int numberOfNewEnrollments){
        int enrollmentsAccepted = enrollmentRepository.getNumberOfEnrollmentsAcceptedByCourse(course);
        return course.verifyIfWillExceedEnrollmentLimits(enrollmentsAccepted, numberOfNewEnrollments);
    }
}
