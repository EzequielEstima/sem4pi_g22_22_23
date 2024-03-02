package eapli.base.coursemanagement.application.services;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.coursemanagement.dto.CourseMapper;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Teacher;
import eapli.base.usermanagement.dto.TeacherDTOWithAcronym;
import eapli.base.usermanagement.dto.TeacherMapper;
import eapli.base.usermanagement.repositories.TeacherRepository;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class SetTeacherService {

    private final TeacherRepository teacherRepository = PersistenceContext.repositories().teacherRepository();
    private final CourseRepository courseRepository = PersistenceContext.repositories().courseRepository();

    public Pair<List<TeacherDTOWithAcronym>, List<CourseDTOWithIdTitle>> requestInformation() {

        Iterable<Teacher> teachers = teacherRepository.findAllTeachers();
        List<Course> courses = courseRepository.listAllAvailableCourses();

        List<TeacherDTOWithAcronym> teachersDTO = new ArrayList<>();
        List<CourseDTOWithIdTitle> coursesDTO = new ArrayList<>();

        for (Teacher teacher : teachers) {
            teachersDTO.add(TeacherMapper.toDTOWithAcronym(teacher));
        }
        for (Course course : courses) {
            coursesDTO.add(CourseMapper.toDTOWithIdTitle(course));
        }
        return Pair.of(teachersDTO, coursesDTO);
    }

    public boolean addTeacher(List<TeacherDTOWithAcronym> teacherDTO, CourseDTOWithIdTitle courseDTO) {
        List<Teacher> teachers = new ArrayList<>();
        for (TeacherDTOWithAcronym teacher : teacherDTO) {
            teachers.add(teacherRepository.findTeacherByAcronym(teacher.acronym));
        }
        Course course = courseRepository.findCourseById(courseDTO.courseIdentifier);

        if (course.addTeachersToList(teachers)) {
            return courseRepository.save(course) != null;
        }
        else {
            return false;
        }
    }

    public boolean addTeacherInCharge(TeacherDTOWithAcronym teacherDTO, CourseDTOWithIdTitle courseDTO) {
        Teacher teacher = teacherRepository.findTeacherByAcronym(teacherDTO.acronym);
        Course course = courseRepository.findCourseById(courseDTO.courseIdentifier);
        if (course.addTeacherInCharge(teacher)) {
            return courseRepository.save(course) != null;
        }
        else {
            return false;
        }
    }
}
