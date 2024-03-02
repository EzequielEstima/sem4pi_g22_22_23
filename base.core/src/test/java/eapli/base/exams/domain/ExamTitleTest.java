package eapli.base.exams.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExamTitleTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatExamTitleCannotBeCreateWithNullValues() {
        ExamTitle test= new ExamTitle(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatExamSTitleCannotBeCreateWithEmptyString() {
        ExamTitle test= new ExamTitle("");
    }

    @Test
    public void ensureExamTitleEquals() {
        ExamSpecification test1 =  new ExamSpecification("String1");
        ExamSpecification test2 =  new ExamSpecification("String2");

        assertTrue(test1.equals(test1));
        assertFalse(test2.equals(test1));
    }
}