package eapli.base.exams.application.services;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.exams.domain.Exam;
import eapli.base.exams.dto.ExamDTOWithDatesCourseId;
import eapli.base.exams.dto.ExamDTOWithDatesCourseIdMapper;
import eapli.base.exams.repositories.ExamRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListFutureExamsService {

    public List<ExamDTOWithDatesCourseId> listFutureExams(){
        CourseRepository courseRepository = PersistenceContext.repositories().courseRepository();
        ExamRepository examRepository = PersistenceContext.repositories().examRepository();
        SystemUser user = AuthzRegistry.authorizationService().session().get().authenticatedUser();
        List<Course> courseList = courseRepository.listAcceptedCoursesByStudent(user);
        Date date = new Date();
        List<Exam> examList;
        List<ExamDTOWithDatesCourseId> examDTOList = new ArrayList<>();
        for(Course course : courseList){
            examList = examRepository.listFutureExamsByCourse(course,date);
            for(Exam exam : examList){
                examDTOList.add(ExamDTOWithDatesCourseIdMapper.toDTO(exam, course));
            }
        }
        return examDTOList;
    }
}
