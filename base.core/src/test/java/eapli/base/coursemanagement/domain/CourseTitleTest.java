package eapli.base.coursemanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTitleTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureCourseTitleIsNotNull(){
        CourseTitle instance = new CourseTitle(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCourseTitleIsNotBlank(){
        CourseTitle instance = new CourseTitle("       ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCourseTitleIsNotEmpty(){
        CourseTitle instance = new CourseTitle("");
    }
    @Test
    public void ensureSameCourseTitleAreEqual(){
        CourseTitle instance1 = new CourseTitle("CourseTitle1");
        CourseTitle instance2 = new CourseTitle("CourseTitle1");
        assertEquals(instance1, instance2);
    }

    @Test
    public void ensureDiffCourseTitleAreNotEqual(){
        CourseTitle instance1 = new CourseTitle("CourseTitle1");
        CourseTitle instance2 = new CourseTitle("CourseTitle2");
        assertNotEquals(instance1, instance2);
    }

}