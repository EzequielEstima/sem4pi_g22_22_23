package eapli.base.questionmanagement.application.services;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionmanagement.domain.*;
import eapli.base.questionmanagement.dto.QuestionDTOWithId;
import eapli.base.questionmanagement.repositories.QuestionRepository;

public class AddUpdateQuestionService {
    private final QuestionRepository questionRepository = PersistenceContext.repositories().questionRepository();
    private final CourseRepository courseRepository = PersistenceContext.repositories().courseRepository();

    public void addQuestion(CourseDTOWithIdTitle courseDTO, String structure){
        long maxId = questionRepository.findMaxId();
        QuestionBuilder builder = new QuestionBuilder();
        Question question = builder.withStructure(structure).withIdentifier(maxId + 1).build();
        Course course = courseRepository.findCourseById(courseDTO.courseIdentifier);
        course.addQuestion(question);
        questionRepository.save(question);
        courseRepository.save(course);
    }

    public void updateQuestion(QuestionDTOWithId questionDTO, String updatedQuestion){
        VerifyQuestionService verifyQuestionService = new VerifyQuestionService();
        Question question = questionRepository.ofIdentity(new QuestionIdentifier(questionDTO.questionIdentifier)).get();
        verifyQuestionService.verifyQuestion(updatedQuestion);
        question.changeQuestion(new Structure(updatedQuestion));
        questionRepository.save(question);
    }
}
