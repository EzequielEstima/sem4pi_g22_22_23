package eapli.base.questionmanagement.application;

import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.questionmanagement.application.services.ListQuestionsService;
import eapli.base.questionmanagement.dto.QuestionDTOWithId;

import java.util.List;

public class ListCourseQuestionsController {
    public List<QuestionDTOWithId> listCourseQuestions(CourseDTOWithIdTitle courseDTO){
        ListQuestionsService listQuestionsService = new ListQuestionsService();
        return listQuestionsService.listCourseQuestions(courseDTO);
    }
}
