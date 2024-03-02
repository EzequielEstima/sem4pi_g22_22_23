package eapli.base.postitmanager;

import eapli.base.exceptions.*;
import eapli.base.postitmanager.domain.PostIt;
import eapli.base.postitmanager.domain.PostItFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class PostItTest {

    private PostIt dummyPostIt(long id, String content) throws ZeroParameterException, NegativeParameterException,
            ParameterNullBlankException, InvalidContentSizeForAPostItException {
        PostItFactory factory = new PostItFactory();
        return factory.build(content, id);
    }
    public PostIt getDummyPostIt(long id, String content) throws ZeroParameterException, NegativeParameterException,
            ParameterNullBlankException, InvalidContentSizeForAPostItException {
        return dummyPostIt(id, content);
    }
    @Test
    public void ensurePostItSameAsOtherPostItWithSameIdentity() throws ZeroParameterException, NegativeParameterException,
            ParameterNullBlankException, InvalidContentSizeForAPostItException {
        PostIt postIt = getDummyPostIt(1, "HOLA");
        assertTrue(postIt.sameAs(getDummyPostIt(1, "???")));
    }
    @Test
    public void ensurePostItSameAsOtherObjectFails() throws ZeroParameterException, NegativeParameterException,
            ParameterNullBlankException, InvalidContentSizeForAPostItException {
        PostIt postIt = getDummyPostIt(1, "HOLA");
        assertFalse(postIt.sameAs(Object.class));
    }

    @Test
    public void ensurePostItSameAsOtherPostItWithDifferentIdentityFails() throws ZeroParameterException,
            NegativeParameterException, ParameterNullBlankException, InvalidContentSizeForAPostItException {
        PostIt postIt = getDummyPostIt(1, "HOLA");
        assertFalse(postIt.sameAs(getDummyPostIt(2, "HOLA")));
    }

    @Test
    public void ensurePostItSameAsItself() throws ZeroParameterException, NegativeParameterException,
            ParameterNullBlankException, InvalidContentSizeForAPostItException {
        PostIt postIt = getDummyPostIt(1, "HOLA");
        assertTrue(postIt.sameAs(postIt));
    }



}