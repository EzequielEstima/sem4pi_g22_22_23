package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.coursemanagement.dto.CourseDTOBuilder;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.infrastructure.bootstrapers.CourseBootstrapperBase;
import eapli.base.infrastructure.bootstrapers.TestDataConstants;
import eapli.base.usermanagement.dto.TeacherDTOBuilder;
import eapli.base.usermanagement.dto.TeacherDTOWithAcronym;
import eapli.framework.actions.Action;

import java.util.ArrayList;

public class CourseBootstrapper extends CourseBootstrapperBase implements Action {
    @Override
    public boolean execute() {
        ArrayList<Boolean> results = new ArrayList<>();
        results.add(createCourse("course1", "course1Title", "course1Name", "course1Description", 20, 2));
        results.add(createCourse("course2", "course2Title", "course2Name", "course2Description", 3, 1));
        results.add(createCourse("course3", "course3Title", "course3Name", "course3Description", 5, 3));
        results.add(createCourse("courseOpen","courseOpenTitle", "courseOpenName", "courseOpenDescription", 20,2));
        openCourse("courseOpen", "courseOpenTitle");
        results.add(createCourse("courseOpenEnrollments","courseOpenEnrollmentsTitle", "courseOpenEnrollmentsName", "courseOpenEnrollmentsDescription", 20,2));
        openCourse("courseOpenEnrollments", "courseOpenEnrollmentsTitle");
        openEnrollmentsCourse("courseOpenEnrollments", "courseOpenEnrollmentsTitle");
        results.add(createCourse("courseClosedEnrollments","courseClosedEnrollmentsTitle", "courseClosedEnrollmentsName", "courseClosedEnrollmentsDescription", 20,2));
        openCourse("courseClosedEnrollments", "courseClosedEnrollmentsTitle");
        openEnrollmentsCourse("courseClosedEnrollments", "courseClosedEnrollmentsTitle");
        closeEnrollmentsCourse("courseClosedEnrollments", "courseClosedEnrollmentsTitle");
        results.add(createCourse("courseClosed","courseClosedTitle", "courseClosedName", "courseClosedDescription", 20,2));
        openCourse("courseClosed", "courseClosedTitle");
        openEnrollmentsCourse("courseClosed", "courseClosedTitle");
        closeEnrollmentsCourse("courseClosed", "courseClosedTitle");
        closeCourse("courseClosed", "courseClosedTitle");

        //add teacher
        TeacherDTOWithAcronym teacherDTOWithAcronym= new TeacherDTOBuilder().withAcronym("OST").withDateOfBirth("01-11-2000").withTaxPayerNumber("100000001").buildWithAcronym();
        CourseDTOWithIdTitle courseDTOWithIdTitle = new CourseDTOBuilder().withCourseTitle("courseOpenEnrollmentsTitle").withCourseIdentifier("courseOpenEnrollments").buildWithIdTitle();
        addTeacherToCourse(teacherDTOWithAcronym, courseDTOWithIdTitle);

        //add student
        addStudentToCourse(courseDTOWithIdTitle,"base.bootstrappers/files/student");


        for(Boolean result : results){
            if(!result) return false;
        }
        return true;
    }


    private boolean createCourse(final String courseId, final String courseTitle, final String courseName, final String description, final int maxEnrollments, final int minEnrollments){
         return createCourseBaseBootstrap(courseId, courseTitle, courseName, description, maxEnrollments, minEnrollments);
    }
    private void openCourse(final String courseId, final String courseTitle){
        openCourseBaseBootstrap(courseId, courseTitle);
    }
    private void closeCourse(final String courseId, final String courseTitle){
        closeCourseBaseBootstrap(courseId, courseTitle);
    }

    private void openEnrollmentsCourse(final String courseId, final String courseTitle){
        openEnrollmentsCourseBaseBootstrap(courseId, courseTitle);
    }

    private void closeEnrollmentsCourse(final String courseId, final String courseTitle){
        closeEnrollmentsCourseBaseBootstrap(courseId, courseTitle);
    }

    private void addTeacherToCourse(final TeacherDTOWithAcronym teacher, final CourseDTOWithIdTitle course){
        addTeacherToCourseBaseBootstrap(teacher, course);
    }

    private void addStudentToCourse(final CourseDTOWithIdTitle courseDTO, final String filePath){
        addStudentToCourseBaseBootstrap(courseDTO, filePath);
    }
}
