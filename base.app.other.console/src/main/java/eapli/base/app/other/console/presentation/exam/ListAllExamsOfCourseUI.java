package eapli.base.app.other.console.presentation.exam;

import eapli.base.coursemanagement.application.ListAllExamsOfCourseController;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.exams.dto.ExamDTOWithExamTitleDateInterval;
import eapli.base.formativeexams.dto.FormativeExamDTOWithId;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

public class ListAllExamsOfCourseUI extends AbstractUI {

    ListAllExamsOfCourseController listAllExamsOfCourseController = new ListAllExamsOfCourseController();
    @Override
    protected boolean doShow() {
        List<CourseDTOWithIdTitle> courseDTOWithIdList = new ArrayList<>();

        try {
            courseDTOWithIdList = listAllExamsOfCourseController.listAllCourses();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        int size = courseDTOWithIdList.size();

        for (int i = 0; i < size; i++) {
            System.out.println(i + 1 + ". " + courseDTOWithIdList.get(i));
        }

        System.out.println("0. Return\n");
        int idx = Console.readOption(1, size, 0);

        if (idx != 0){
            
            try {
                List<ExamDTOWithExamTitleDateInterval> examDTOWithExamIdDateIntervalList = listAllExamsOfCourseController.listAllExamsFromCourse(courseDTOWithIdList.get(idx - 1));
                System.out.println("----------------Exams List---------------");
                for (ExamDTOWithExamTitleDateInterval examDTOWithExamIdDateInterval : examDTOWithExamIdDateIntervalList) {
                    System.out.println(examDTOWithExamIdDateInterval);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

            try{
                List<FormativeExamDTOWithId> formativeExamDTOWithIdList = listAllExamsOfCourseController.listFormativeExamsFromCourse(courseDTOWithIdList.get(idx - 1));
                System.out.println("---------Formative Exams List------------");
                for (FormativeExamDTOWithId formativeExamDTOWithId : formativeExamDTOWithIdList) {
                    System.out.println(formativeExamDTOWithId);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }

        return true;
    }

    @Override
    public String headline() {
        return "List All Exams Of Course";
    }
}
