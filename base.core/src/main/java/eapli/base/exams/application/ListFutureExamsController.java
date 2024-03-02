package eapli.base.exams.application;

import eapli.base.exams.application.services.ListFutureExamsService;
import eapli.base.exams.dto.ExamDTOWithDatesCourseId;

import java.util.List;

public class ListFutureExamsController {
    public List<ExamDTOWithDatesCourseId> listFutureExams(){
        ListFutureExamsService service = new ListFutureExamsService();
        return service.listFutureExams();
    }
}
