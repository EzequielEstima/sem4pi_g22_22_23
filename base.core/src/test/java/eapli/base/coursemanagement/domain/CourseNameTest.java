package eapli.base.coursemanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseNameTest {
    @Test(expected = IllegalArgumentException.class)
    public void ensureCourseNameIsNotNull(){
        CourseName instance = new CourseName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCourseNameIsNotBlank(){
        CourseName instance = new CourseName("       ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCourseNameIsNotEmpty(){
        CourseName instance = new CourseName("");
    }
    @Test
    public void ensureSameCourseNameAreEqual(){
        CourseName instance1 = new CourseName("CourseName1");
        CourseName instance2 = new CourseName("CourseName1");
        assertEquals(instance1, instance2);
    }

    @Test
    public void ensureDiffCourseNameAreNotEqual(){
        CourseName instance1 = new CourseName("CourseName1");
        CourseName instance2 = new CourseName("CourseName2");
        assertNotEquals(instance1, instance2);
    }
}