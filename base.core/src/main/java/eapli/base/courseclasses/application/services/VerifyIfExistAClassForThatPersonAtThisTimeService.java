package eapli.base.courseclasses.application.services;

import eapli.base.courseclasses.domain.Class;
import eapli.base.courseclasses.repositories.ClassRepository;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.domain.Teacher;
import eapli.base.usermanagement.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VerifyIfExistAClassForThatPersonAtThisTimeService {

    private final ClassRepository classRepository = PersistenceContext.repositories().classRepository();
    private final CourseRepository courseRepository = PersistenceContext.repositories().courseRepository();
    private final PersonRepository personRepository = PersistenceContext.repositories().personRepository();


    /**
     * Verifies if exist a class at the time for the given people
     * @param people List of person who can be a teacher or a student of the class
     * @param utilDate date of the class
     * @param duration duration of the class
     * @return true if exist a class at the time
     */
    public Boolean verifyIfExistAClass(List<Person> people, Date utilDate, int duration) {
        // TODO

        List<List<Course>> coursesList = new ArrayList<>();

        for (Person person : people){
            coursesList.add(courseRepository.findStudentInACourses(person.user()));
        }

        List<List<Class>> classesListByStudents = new ArrayList<>();
        for (List<Course> courses: coursesList) {
            for (Course course: courses) {
                if (course!=null){
                    classesListByStudents.add(classRepository.findClassesInACourse(course));
                }
            }
        }

        List<Teacher> teachers = new ArrayList<>();
        for (Person person : people){
            if (person.isATeacher()){
                Teacher teacher = personRepository.findTeachersByPerson(person);
                teachers.add(teacher);
            }
        }

        List<List<Class>> allClasses = new ArrayList<>();
        for (Teacher teacher : teachers) {
            List<Class> teacherClasses = classRepository.findAllClassesByTeacher(teacher);
            allClasses.add(teacherClasses);
        }

        if (allClasses.isEmpty()&&classesListByStudents.isEmpty()){
            return false;
        }

        for (List<Class> teacherClasse : allClasses){
            for (Class classe : teacherClasse){
                if (classe.verifyIfAClassAtTheTime(utilDate,duration)) {
                    return true;
                }
            }
        }
        
        for (List<Class> classes : classesListByStudents){
            for (Class classe : classes){
                if (classe.verifyIfAClassAtTheTime(utilDate,duration)) {
                    return true;
                }
            }
        }

        return false;
    }

}
