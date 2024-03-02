package eapli.base.app.other.console.presentation.courseClass;

import eapli.base.courseclasses.application.ScheduleExtraClassController;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ScheduleExtraClassUI extends AbstractUI {

    private final ScheduleExtraClassController controller = new ScheduleExtraClassController();

    @Override
    protected boolean doShow() {
        List<CourseDTOWithIdTitle> courseDTOList= this.controller.listAllTeacherAvailableCourses();
        if (courseDTOList.size() == 0){
            System.out.println("\n[ERROR]");
            System.out.println("You are not assigned to any course at the moment ");
            return false;
        }

        final SelectWidget<CourseDTOWithIdTitle> selector = new SelectWidget<>("Select a course:\n(Course identifier | Course title)",
                courseDTOList , new CourseDTOWithIdTitlePrinter());

        selector.show();
        final CourseDTOWithIdTitle selectedCourse = selector.selectedElement();
        if(selectedCourse != null){
            try {
                final int duration = Console.readInteger("Duration (minutes)");
                final Date date = Console.readDate("Starting Date (YYYY/MM/DD)");
                final Date time = Console.readDate("Starting Time (HH:MM:SS)", "HH:mm:ss");
                final List<String> mecNumList= new ArrayList<>();


                String mecNum = Console.readLine("Please insert the mecanographic number of the students that will be participating in this extra class (insert -1 when finished)");
                if (mecNum.equals("-1")){
                    System.out.println("At least one student must be inserted");
                    return false;
                }
                do {
                    mecNumList.add(mecNum);
                    mecNum = Console.readLine("");
                }while(!mecNum.equals("-1"));
                System.out.print("\n\n");

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.set(Calendar.HOUR_OF_DAY, time.getHours());
                calendar.set(Calendar.MINUTE, time.getMinutes());
                calendar.set(Calendar.SECOND, time.getSeconds());
                Date startingDateWithTime = calendar.getTime();


                printInsertedInfo(duration,startingDateWithTime,selectedCourse.courseIdentifier,mecNumList);
                System.out.print("\n");
                boolean conf = Console.readBoolean("Are you sure you want to create a course with this information?(y/n)");

                if (conf) {
                    try {
                        boolean available = controller.verifyScheduleAvailability(startingDateWithTime,duration,selectedCourse,mecNumList);
                        if(!available){
                            System.out.print("\n");
                            if(Console.readBoolean("One of the participants already has a class/extra class at this time, do you still want to schedule this extra class? (y/n)")){
                                controller.createExtraClass(startingDateWithTime,duration,selectedCourse,mecNumList);
                                System.out.println("\nExtra class was successfully scheduled\n");
                            }
                        }else{
                            controller.createExtraClass(startingDateWithTime,duration,selectedCourse,mecNumList);
                            System.out.println("\nExtra class was successfully scheduled\n");
                        }
                    } catch (Exception e) {
                        System.out.println("\n[ERROR]");
                        System.out.println(e.getMessage());
                    }
                }
            } catch (Exception e) {
                System.out.println("\n[ERROR]");
                System.out.println(e.getMessage());
            }


        }
        return true;
    }

    private void printInsertedInfo(int duration, Date startingDateWithTime, String courseIdentifier, List<String> mecNumList) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startingDateWithTime);
        System.out.println("Inserted information:");
        System.out.printf("Course identifier: %s\n", courseIdentifier);
        System.out.printf("Duration: %d\n", duration);
        System.out.println("Starting Date (YYYY/MM/DD): " + calendar.get(Calendar.YEAR) +"/"+ (calendar.get(Calendar.MONTH) +1) +"/"+calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Starting Time (HH:MM:SS): " + calendar.get(Calendar.HOUR_OF_DAY) +":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
        System.out.println("Student mecanographic number list:");
        for(String s: mecNumList){
            System.out.println(s);
        }
    }

    @Override
    public String headline() {
        return "Schedule extra class";
    }
}
