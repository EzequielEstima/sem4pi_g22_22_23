package eapli.base.questionmanagement.application.services;

import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionmanagement.domain.Question;
import eapli.base.questionmanagement.dto.QuestionDTOWithId;
import eapli.base.questionmanagement.dto.QuestionDTOWithIdMapper;
import eapli.base.questionmanagement.repositories.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

public class ListQuestionsService {
    private final QuestionRepository questionRepository = PersistenceContext.repositories().questionRepository();
    public List<QuestionDTOWithId> listCourseQuestions(CourseDTOWithIdTitle courseDTO){
        List<Question> questionList =  questionRepository.listQuestionsByCourseId(courseDTO.courseIdentifier);
        List<QuestionDTOWithId> questionDTOList = new ArrayList<>();
        for(Question question : questionList){
            questionDTOList.add(QuestionDTOWithIdMapper.toDTO(question));
        }
        return questionDTOList;
    }
}
