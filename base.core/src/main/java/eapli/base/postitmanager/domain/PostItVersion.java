package eapli.base.postitmanager.domain;

import eapli.base.exceptions.NegativeParameterException;
import eapli.base.exceptions.ZeroParameterException;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class PostItVersion implements ValueObject {
    private int version;

    protected PostItVersion(int version) throws NegativeParameterException, ZeroParameterException {
        if (version < 0) {
            throw new NegativeParameterException();
        }
        if (version == 0) {
            throw new ZeroParameterException();
        }
        this.version = version;
    }

    protected PostItVersion() {
        //ORM use only
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostItVersion that = (PostItVersion) o;
        return Objects.equals(version, that.version);
    }

    public void updateVersion() {
        this.version++;
    }

    public int returnVersion() {
        return this.version;
    }
}
