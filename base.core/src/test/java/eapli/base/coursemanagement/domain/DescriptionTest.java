package eapli.base.coursemanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class DescriptionTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureCourseDescriptionIsNotNull(){
        Description instance = new Description(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCourseDescriptionIsNotBlank(){
        Description instance = new Description("       ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCourseDescriptionIsNotEmpty(){
        Description instance = new Description("");
    }
    @Test
    public void ensureSameCourseDescriptionAreEqual(){
        Description instance1 = new Description("Description1");
        Description instance2 = new Description("Description1");
        assertEquals(instance1, instance2);
    }

    @Test
    public void ensureDiffCourseDescriptionAreNotEqual(){
        Description instance1 = new Description("Description1");
        Description instance2 = new Description("Description2");
        assertNotEquals(instance1, instance2);
    }

}