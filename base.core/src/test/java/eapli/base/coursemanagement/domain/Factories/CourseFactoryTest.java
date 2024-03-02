package eapli.base.coursemanagement.domain.Factories;


import eapli.base.coursemanagement.domain.Course;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseFactoryTest {

    @Test
    public void ensureCourseIsCloseWhenCreated(){
        CourseFactory fac = new CourseFactory();
        Course instance = fac.buildCourse("Id1","Title1","Name1","Desc1",10,1);
        assertEquals("Close",instance.returnCourseStatusString());
    }

    @Test
    public void ensureCourseHasNoTeacherInChargeWhenCreated(){
        CourseFactory fac = new CourseFactory();
        Course instance = fac.buildCourse("Id1","Title1","Name1","Desc1",10,1);
        assertFalse(instance.hasTeacherInCharge());
    }
}