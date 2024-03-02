package eapli.base.usermanagement.domain.builder;


import eapli.base.usermanagement.domain.*;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class PersonBuilder implements DomainFactory<Person> {

    private SystemUser systemUser;
    private FullName fullName;

    private ID_Person id;

    private Teacher teacher;

    private Student student;

    public PersonBuilder with(String fullName ,SystemUser user){
        withSystemUser(user);
        withfullName(fullName);
        return this;
    }

    public PersonBuilder with(String fullName ,SystemUser user,Teacher teacher){
        withSystemUser(user);
        withfullName(fullName);
        withTeacher(teacher);
        return this;
    }

    public PersonBuilder with(String fullName ,SystemUser user,Student student){
        withSystemUser(user);
        withfullName(fullName);
        withStudent(student);
        return this;
    }

    public PersonBuilder withSystemUser(final SystemUser systemUser) {
        this.systemUser = systemUser;
        return this;
    }

    public PersonBuilder withID(final int id) {
        this.id = new ID_Person(id);
        return this;
    }

    public PersonBuilder withfullName(final String fullName) {
        this.fullName = new FullName(fullName);
        return this;
    }

    public PersonBuilder withTeacher(final Teacher teacher) {
        this.teacher = teacher;
        return this;
    }

    public PersonBuilder withStudent(final Student student) {
        this.student = student;
        return this;
    }
    @Override
    public Person build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor
        if (teacher == null && student == null) {
            return new Person(systemUser, fullName, id);
        }else if (teacher != null && student == null){
            return new Person(systemUser,fullName,id,teacher);
        }else if (teacher == null && student != null){
            return new Person(systemUser,fullName,id,student);
        }

        return null;
    }
}

