package eapli.base.postitmanager.domain;

import eapli.base.exceptions.*;

public class PostItFactory {

    /**
     * @param id long with the id to set in the PostIt
     * @param content String with the content to set in the PostIt
     * @return the PostIt with the id and content set
     */
    public PostIt build(String content, long id) throws ZeroParameterException,
            NegativeParameterException, ParameterNullBlankException,
            InvalidContentSizeForAPostItException {

        return new PostIt( new PostItKey (new PostItIdentifier(id),new PostItVersion(1))
                ,new Content(content));

    }

    public PostIt buildFromExistingPostIt(String content, long oldId, int oldVer) throws ZeroParameterException, ParameterNullBlankException, NegativeParameterException, InvalidContentSizeForAPostItException {
        return new PostIt(new PostItKey(new PostItIdentifier(oldId),new PostItVersion(oldVer + 1)),new Content(content));
    }
}
