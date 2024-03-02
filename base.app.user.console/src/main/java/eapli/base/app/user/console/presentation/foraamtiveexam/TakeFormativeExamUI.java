package eapli.base.app.user.console.presentation.foraamtiveexam;

import eapli.base.formativeexams.application.controllers.TakeFormativeExamController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TakeFormativeExamUI extends AbstractUI {

    private static TakeFormativeExamController takeFormativeExamController = new TakeFormativeExamController();
    @Override
    protected boolean doShow() {

        List<String> formativeExamList = takeFormativeExamController.listFormativeExams();

        if(!formativeExamList.isEmpty()){

            int size = formativeExamList.size();

            for (int i = 0; i < size; i++) {
                System.out.println(i + 1 + ". " + formativeExamList.get(i));
            }

            System.out.println("0. Return\n");
            int idx = Console.readOption(1, size, 0);

            if(idx!=0) {

                String idString = formativeExamList.get(idx-1);
                Character id = formativeExamList.get(idx-1).charAt(idString.length()-1);

                System.out.println("\nFormative Exam specification:\n");
                String formativeExamSpecification = takeFormativeExamController.returnStudentViewOfFormativeExamSpecification(Long.parseLong(id.toString()));
                System.out.println(formativeExamSpecification);

                System.out.println("The answers file should have a answer per line and in case of a multiple answer separate each of de answers in the same line by a comma.");

                String filePath = "";
                boolean flag = false;

                while (!flag) {
                        filePath = Console.readLine("Insert the answers file path:");
                        Path path = Paths.get(filePath);
                        if (Files.exists(path)) {
                            flag = true;
                        } else {
                            System.out.println("The path your inserted isn't valid!");
                        }
                }

                List<String> gradeAndFeedback = new ArrayList<>();

                try{
                    gradeAndFeedback = takeFormativeExamController.takeFormativeExam(Long.parseLong(id.toString()), filePath);



                System.out.println("\nHere are your grande and feedback:\n");
                for (String info : gradeAndFeedback) {

                    System.out.println(info);

                }

                }catch (Exception e){
                    System.out.println("Something went wrong in the formative exam processing!");
                }

            }

        }else{

            System.out.println("There are no formative exams available!");

        }

        return true;
    }

    @Override
    public String headline() {
        return "Take Formative Exam";
    }
}
