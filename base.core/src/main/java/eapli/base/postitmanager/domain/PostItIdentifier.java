package eapli.base.postitmanager.domain;

import eapli.base.exceptions.NegativeParameterException;
import eapli.base.exceptions.ZeroParameterException;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class PostItIdentifier implements ValueObject {
    private Long postItId;

    protected PostItIdentifier(long id) throws NegativeParameterException, ZeroParameterException {
        if (id < 0) {
            throw new NegativeParameterException();
        }
        if (id == 0) {
            throw new ZeroParameterException();
        }
        this.postItId = id;
    }

    protected PostItIdentifier() {
        //ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostItIdentifier that = (PostItIdentifier) o;
        return Objects.equals(postItId, that.postItId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postItId);
    }

    public long returnIdentifier() {
        return this.postItId;
    }
    @Override
    public String toString() {
        return postItId.toString();
    }
}
