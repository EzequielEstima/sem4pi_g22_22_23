package eapli.base.persistence.impl.inmemory;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.exams.domain.Exam;
import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.domain.Teacher;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryCourseRepository extends InMemoryDomainRepository<Course, CourseIdentifier> implements CourseRepository {

    @Override
    public List<Course> listOpenableClosableCourses() {
        return (List<Course>) match(e -> (e.returnCourseStatusString().equals("Enrollments closed") || e.returnCourseStatusString().equals("Close")));
    }

    @Override
    public List<Course> listAllOpenCLoseEnrollmentsAvailableCourses() {
        return null;
    }

    @Override
    public List<Course> listAllAvailableCourses() {
        return (List<Course>) match(e -> (e.returnCourseStatusString().equals("Enrollments open") || e.returnCourseStatusString().equals("Open") || e.returnCourseStatusString().equals("Enrollments closed")));
    }

    @Override
    public List<Course> findTeacherInChargeCourses(SystemUser systemUser) {
        return null;
    }

    @Override
    public List<Course> findTeacherLecturesCourses(SystemUser systemUser) {
        return null;
    }

    @Override
    public List<Course> findStudentCourses(SystemUser systemUser) {
        return null;
    }

    @Override
    public List<Course> findStudentInACourses(SystemUser systemUser) {
        return null;
    }

    @Override
    public List<Course> listAllCoursesOpenToEnrollments() {
        return (List<Course>) match(e -> (e.returnCourseStatusString().equals("Enrollments open")));
    }

    @Override
    public Course findCourseById(String courseIdentifier) {
        return matchOne(e -> e.returnCourseIdentifierString().equals(courseIdentifier)).orElse(null);
    }

    @Override
    public List<Course> findAllCourseRelatedWithTheMembersOfAGivenCourse(List<Student> students, List<Teacher> teachers) {
        return null;
    }
    @Override
    public List<Course> listAcceptedCoursesByStudent(SystemUser systemUser){
        return null;
    }

    @Override
    public Course findCourseByExam(Exam exam) {
        return null;
    }
}
