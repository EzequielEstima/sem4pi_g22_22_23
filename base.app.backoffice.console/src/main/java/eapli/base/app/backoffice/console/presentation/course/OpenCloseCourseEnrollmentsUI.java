package eapli.base.app.backoffice.console.presentation.course;

import eapli.base.coursemanagement.application.OpenCloseCourseEnrollmentsController;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitleStatus;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import java.util.List;

public class OpenCloseCourseEnrollmentsUI extends AbstractUI {

    private final OpenCloseCourseEnrollmentsController openCloseCourseEnrollmentsController = new OpenCloseCourseEnrollmentsController();
    @Override
    protected boolean doShow() {

        List<CourseDTOWithIdTitleStatus> courseDTOWithIdTitleStatusList = openCloseCourseEnrollmentsController.listAllOpenCloseEnrollmentsAvailableCourses();

        if(!courseDTOWithIdTitleStatusList.isEmpty()){

            int changeOption = 0;

            while(changeOption == 0) {

                changeOption = -1;
                int size = courseDTOWithIdTitleStatusList.size();

                for (int i = 0; i < size; i++) {
                    System.out.println(i + 1 + ". " + courseDTOWithIdTitleStatusList.get(i));
                }

                System.out.println("0. Return\n");
                int idx = Console.readOption(1, size, 0);

                if (idx != 0) {

                    System.out.println("\n1. Open Enrollments\n2. Close Enrollments\n0. Return\n");
                    changeOption = Console.readOption(1, 2, 0);

                    try {
                        if (changeOption == 1) {
                            openCloseCourseEnrollmentsController.changeStatus(courseDTOWithIdTitleStatusList.get(idx - 1), "OPEN_ENROLLMENTS");
                        } else if (changeOption == 2) {
                            openCloseCourseEnrollmentsController.changeStatus(courseDTOWithIdTitleStatusList.get(idx - 1), "CLOSED_ENROLLMENTS");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
            }
        }else{
            System.out.println("There are no courses available for open/close enrollments currently!");
        }

        return true;
    }

    @Override
    public String headline() {
        return "Open/Close Course Enrollments";
    }
}
