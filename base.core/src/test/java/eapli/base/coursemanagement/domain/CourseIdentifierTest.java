package eapli.base.coursemanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseIdentifierTest {
    @Test(expected = IllegalArgumentException.class)
    public void ensureCourseIdentifierIsNotNull(){
        CourseIdentifier instance = new CourseIdentifier(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCourseIdentifierIsNotBlank(){
        CourseIdentifier instance = new CourseIdentifier("       ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCourseIdentifierIsNotEmpty(){
        CourseIdentifier instance = new CourseIdentifier("");
    }
    @Test
    public void ensureSameCourseIdentifierAreEqual(){
        CourseIdentifier instance1 = new CourseIdentifier("JAVA-1");
        CourseIdentifier instance2 = new CourseIdentifier("JAVA-1");
        assertEquals(instance1, instance2);
    }

    @Test
    public void ensureDiffCourseIdentifierAreNotEqual(){
        CourseIdentifier instance1 = new CourseIdentifier("JAVA-1");
        CourseIdentifier instance2 = new CourseIdentifier("JAVA-2");
        assertNotEquals(instance1, instance2);
    }
}