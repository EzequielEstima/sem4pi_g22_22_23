package eapli.base.usermanagement.repositories;

import eapli.base.usermanagement.domain.BoardOwner;
import eapli.base.usermanagement.domain.ID_Person;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

public interface PersonRepository extends DomainRepository<ID_Person, Person> {

    /**
     * counts the total number of Person in the system
     * @return int with the total number of Person in the system
    */
    int findTotalNumberOfPerson();

    /**
     * search the Person in the system that match with the given email
     * @param email Email to be searched
     * @return the Person that match with the given email
     */
    Person findPersonByEmail(String email);

    /**
     * search the list of Person in the system that match with the given list of EmailAddress
     * @param email List of email to be searched
     * @return List of Person that match with the given List of emails
     */
    List<Person> findAllPersonsWhoMatch(List<EmailAddress> email);

    /**
     * search for a Person in the system that match with the given systemUser
     * @param systemUser SystemUser to be searched
     * @return Person that match with the given systemUser
    */
    Person findPersonBySystemUser(SystemUser systemUser);

    /**
     * search for a Teacher in the system that match with the given person
     * @param person Person to be searched
     * @return Teacher that match with the given person
    */
    Teacher findTeachersByPerson(Person person);

    BoardOwner findBoardOwnerByPerson(Person person);
}
