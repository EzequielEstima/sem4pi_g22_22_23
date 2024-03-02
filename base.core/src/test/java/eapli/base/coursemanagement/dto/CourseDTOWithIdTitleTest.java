package eapli.base.coursemanagement.dto;

import eapli.base.coursemanagement.domain.*;
import eapli.base.usermanagement.domain.Teacher;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseDTOWithIdTitleTest {

    @Test
    public void ensureThatCourseDTOWithIdTitleHasTheCorrectFormat() {
        Course course = new Course(new CourseIdentifier("Id1"), new CourseTitle("Title1"), new CourseName("Name1"), new Description("Desciption1"), new EnrollmentLimits(1, 5), new CourseStatus("CLOSE"), new Teacher());
        CourseDTOWithIdTitle test = CourseMapper.toDTOWithIdTitle(course);
        assertEquals(test.toString(), "Title1 - Id1");
    }

}