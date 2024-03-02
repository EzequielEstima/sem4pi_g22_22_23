package eapli.base.coursemanagement.repositories;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.exams.domain.Exam;
import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

public interface CourseRepository extends DomainRepository<CourseIdentifier, Course> {
    List<Course> listOpenableClosableCourses();

    List<Course> listAllOpenCLoseEnrollmentsAvailableCourses();

    List<Course> listAllAvailableCourses();

    List<Course> findTeacherInChargeCourses(SystemUser systemUser);

    List<Course> findTeacherLecturesCourses(SystemUser systemUser);

    List<Course> findStudentCourses(SystemUser systemUser);

    List<Course> findStudentInACourses(SystemUser systemUser);

    List<Course> listAllCoursesOpenToEnrollments();

    Course findCourseById(String courseIdentifier);

    List<Course> findAllCourseRelatedWithTheMembersOfAGivenCourse(List<Student> students,List<Teacher> teachers);

    List<Course> listAcceptedCoursesByStudent(SystemUser systemUser);

    Course findCourseByExam(Exam exam);
}
