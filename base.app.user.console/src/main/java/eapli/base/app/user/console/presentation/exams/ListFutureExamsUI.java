package eapli.base.app.user.console.presentation.exams;

import eapli.base.exams.application.ListFutureExamsController;
import eapli.base.exams.dto.ExamDTOWithDatesCourseId;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ListFutureExamsUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        ListFutureExamsController controller = new ListFutureExamsController();
        List<ExamDTOWithDatesCourseId> examDTOList = controller.listFutureExams();
        if(!examDTOList.isEmpty()) {
            System.out.println("Here's a list of your future exams : ");
            for (ExamDTOWithDatesCourseId examDTO : examDTOList) {
                System.out.printf("\nCourse : %s, Starting at : %s and Ending at : %s\n\n", examDTO.courseId, examDTO.initialDate, examDTO.finalDate);
            }
        }else{
            System.out.println("There are no future exams.");
        }
        return true;
    }

    @Override
    public String headline() {
        return "List Future Exams";
    }
}
