package eapli.base.app.other.console.presentation.exam;

import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.exams.application.CreateExamController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CreateExamUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        try {
            CreateExamController controller = new CreateExamController();
            ArrayList<CourseDTOWithIdTitle> listCourseDto = controller.listCourse();
            int i = 1;
            if (listCourseDto.isEmpty())throw new IllegalArgumentException("No courses");
            System.out.println("Select the course: (Identifier | Title)");
            for (CourseDTOWithIdTitle course : listCourseDto) {
                System.out.println(i + ". " + course.courseIdentifier + " | " + course.courseTitle);
                i++;
            }
            System.out.println(0 + ". Cancel");
            int option = Console.readOption(1, listCourseDto.size(), 0);
            if (option == 0) return true;
            CourseDTOWithIdTitle selectedCourse = listCourseDto.get(option - 1);

            Date initialDate = Console.readDate("Initial Date (YYYY/MM/DD)");
            final Date initialTime = Console.readDate("Starting Time (HH:MM)", "HH:mm");
            Date finalDate = Console.readDate("Final Date (YYYY/MM/DD)");
            final Date finalTime = Console.readDate("Final Time (HH:MM)", "HH:mm");
            String path = Console.readLine("Exam file path");

            byte[] fileBytes = Files.readAllBytes(Path.of(path));
            String structure = new String(fileBytes);

            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(initialDate);
            calendar1.set(Calendar.HOUR_OF_DAY, initialTime.getHours());
            calendar1.set(Calendar.MINUTE, initialTime.getMinutes());

            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(finalDate);
            calendar2.set(Calendar.HOUR_OF_DAY, finalTime.getHours());
            calendar2.set(Calendar.MINUTE, finalTime.getMinutes());



            System.out.println("\nInserted Information");
            System.out.println("Course: " + selectedCourse.courseTitle + " | " + selectedCourse.courseIdentifier);
            System.out.println("Initial Date (YYYY/MM/DD): " + calendar1.get(Calendar.YEAR) +"/"+ (calendar1.get(Calendar.MONTH) +1) +"/"+calendar1.get(Calendar.DAY_OF_MONTH));
            System.out.println("Initial Time (HH:MM:SS): " + calendar1.get(Calendar.HOUR_OF_DAY) +":"+calendar1.get(Calendar.MINUTE));
            System.out.println("Final Date (YYYY/MM/DD): " + calendar2.get(Calendar.YEAR) +"/"+ (calendar2.get(Calendar.MONTH) +1) +"/"+calendar2.get(Calendar.DAY_OF_MONTH));
            System.out.println("Final Time (HH:MM): " + calendar2.get(Calendar.HOUR_OF_DAY) +":"+calendar2.get(Calendar.MINUTE));
            if(!Console.readBoolean("\nIs the information correct? (y/n)")) return true;
            if(controller.createExam(structure,selectedCourse,calendar1.getTime(),calendar2.getTime())) System.out.println("Exam created with success");
        }catch (IOException e){
            System.out.println("File not found");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public String headline() {
        return "Create Exam";
    }
}
