package eapli.base.app.other.console.presentation.question;

import eapli.base.coursemanagement.application.ListCourseController;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.questionmanagement.application.AddQuestionController;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class AddQuestionUI extends AbstractUI {
    public boolean doShow() {
        AddQuestionController addQuestionController = new AddQuestionController();
        ListCourseController listCourseController = new ListCourseController();
        List<CourseDTOWithIdTitle> courseDTOList = listCourseController.listCourse();
        if(!courseDTOList.isEmpty()){
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
            if(optionInt1 != 0){
                Scanner read = new Scanner(System.in);
                boolean wantsToExit = true;
                do {
                    try {
                        wantsToExit = true;
                        System.out.println("Please insert the path to Question file.");
                        String optionString = read.nextLine();
                        Path path = Paths.get(optionString);
                        byte[] fileBytes = Files.readAllBytes(path);
                        addQuestionController.addQuestion(courseDTOList.get(optionInt1 - 1), new String(fileBytes));
                        System.out.println("Your Question was created with success!");
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
            }
        }else{
            System.out.println("You cannot add a question because you're not assigned to any course!");
        }
        return true;
    }

    @Override
    public String headline() {
        return "Add Question to Repository of Questions";
    }
}
