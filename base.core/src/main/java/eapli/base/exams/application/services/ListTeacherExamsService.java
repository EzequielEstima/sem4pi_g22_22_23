package eapli.base.exams.application.services;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.exams.domain.Exam;
import eapli.base.exams.dto.ExamDTOWithDatesExamTitleCourseId;
import eapli.base.exams.dto.ExamDTOWithDatesExamTitleCourseIdMapper;
import eapli.base.exams.repositories.ExamRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Teacher;
import eapli.base.usermanagement.repositories.TeacherRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;

public class ListTeacherExamsService {

    private TeacherRepository teacherRepository = PersistenceContext.repositories().teacherRepository();
    private ExamRepository examRepository = PersistenceContext.repositories().examRepository();

    private CourseRepository courseRepository = PersistenceContext.repositories().courseRepository();


    public List<ExamDTOWithDatesExamTitleCourseId> listTeacherExam(){

        AuthorizationService authz = AuthzRegistry.authorizationService();
        SystemUser systemUser = authz.session().get().authenticatedUser();
        Teacher teacher = teacherRepository.findTeacherBySystemUser(systemUser);
        List<Exam> listExam = examRepository.findTeacherExams(teacher);
        List<ExamDTOWithDatesExamTitleCourseId> listExamDTOWithDatesExamTitleCourseId = new ArrayList<>();
        for (Exam exam: listExam) {
            Course course = courseRepository.findCourseByExam(exam);
            listExamDTOWithDatesExamTitleCourseId.add(ExamDTOWithDatesExamTitleCourseIdMapper.toDto(exam,course));
        }
        return listExamDTOWithDatesExamTitleCourseId;
    }
}
