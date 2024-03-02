package eapli.base.app.backoffice.console.presentation.course;

import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.coursemanagement.application.AddTeacherInACourseController;
import eapli.base.coursemanagement.application.AddTeacherInChargeInACourseController;
import eapli.base.coursemanagement.application.RequestInformationToSetTeachersController;
import eapli.base.usermanagement.dto.TeacherDTOWithAcronym;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SetTeacherUI extends AbstractUI  {
    private final RequestInformationToSetTeachersController requestInformationToSetTeachersController = new RequestInformationToSetTeachersController();
    private final AddTeacherInACourseController addTeacherInACourseController = new AddTeacherInACourseController();
    private final AddTeacherInChargeInACourseController addTeacherInChargeInACourseController = new AddTeacherInChargeInACourseController();

    @Override
    protected boolean doShow() {

        // Declaration of variables to get the information from the system
        Pair<List<TeacherDTOWithAcronym>,List<CourseDTOWithIdTitle>> pair =
                requestInformationToSetTeachersController.requestInformation();
        List<TeacherDTOWithAcronym> teachers = pair.getFirst();
        List<CourseDTOWithIdTitle> courses = pair.getSecond();

        int option = 0;
        int i = 0;
        // Show courses
        System.out.println("Select one of the following courses:");
        for (CourseDTOWithIdTitle course : courses) {
            i++;
            System.out.println(i+". CourseID:"+course.courseIdentifier+" - Tittle:"+course.courseTitle);
        }
        System.out.println(i+1+". Cancel");

        // Select course
        option = Console.readOption(1,courses.size(),courses.size()+1);
        if (option==courses.size()+1){
            return false;
        }
        // Get the selected course
        CourseDTOWithIdTitle selectedCourse = courses.get(option-1);

        boolean opT = Console.readBoolean("You want to set all teachers of the course (Y/N)");
        boolean opTC = Console.readBoolean("You want to set the teacher in charge (Y/N)");


        if (opT) {
            i = 0;
            // Show teachers
            System.out.println("Select from the following teachers:");
            for (TeacherDTOWithAcronym teacher : teachers) {
                i++;
                   System.out.println(i+". Acronym: "+teacher.acronym);
            }
            System.out.println(i+1+". Cancel");

            // Select teachers
            option=0;
            HashSet<Integer> options = new HashSet<>();
            while (option!=teachers.size()+1) {
                System.out.println("Select an option (if you want to exit please select the cancel option):");
                option = Console.readOption(1,teachers.size(),teachers.size()+1);
                if (option!=teachers.size()+1) {
                    options.add(option);
                }
            }
            i=0;

            // Get the selected teachers
            List<TeacherDTOWithAcronym> selectedTeachers = new ArrayList<>();
            if (!options.isEmpty()) {
                for (Integer integer : options) {
                    selectedTeachers.add(teachers.get(integer-1));
                }
            }
            else {
                return false;
            }


            // Set the teacher in charge
            if (addTeacherInACourseController.addTeacherInACourse(selectedTeachers, selectedCourse)) {
                System.out.println("Teachers added successfully");
            } else {
                System.out.println("Error adding teachers");
                return false;
            }
        }


        if (opTC) {
            i = 0;
            // Show teachers
            System.out.println("Select the teacher in charge: ");
            for (TeacherDTOWithAcronym teacher : teachers) {
                i++;
                System.out.println(i+". Acronym: "+teacher.acronym);
            }

            option = Console.readInteger("Select an option:");
            if (option>teachers.size()||option<1){
                do {
                    option = Console.readInteger("Please select a valid option from the list of teachers");
                }while (option>teachers.size()||option<1);
            }

            // Get the teacher in charge
            TeacherDTOWithAcronym teacherInCharge = teachers.get(option-1);

            // Set the teachers
            if(addTeacherInChargeInACourseController.addTeacherInCharge(teacherInCharge, selectedCourse)) {
                System.out.println("Teacher in charge added successfully");
            } else {
                System.out.println("Error adding teacher in charge");
                return false;
            }
        }

        return true;
    }

    @Override
    public String headline() {
        return "Set Teachers";
    }

}
