package eapli.base.usermanagement.application.services;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.repositories.PersonRepository;
import eapli.framework.general.domain.model.EmailAddress;
import org.springframework.transaction.IllegalTransactionStateException;

import java.util.ArrayList;
import java.util.List;

public class ListPersonService {

    private final PersonRepository personRepository = PersistenceContext.repositories().personRepository();

    public List<Person> getPersonsByEmail(List<String> emails) {
        // TODO
        List<EmailAddress> emailAddresses = new ArrayList<>();
        for (String email : emails) {
            EmailAddress emailAddress = EmailAddress.valueOf(email);
            emailAddresses.add(emailAddress);
        }
        List<Person> persons = personRepository.findAllPersonsWhoMatch(emailAddresses);

        if (persons.isEmpty()) {
            throw new IllegalTransactionStateException("No person found with the given email");
        }

        return persons;
    }
}
