package eapli.base.formativeexams.application.services;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.exams.domain.VerifyExamSpecificationService;
import eapli.base.formativeexams.domain.EvaluateResolutionService;
import eapli.base.formativeexams.domain.FormativeExam;
import eapli.base.formativeexams.domain.FormativeExamID;
import eapli.base.formativeexams.domain.VerifyFormativeExamService;
import eapli.base.formativeexams.repositories.FormativeExamRepository;
import eapli.base.grammarutils.FormativeExamResolutionVisitor;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.utils.ResolutionReader;
import eapli.base.utils.SpecificationAndAnswerConcatenator;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TakeFormativeExamService {

    private static FormativeExamRepository formativeExamRepository = PersistenceContext.repositories().formativeExamRepository();

    private static CourseRepository courseRepository = PersistenceContext.repositories().courseRepository();

    public List<String> listFormativeExams(){

        List<String> formativeExamList = new ArrayList<>();

        SystemUser user = AuthzRegistry.authorizationService().session().get().authenticatedUser();
        List<Course> courseList = courseRepository.listAcceptedCoursesByStudent(user);

        List<FormativeExam> formativeExamEntityList;

        for (Course course : courseList) {

            formativeExamEntityList = formativeExamRepository.findFormativeExamsFromCourse(course.identity());

            for (FormativeExam formativeExam : formativeExamEntityList) {

                formativeExamList.add(formativeExam.returnFormativeExamId());

            }

        }

        return formativeExamList;
    }

    public String returnStudentViewOfFormativeExamSpecification(long formativeExamId){

        FormativeExam formativeExam = formativeExamRepository.ofIdentity(new FormativeExamID(formativeExamId)).get();
        String studentView = formativeExam.returnStudentViewOfFormativeExamSpecification();

        return studentView;
    }
    public List<String> takeFormativeExam(long formativeExamId,String resolutionFilePath){

        List<String> gradeAndFeedback = new ArrayList<>();

        FormativeExam formativeExam = formativeExamRepository.ofIdentity(new FormativeExamID(formativeExamId)).get();

            String specification = formativeExam.returnFullFormativeExamSpecificationString();
            Map<Integer, List<String>> answers = ResolutionReader.importAnswers(resolutionFilePath);
            String resolution = SpecificationAndAnswerConcatenator.concatenate(specification, answers);
            VerifyFormativeExamService verifyFormativeExamService = new VerifyFormativeExamService();
            EvaluateResolutionService evaluateResolutionService = new EvaluateResolutionService();

            if(verifyFormativeExamService.verifyFormativeExamSpecification(resolution)){

                FormativeExamResolutionVisitor visitor = evaluateResolutionService.takeFormativeExam(resolution);
                Double grade = visitor.grade();
                List<String> feedback = visitor.feedback();
                gradeAndFeedback.add(grade.toString());
                gradeAndFeedback.addAll(feedback);

            }

        return gradeAndFeedback;
    }
}
