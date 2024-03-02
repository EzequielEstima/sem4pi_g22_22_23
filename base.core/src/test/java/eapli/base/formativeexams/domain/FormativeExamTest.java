package eapli.base.formativeexams.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormativeExamTest {
    @Test(expected = IllegalArgumentException.class)
    public void verifyFormativeExamWithNullValues() {
        FormativeExamFactory formativeExamFactory = new FormativeExamFactory();
        formativeExamFactory.build(0,null);
    }

    @Test
    public void verifySameAs_WithEqualId() {

        FormativeExam formativeExam = new FormativeExam(new FormativeStructure("FormativeStructure"), new FormativeExamID(1));
        FormativeExam formativeExam2 = new FormativeExam(new FormativeStructure("??"), new FormativeExamID(1));

        assertTrue(formativeExam.sameAs(formativeExam2));
    }

    @Test
    public void verifySameAs_WithDifferentId() {

        FormativeExam formativeExam = new FormativeExam(new FormativeStructure("FormativeStructure"), new FormativeExamID(1));
        FormativeExam formativeExam2 = new FormativeExam(new FormativeStructure("??"), new FormativeExamID(2));

        assertFalse(formativeExam.sameAs(formativeExam2));
    }


}