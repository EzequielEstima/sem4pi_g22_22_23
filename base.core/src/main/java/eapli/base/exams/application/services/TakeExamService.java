package eapli.base.exams.application.services;

import eapli.base.exams.domain.*;
import eapli.base.exams.repositories.ExamRepository;
import eapli.base.exams.repositories.ExamResolutionRepository;
import eapli.base.exceptions.InvalidIdException;
import eapli.base.exceptions.NegativeParameterException;
import eapli.base.exceptions.ParameterNullBlankException;
import eapli.base.grammarutils.ExamResolutionVisitor;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.repositories.StudentRepository;
import eapli.base.utils.ResolutionReader;
import eapli.base.utils.SpecificationAndAnswerConcatenator;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TakeExamService {
    public List<String> takeExam(String examId, String filePath) throws NegativeParameterException, InvalidIdException, ParameterNullBlankException {
        ExamRepository examRepo = PersistenceContext.repositories().examRepository();
        ExamResolutionRepository examResRepo = PersistenceContext.repositories().examResolutionRepository();
        StudentRepository studentRepo = PersistenceContext.repositories().studentRepository();

        SystemUser systemUser = AuthzRegistry.authorizationService().session().get().authenticatedUser();
        Student student = studentRepo.findStudentBySystemUser(systemUser);

        Exam exam = examRepo.ofIdentity(new ExamTitle(examId)).get();
        String fullSpecification = exam.returnFullExamSpecificationString();

        Map<Integer, List<String>> answers = ResolutionReader.importAnswers(filePath);

        String specificationWithResolution = SpecificationAndAnswerConcatenator.concatenate(fullSpecification,answers);

        VerifyExamSpecificationService verifyService = new VerifyExamSpecificationService();
        EvaluateExamResolutionService evaluateService = new EvaluateExamResolutionService();

        List<String> gradeAndFeedback = new ArrayList<>();
        if(verifyService.verifyExamSpecification(specificationWithResolution)){

            ExamResolutionVisitor visitor = evaluateService.takeExam(specificationWithResolution);
            Double grade = visitor.grade();

            gradeAndFeedback.add(grade.toString());
            List<String> feedback = visitor.feedback();
            gradeAndFeedback.addAll(feedback);


            Long id = examResRepo.findMaxId();
            ExamResolution newExamResolution = new ExamResolution(id+1,grade,student,exam);
            examResRepo.save(newExamResolution);

            student.addExamResolution(newExamResolution);
            studentRepo.save(student);

            exam.addExamResolution(newExamResolution);
            examRepo.save(exam);
        }

        return gradeAndFeedback;
    }
}
