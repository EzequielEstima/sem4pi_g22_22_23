package eapli.base.postitmanager;

import eapli.base.exceptions.*;
import eapli.base.postitmanager.domain.PostItFactory;
import org.junit.Test;

public class PostItIdentifierTest {
    @Test(expected = ZeroParameterException.class)
    public void ensurePostItIdentifierCannotBeZero() throws ZeroParameterException, NegativeParameterException,
            ParameterNullBlankException, InvalidContentSizeForAPostItException {
        PostItFactory factory = new PostItFactory();
        factory.build("hola", 0);
    }
    @Test(expected = NegativeParameterException.class)
    public void ensurePostItIdentifierCannotBeLowerThanZero() throws ZeroParameterException, NegativeParameterException,
            ParameterNullBlankException, InvalidContentSizeForAPostItException {
        PostItFactory factory = new PostItFactory();
        factory.build("hola", -1);
    }
}
