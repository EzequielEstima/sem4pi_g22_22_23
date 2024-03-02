package eapli.base.infrastructure.bootstrapers;

import eapli.base.coursemanagement.application.AddTeacherInACourseController;
import eapli.base.coursemanagement.application.CreateCourseController;
import eapli.base.coursemanagement.application.OpenCloseCourseController;
import eapli.base.coursemanagement.application.OpenCloseCourseEnrollmentsController;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitleStatus;
import eapli.base.enrollments.application.EnrollInBulkController;
import eapli.base.usermanagement.dto.TeacherDTOWithAcronym;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CourseBootstrapperBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersBootstrapperBase.class);

    final CreateCourseController createCourseController = new CreateCourseController();
    final OpenCloseCourseController openCloseCourseController = new OpenCloseCourseController();

    final AddTeacherInACourseController addTeacherInACourseController = new AddTeacherInACourseController();

    final EnrollInBulkController enrollInBulkController = new EnrollInBulkController();

    final OpenCloseCourseEnrollmentsController openCloseCourseEnrollmentsController = new OpenCloseCourseEnrollmentsController();
    protected boolean createCourseBaseBootstrap(final String courseId, final String courseTitle, final String courseName, final String description, final int maxEnrollments, final int minEnrollments) {
        return createCourseController.createCourse(courseId, courseTitle, courseName, description, maxEnrollments, minEnrollments);
    }
    protected void openCourseBaseBootstrap(final String courseId, final String courseTitle) {
        CourseDTOWithIdTitleStatus courseDTO = new CourseDTOWithIdTitleStatus(courseId, courseTitle,"CLOSE");
        openCloseCourseController.changeCourseStatus(courseDTO, "OPEN");
    }
    protected void closeCourseBaseBootstrap(final String courseId, final String courseTitle){
        CourseDTOWithIdTitleStatus courseDTO = new CourseDTOWithIdTitleStatus(courseId, courseTitle,"CLOSED_ENROLLMENTS");
        openCloseCourseController.changeCourseStatus(courseDTO, "CLOSED");
    }

    protected void openEnrollmentsCourseBaseBootstrap(final String courseId, final String courseTitle){
        CourseDTOWithIdTitleStatus courseDTO = new CourseDTOWithIdTitleStatus(courseId, courseTitle,"OPEN");
        openCloseCourseEnrollmentsController.changeStatus(courseDTO, "OPEN_ENROLLMENTS");
    }

    protected void closeEnrollmentsCourseBaseBootstrap(final String courseId, final String courseTitle){
        CourseDTOWithIdTitleStatus courseDTO = new CourseDTOWithIdTitleStatus(courseId, courseTitle,"OPEN_ENROLLMENTS");
        openCloseCourseEnrollmentsController.changeStatus(courseDTO, "CLOSED_ENROLLMENTS");
    }

    protected void addTeacherToCourseBaseBootstrap(TeacherDTOWithAcronym teacherDTOWithAcronym, CourseDTOWithIdTitle courseDTOWithIdTitle){
        List<TeacherDTOWithAcronym> teacherDTOWithAcronymList = new ArrayList<>();
        teacherDTOWithAcronymList.add(teacherDTOWithAcronym);
        addTeacherInACourseController.addTeacherInACourse(teacherDTOWithAcronymList, courseDTOWithIdTitle);
    }

    protected void addStudentToCourseBaseBootstrap(CourseDTOWithIdTitle courseDTO, String filePath){
        enrollInBulkController.importCsvData(filePath);
        enrollInBulkController.enrollStudentsInBulkToCourse(courseDTO);
    }
}
