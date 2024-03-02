package eapli.base.app.backoffice.console.presentation.enrollment;

import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitleStatus;
import eapli.base.enrollments.application.EnrollInBulkController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class EnrollInBulkUI extends AbstractUI {

    private final EnrollInBulkController enrollInBulkController = new EnrollInBulkController();

    @Override
    protected boolean doShow() {

        List<CourseDTOWithIdTitle> courseDTOWithIdTitleList = enrollInBulkController.listAllStudentAvailableCourses();

        String fileName = Console.readLine("Insert the csv file name:");
        boolean importResult = enrollInBulkController.importCsvData(fileName);

        if(importResult) {

            System.out.println("Going to import the data...\n");
            System.out.println("Data imported.\n");

            int size = courseDTOWithIdTitleList.size();

            for (int i = 0; i < size; i++) {
                System.out.println(i + 1 + ". " + courseDTOWithIdTitleList.get(i));
            }

            System.out.println("0. Return\n");
            int idx = Console.readOption(1, size, 0);

            if(idx != 0){
                System.out.println("Starting the enroll in bulk process...\n");
                enrollInBulkController.enrollStudentsInBulkToCourse(courseDTOWithIdTitleList.get(idx-1));
                System.out.println("The process is done!\n");
            }

        }

        return true;
    }

    @Override
    public String headline() {
        return "Enroll in Bulk";
    }
}
