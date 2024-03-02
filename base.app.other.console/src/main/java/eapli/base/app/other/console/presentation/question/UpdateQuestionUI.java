package eapli.base.app.other.console.presentation.question;

import eapli.base.coursemanagement.application.ListCourseController;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.questionmanagement.application.AddQuestionController;
import eapli.base.questionmanagement.application.ListCourseQuestionsController;
import eapli.base.questionmanagement.application.UpdateQuestionController;
import eapli.base.questionmanagement.dto.QuestionDTOWithId;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import org.springframework.format.Printer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class UpdateQuestionUI extends AbstractUI {

    @Override
    protected boolean doShow() {
        UpdateQuestionController updateQuestionController = new UpdateQuestionController();
        ListCourseController listCourseController = new ListCourseController();
        ListCourseQuestionsController listCourseQuestionsController = new ListCourseQuestionsController();
        List<CourseDTOWithIdTitle> courseDTOList = listCourseController.listCourse();
        if(!courseDTOList.isEmpty()) {
            System.out.println("To which course would you like to add the question?");
            int i;
            for (i = 1; i <= courseDTOList.size(); i++) {
                System.out.printf("%d. %s-%s\n", i, courseDTOList.get(i - 1).courseTitle, courseDTOList.get(i - 1).courseIdentifier);
            }
            System.out.println("0. Return");
            int optionInt1 = -1;
            boolean hasEntered1 = false;

            do {
                if (hasEntered1) {
                    System.out.printf("Please insert a number between one and %d\n", i);
                }
                hasEntered1 = true;
                try {
                    Scanner read = new Scanner(System.in);
                    String optionString = read.nextLine();
                    optionInt1 = Integer.parseInt(optionString);
                } catch (NumberFormatException e) {
                    optionInt1 = -1;
                }
            } while (optionInt1 < 0 || optionInt1 > courseDTOList.size());
            List<QuestionDTOWithId> questionDTOList = listCourseQuestionsController.listCourseQuestions(courseDTOList.get(optionInt1-1));
            if(!questionDTOList.isEmpty()){
                SelectWidget<QuestionDTOWithId> selected = new SelectWidget<>("Select a question to update.", questionDTOList, new QuestionDTOWithIdPrinter());
                selected.show();
                QuestionDTOWithId questionDTOWithId = selected.selectedElement();
                Scanner read = new Scanner(System.in);
                boolean wantsToExit = true;
                do {
                    try {
                        wantsToExit = true;
                        System.out.println("Please insert the path to Question file.");
                        String optionString = read.nextLine();
                        Path path = Paths.get(optionString);
                        byte[] fileBytes = Files.readAllBytes(path);
                        updateQuestionController.updateQuestion(questionDTOWithId, new String(fileBytes));
                        System.out.println("Your Question was updated with success!");
                    } catch (IOException e) {
                        System.out.println("The path you have entered isn't correct.");
                        System.out.println("Would you like to continue? (Y/N)");
                        String answer;
                        int hasEntered = 0;
                        do {
                            if (hasEntered > 0) System.out.println("Please insert y or n!");
                            hasEntered++;
                            answer = read.nextLine();
                        } while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N"));
                        if (answer.equalsIgnoreCase("Y")) {
                            wantsToExit = false;
                        }
                    }catch (IllegalArgumentException illegalArgumentException){
                        System.out.println(illegalArgumentException.getMessage());
                    }
                }while(!wantsToExit);
            }else{
                System.out.println("There are no questions to update on that course.");
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "Update Question of a Repository of Questions";
    }
}
