package eapli.base.app.user.console.presentation.exams;

import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.exams.application.ListStudentAvailableExamsController;
import eapli.base.exams.application.ShowStudentExamViewController;
import eapli.base.exams.application.TakeExamController;
import eapli.base.exams.dto.ExamDTOWithDatesExamTitleCourseId;
import eapli.base.exceptions.InvalidIdException;
import eapli.base.exceptions.NegativeParameterException;
import eapli.base.exceptions.ParameterNullBlankException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.List;

public class TakeExamUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        ListStudentAvailableExamsController listController = new ListStudentAvailableExamsController();
        List<ExamDTOWithDatesExamTitleCourseId> examDTOList = listController.listStudentAvailableExams();
        if (examDTOList.size() == 0){
            System.out.println("\n[ERROR]");
            System.out.println("Currently, there are no exams for you to take");
            return false;
        }

        final SelectWidget<ExamDTOWithDatesExamTitleCourseId> selector = new SelectWidget<>("Select an exam for you to take:\n(Course identifier | Exam title | Initial date | Final date)",
                examDTOList , new ExamDTOWithDatesExamTitleCourseIdPrinter());
        selector.show();

        ExamDTOWithDatesExamTitleCourseId selectedExam = selector.selectedElement();
        if (selectedExam != null){
            boolean flag;
            System.out.println(SEPARATOR);
            System.out.println();
            System.out.println(new ShowStudentExamViewController().showStudentExamView(selectedExam.examTitle));
            System.out.println();
            System.out.println(SEPARATOR);
            System.out.println();
            System.out.println("Here is the exam specification.\n\n");
            System.out.println("To submit your answer please create a .txt file with the following rules:");
            System.out.println("- Multiple answers to the same question should be separated by commas");
            System.out.println("- Multiple answers to different questions should be separated by newline");
            System.out.println("- Answer order must follow the question order");
            System.out.println("\nHere is an example of what it should look like:");
            System.out.println("Q1answer1,Q1answer2");
            System.out.println("Q2answer1");
            System.out.println("Q3answer1,Q3answer2,Q3answer3");

            do {
                try {
                    String filePath = Console.readLine("\n\nPlease insert the path to the resolution file");
                    List<String> gradeAndFeedback = new TakeExamController().takeExam(selectedExam.examTitle, filePath);
                    System.out.println("\nHere is your grade and the feedback to each question:");
                    for (String str : gradeAndFeedback) {
                        System.out.println(str);
                    }
                    flag = false;
                } catch (Exception e) {
                    flag = true;
                    System.out.println(e.getMessage());
                }
            } while (flag);
        }


        return false;
    }

    @Override
    public String headline() {
        return "Take exam";
    }
}
