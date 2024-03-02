package eapli.base.courseclasses.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExtraClassIdTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureExtraClassIdIsNotNegative(){
        ExtraClassId instance = new ExtraClassId((long) -1);
    }

    @Test
    public void ensureSameExtraClassIdsAreEqual(){
        ExtraClassId instance1 = new ExtraClassId((long) 8);
        ExtraClassId instance2 = new ExtraClassId((long) 8);
        assertEquals(instance1, instance2);
    }

    @Test
    public void ensureDifferentExtraClassIdsAreNotEqual(){
        ExtraClassId instance1 = new ExtraClassId((long) 8);
        ExtraClassId instance2 = new ExtraClassId((long) 7);
        assertNotEquals(instance1, instance2);
    }
}