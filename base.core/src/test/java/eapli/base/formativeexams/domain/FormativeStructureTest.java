package eapli.base.formativeexams.domain;

import eapli.base.courseclasses.domain.Date;
import eapli.base.courseclasses.domain.Duration;
import eapli.base.courseclasses.domain.ScheduledDate;
import org.junit.Test;

import static org.junit.Assert.*;

public class FormativeStructureTest {
    @Test
    public void ensureStructuresAreEquals() {

        FormativeStructure test1 = new FormativeStructure("not test");
        FormativeStructure test2 = new FormativeStructure("test");

        assertTrue(test1.equals(test1));
        assertFalse(test1.equals(test2));
    }
}