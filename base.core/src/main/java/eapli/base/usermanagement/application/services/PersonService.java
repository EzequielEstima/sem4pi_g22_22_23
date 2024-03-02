package eapli.base.usermanagement.application.services;


import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.domain.Teacher;
import eapli.base.usermanagement.domain.builder.PersonBuilder;
import eapli.base.usermanagement.domain.builder.StudentBuilder;
import eapli.base.usermanagement.domain.builder.TeacherBuilder;
import eapli.base.usermanagement.repositories.PersonRepository;
import eapli.base.usermanagement.repositories.StudentRepository;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.CurrentTimeCalendars;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class PersonService {


    public String registerNewPerson(String fullname,  String username,  String password,  String firstName,
                                     String lastName,
                                     String email,  Set<Role> roles) {

        UserManagementService userSvc = AuthzRegistry.userService();
        SystemUser user = null;
        try {
            user = userSvc.registerNewUser(username, password, firstName, lastName, email, roles, CurrentTimeCalendars.now());
            PersonBuilder personBuilder = new PersonBuilder();
            personBuilder.with(fullname, user);
            PersonRepository personRepository = PersistenceContext.repositories().personRepository();
            personBuilder.withID(personRepository.findTotalNumberOfPerson() + 1);
            Person per = personBuilder.build();
            personRepository.save(per);
        } catch (Exception e) {
            PersistenceContext.repositories().users().delete(user);
            return "Error: " + e.getMessage();
        }
        return "Success";
    }

    public String registerNewTeacher(String username,  String password,  String firstName,
                                     String lastName,String fullName ,
                                     String email,  Set<Role> roles,String acronym, Date dateOfBirth, int taxPayerNumber){

        UserManagementService userSvc = AuthzRegistry.userService();
        SystemUser user = null;
        try {
            user = userSvc.registerNewUser(username, password, firstName, lastName, email, roles, CurrentTimeCalendars.now());
            TeacherBuilder teacherBuilder = new TeacherBuilder();
            teacherBuilder.with(acronym,dateOfBirth,taxPayerNumber);
            Teacher teacher = teacherBuilder.build();

            PersonBuilder personBuilder = new PersonBuilder();
            personBuilder.with(fullName, user,teacher);
            PersonRepository personRepository = PersistenceContext.repositories().personRepository();
            personBuilder.withID(personRepository.findTotalNumberOfPerson() + 1);
            Person per = personBuilder.build();
            personRepository.save(per);


            //personRepository.save(teacher);
        } catch (Exception e) {
            PersistenceContext.repositories().users().delete(user);
            return "Error: " + e.getMessage();
        }
        return "Success";
    }

    public String registerNewStudent( String username,  String password,  String firstName,
                                      String lastName,  String fullName,
                                      String email,  Set<Role> roles, Date dateOfBirth, int taxPayerNumber){

        UserManagementService userSvc = AuthzRegistry.userService();
        SystemUser user = null;
        try {

            user = userSvc.registerNewUser(username, password, firstName, lastName, email, roles, CurrentTimeCalendars.now());


            StudentBuilder studentBuilder = new StudentBuilder();
            studentBuilder.with(dateOfBirth,taxPayerNumber);
            StudentRepository studentRepository = PersistenceContext.repositories().studentRepository();
            String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
            studentBuilder.withMecanographicNumber(studentRepository.findTotalMecanographicNumberByYear(year) + 1,year);
            Student student = studentBuilder.build();

            PersonBuilder personBuilder = new PersonBuilder();
            personBuilder.with(fullName, user,student);
            PersonRepository personRepository = PersistenceContext.repositories().personRepository();
            personBuilder.withID(personRepository.findTotalNumberOfPerson() + 1);
            Person per = personBuilder.build();
            personRepository.save(per);

        }catch (Exception e){
            PersistenceContext.repositories().users().delete(user);
            return "Error: " + e.getMessage();
        }
        return "Success";
    }
}
