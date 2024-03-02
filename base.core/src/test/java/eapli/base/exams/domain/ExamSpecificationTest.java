package eapli.base.exams.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExamSpecificationTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatExamSpecificationCannotBeCreateWithNullValues() {
        ExamSpecification test= new ExamSpecification(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatExamSpecificationCannotBeCreateWithEmptyString() {
        ExamSpecification test= new ExamSpecification("");
    }

    @Test
    public void ensureExamSpecificationsEquals() {
        ExamSpecification test1 =  new ExamSpecification("String1");
        ExamSpecification test2 =  new ExamSpecification("String2");

        assertTrue(test1.equals(test1));
        assertFalse(test2.equals(test1));
    }
}