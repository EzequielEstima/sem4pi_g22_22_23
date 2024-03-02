package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.usermanagement.domain.BoardOwner;
import eapli.base.usermanagement.domain.ID_Person;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.domain.Teacher;
import eapli.base.usermanagement.repositories.PersonRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;


public class JpaPersonRepository extends JpaAutoTxRepository<Person, ID_Person,ID_Person> implements PersonRepository {


    public JpaPersonRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaPersonRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }
    @Override
    public int findTotalNumberOfPerson() {
        return (int) count();
    }

    @Override
    public Person findPersonByEmail(String email) {
        return createQuery("SELECT p FROM Person p WHERE p.systemUser.email.email =:email", Person.class)
                .setParameter("email", email).getSingleResult();
    }

    @Override
    public List<Person> findAllPersonsWhoMatch(List<EmailAddress> email) {
        return createQuery("SELECT p FROM Person p WHERE p.systemUser.email IN ( :email )", Person.class)
                .setParameter("email", email).getResultList();
    }

    @Override
    public Person findPersonBySystemUser(SystemUser systemUser) {
        TypedQuery<Person> query = createQuery("SELECT p FROM Person p WHERE p.systemUser = :systemUser",
                Person.class);
        query.setParameter("systemUser", systemUser);
        return query.getSingleResult();
    }

    public Teacher findTeachersByPerson(Person person){
        TypedQuery<Teacher> query = createQuery("SELECT p.teacher FROM Person p WHERE p = :person",
                Teacher.class);
        query.setParameter("person", person);
        return query.getSingleResult();
    }

    @Override
    public BoardOwner findBoardOwnerByPerson(Person person) {
        return createQuery("SELECT b FROM BoardOwner b WHERE b = (SELECT p.boardOwner " +
                "FROM Person p WHERE p = :person)", BoardOwner.class)
                .setParameter("person", person)
                .getSingleResult();

    }

}
