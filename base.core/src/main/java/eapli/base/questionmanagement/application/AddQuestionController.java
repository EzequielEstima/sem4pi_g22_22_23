package eapli.base.questionmanagement.application;

import eapli.base.coursemanagement.application.ListCourseController;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.questionmanagement.application.services.AddUpdateQuestionService;

import java.util.List;

public class AddQuestionController {
    public void addQuestion(CourseDTOWithIdTitle courseDTO, String questionStructure){
        AddUpdateQuestionService service = new AddUpdateQuestionService();
        service.addQuestion(courseDTO, questionStructure);
    }
}
