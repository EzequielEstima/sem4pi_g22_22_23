package eapli.base.exams.application.services;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.exams.domain.Exam;
import eapli.base.exams.dto.ExamDTOWithDatesExamTitleCourseId;
import eapli.base.exams.dto.ExamDTOWithDatesExamTitleCourseIdMapper;
import eapli.base.exams.repositories.ExamRepository;
import eapli.base.exams.repositories.ExamResolutionRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.repositories.StudentRepository;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListStudentAvailableExamsService {
    public List<ExamDTOWithDatesExamTitleCourseId> listStudentAvailableExams(){
        CourseRepository courseRepo = PersistenceContext.repositories().courseRepository();
        ExamRepository examRepo = PersistenceContext.repositories().examRepository();
        StudentRepository studentRepo = PersistenceContext.repositories().studentRepository();
        ExamResolutionRepository examResRepo = PersistenceContext.repositories().examResolutionRepository();

        SystemUser systemUser = AuthzRegistry.authorizationService().session().get().authenticatedUser();
        Student student = studentRepo.findStudentBySystemUser(systemUser);

        List<Course> courseList = courseRepo.findStudentInACourses(systemUser);

        Date currDate = new Date();


        List<ExamDTOWithDatesExamTitleCourseId> dtoList = new ArrayList<>();

        for (Course course : courseList){
            List<Exam> courseExamList = course.findAllDoableExams(currDate);
            for (Exam exam : courseExamList){
                if (!examResRepo.containsOfExamAndStudent(exam,student)) {
                    dtoList.add(ExamDTOWithDatesExamTitleCourseIdMapper.toDto(exam,course));
                }
            }
        }


        return dtoList;
    }
}
