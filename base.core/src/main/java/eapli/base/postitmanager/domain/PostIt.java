package eapli.base.postitmanager.domain;

import eapli.base.exceptions.NegativeParameterException;
import eapli.base.exceptions.ParameterNullBlankException;
import eapli.base.exceptions.ZeroParameterException;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class PostIt implements AggregateRoot<PostItKey> {
    @EmbeddedId
    private PostItKey postItKey;
    private Content content;
    private PostItDate date;
    protected PostIt(PostItKey postItKey, Content content) throws ZeroParameterException, NegativeParameterException,
            ParameterNullBlankException {
        if (postItKey == null || content == null) {
            throw new ParameterNullBlankException();
        }
        this.postItKey = postItKey;
        this.content = content;
        this.date = new PostItDate(new java.util.Date());
    }
    protected PostIt() {
        // for ORM only
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostIt postIt = (PostIt) o;
        return Objects.equals(postItKey, postIt.postItKey);
    }
    @Override
    public int hashCode() {
        return Objects.hash(postItKey);
    }
    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof PostIt)) {
            return false;
        }

        final PostIt that = (PostIt) other;

        return this.postItKey.equals(that.postItKey);
    }
    @Override
    public PostItKey identity() {
        return postItKey;
    }
    public String returnContentString(){
        return content.toString();
    }

    public String returnDateString(){
        return date.toString();
    }


    public void updateVersion(){
        this.postItKey.updateVersion();
    }

    public int returnPostItVersion() {
        return postItKey.returnPostItVersion();
    }
    public long returnPostItIdentifier() {
        return postItKey.returnPostItIdentifier();
    }
    @Override
    public String toString() {
        return postItKey.toString();
    }
}
