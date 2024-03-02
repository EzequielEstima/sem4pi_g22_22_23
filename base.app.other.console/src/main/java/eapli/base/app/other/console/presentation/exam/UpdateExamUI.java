package eapli.base.app.other.console.presentation.exam;


import eapli.base.exams.application.UpdateExamController;
import eapli.base.exams.dto.ExamDTOWithDatesExamTitleCourseId;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

public class UpdateExamUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        try {
            UpdateExamController controller = new UpdateExamController();
            List<ExamDTOWithDatesExamTitleCourseId> listExamsDto = controller.listTeacherExams();
            int i = 1;
            if (listExamsDto.isEmpty())throw new IllegalArgumentException("No exams");
            System.out.println("Select the Exam: (Exam Title | Initial Date | Final Date | Course Identifier)");
            for (ExamDTOWithDatesExamTitleCourseId exam : listExamsDto) {

                System.out.println(i + ". " + exam.examTitle + " | " + exam.initialDate + " | " + exam.finalDate + " | " + exam.courseId);
                i++;
            }
            System.out.println(0 + ". Cancel");
            int option = Console.readOption(1, listExamsDto.size(), 0);
            if (option == 0) return true;
            ExamDTOWithDatesExamTitleCourseId selectedExam = listExamsDto.get(option - 1);
            System.out.println("What do you wish to update:");
            System.out.println("1 - Exam Specification");
            System.out.println("2 - Date Interval");
            System.out.println("0 - Cancel");
            option = Console.readOption(1, 2, 0);
            String structure = null;
            Date initialDate = null;
            Date finalDate = null;
            if (option == 0){
                return true;
            }else if (option == 1){
                String path = Console.readLine("Exam file path");
                byte[] fileBytes = Files.readAllBytes(Path.of(path));
                structure = new String(fileBytes);
            }else if (option == 2){
                initialDate = Console.readDate("Initial Date (YYYY/MM/DD)");
                finalDate = Console.readDate("Final Date (YYYY/MM/DD)");
            }

            if(controller.updateExam(structure,initialDate,finalDate,selectedExam))System.out.println("Exam updated with success");
        }catch (IOException e){
            System.out.println("File not found");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public String headline() {
        return "Update Exam";
    }
}
