package eapli.base.persistence.impl.inmemory;

import eapli.base.usermanagement.domain.BoardOwner;
import eapli.base.usermanagement.domain.ID_Person;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.domain.Teacher;
import eapli.base.usermanagement.repositories.PersonRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class InMemoryPersonRepository extends InMemoryDomainRepository<Person, ID_Person>
        implements PersonRepository {
    @Override
    public int findTotalNumberOfPerson() {
        return (int) count();
    }

    @Override
    public Person findPersonByEmail(String email) {
        return null;
    }

    @Override
    public List<Person> findAllPersonsWhoMatch(List<EmailAddress> email) {
        return null;
    }

    @Override
    public Person findPersonBySystemUser(SystemUser systemUser) {
        return null;
    }

    @Override
    public Teacher findTeachersByPerson(Person person) {
        return null;
    }

    @Override
    public BoardOwner findBoardOwnerByPerson(Person person) {
        return null;
    }


}
