package eapli.base.app.other.console.presentation.courseClass;

import eapli.base.courseclasses.application.CreateClassController;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;

public class CreateClassUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        try {
            CreateClassController controller = new CreateClassController();
            ArrayList<CourseDTOWithIdTitle> courseDTOList = controller.listCourse();
            int i = 1;
            if (courseDTOList.isEmpty())throw new IllegalArgumentException("No courses");
            System.out.println("Select the course: (Identifier | Title)");
            for (CourseDTOWithIdTitle course : courseDTOList) {
                System.out.println(i + ". " + course.courseIdentifier + " | " + course.courseTitle);
                i++;
            }
            System.out.println(0 + ". Cancel");
            // Select course
            int option = Console.readOption(1, courseDTOList.size(), 0);
            // Get the selected course
            CourseDTOWithIdTitle selectedCourse = courseDTOList.get(option - 1);

            final String classTitle = Console.readLine("classTitle");
            final int duration = Console.readInteger("Duration (minutes)");
            final int numberOfClasses = Console.readInteger("Number of Occurrences");
            final Date date = Console.readDate("Starting Date (YYYY/MM/DD)");
            final Date time = Console.readDate("Starting Time (HH:MM:SS)", "HH:mm:ss");

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, time.getHours());
            calendar.set(Calendar.MINUTE, time.getMinutes());
            calendar.set(Calendar.SECOND, time.getSeconds());
            Date startingDateWithTime = calendar.getTime();

            System.out.println("\nInserted Information");
            System.out.println("Course: " + selectedCourse.courseTitle + " | " + selectedCourse.courseIdentifier);
            System.out.println("Class Title: " +  classTitle);
            System.out.println("Duration: " +  duration);
            System.out.println("Number of Occurrences: " + numberOfClasses);
            System.out.println("Starting Date (YYYY/MM/DD): " + calendar.get(Calendar.YEAR) +"/"+ (calendar.get(Calendar.MONTH) +1) +"/"+calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("Starting Time (HH:MM:SS): " + calendar.get(Calendar.HOUR_OF_DAY) +":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));

            if(!Console.readBoolean("\nIs the information correct? (y/n)")) return true;


            boolean flag = true;
            if (controller.verifyIfExistAClassAtTheTime(startingDateWithTime, duration, selectedCourse)) {
                flag = Console.readBoolean("\nOne of the participants already has a class at the time, do you want to proceed? (y/n)");
            }

            if (flag) {
                if(controller.createClass(classTitle, startingDateWithTime, numberOfClasses, duration, selectedCourse)) {
                    System.out.println("\nClass was created with success.");
                }else{
                    System.out.println("\nClass creation has failed.");
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public String headline() {
        return "Create Class";
    }
}
