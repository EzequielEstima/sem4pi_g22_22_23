package eapli.base.postitmanager;

import eapli.base.exceptions.*;
import eapli.base.postitmanager.domain.PostItFactory;
import org.junit.Test;

public class ContentTest {
    @Test(expected = ParameterNullBlankException.class)
    public void ensureContentCannotBeNull() throws ZeroParameterException, NegativeParameterException,
            ParameterNullBlankException, InvalidContentSizeForAPostItException {
        PostItFactory factory = new PostItFactory();
        factory.build(null, 1);
    }
    @Test(expected = InvalidContentSizeForAPostItException.class)
    public void ensureContentSizeCannotBeBiggerThanSixteen() throws ZeroParameterException, NegativeParameterException,
            ParameterNullBlankException, InvalidContentSizeForAPostItException {
        PostItFactory factory = new PostItFactory();
        factory.build("WOLOLOWOLOLOWOLOLOWOLOLOWOLOLOWOLOLOWOLOLOWOLOLOWOLOLOWOLOLOO", 1);
    }
}
