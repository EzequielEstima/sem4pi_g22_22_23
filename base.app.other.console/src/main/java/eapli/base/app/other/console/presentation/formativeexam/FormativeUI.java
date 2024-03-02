package eapli.base.app.other.console.presentation.formativeexam;

import eapli.base.coursemanagement.application.ListCourseController;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.formativeexams.application.controllers.FormativeController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class FormativeUI extends AbstractUI {

    private final FormativeController formativeController = new FormativeController();
private final ListCourseController listCourseController = new ListCourseController();

    @Override
    protected boolean doShow() {

        try {
            List<CourseDTOWithIdTitle> courseDTOWithIdTitleList = listCourseController.listCourse();
            int i=0;
            System.out.println("Choose one of the following courses: ");
            for (CourseDTOWithIdTitle courseDTOWithIdTitle :courseDTOWithIdTitleList) {
                i++;
                System.out.println(i+". Tittle: "+courseDTOWithIdTitle.courseTitle);
            }
            int option = Console.readOption(1,courseDTOWithIdTitleList.size(),0);
            CourseDTOWithIdTitle course = courseDTOWithIdTitleList.get(option-1);
            String type = Console.readLine("Insert the type of questions of the formative exam:");
            int number = Console.readInteger("Insert the number of questions of the formative exam:");
            try {
                formativeController.createFormativeExam(type, number,course);
                System.out.println("Formative exam created successfully!");
                return true;
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Create a formative exam";
    }
}
