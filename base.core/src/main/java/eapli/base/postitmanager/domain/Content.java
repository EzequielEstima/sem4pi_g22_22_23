package eapli.base.postitmanager.domain;

import eapli.base.exceptions.InvalidContentSizeForAPostItException;
import eapli.base.exceptions.ParameterNullBlankException;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Content implements ValueObject {
    private String content;

    protected Content(String content) throws ParameterNullBlankException, InvalidContentSizeForAPostItException {
        if(content == null || content.isEmpty()|| content.isBlank()){
            throw new ParameterNullBlankException();
        }
        if (content.length()>60){
            throw new InvalidContentSizeForAPostItException();
        }
        this.content = content;
    }

    protected Content(){
        //ORM
    }

    @Override
    public String toString() {
        return content;
    }
}
