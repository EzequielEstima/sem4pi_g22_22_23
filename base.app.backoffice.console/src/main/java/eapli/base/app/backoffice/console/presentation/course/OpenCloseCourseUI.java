package eapli.base.app.backoffice.console.presentation.course;

import eapli.base.coursemanagement.application.OpenCloseCourseController;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitleStatus;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;
import java.util.Scanner;

public class OpenCloseCourseUI extends AbstractUI {

    protected boolean doShow(){
        OpenCloseCourseController controller = new OpenCloseCourseController();
        List<CourseDTOWithIdTitleStatus> courseDTOList = controller.listOpenableClosableCourses();
        if(!courseDTOList.isEmpty()) {
            System.out.println("Which course would you like to be opened/closed?");
            int i;
            for (i = 1; i <= courseDTOList.size(); i++) {
                System.out.printf("%d. %s-%s (Current Status : %s)\n", i, courseDTOList.get(i - 1).courseTitle, courseDTOList.get(i - 1).courseIdentifier, courseDTOList.get(i - 1).courseState);
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
            if (optionInt1 != 0) {
                System.out.println("Would you like to open or close it?");
                System.out.println("1. Open");
                System.out.println("2. Close");
                System.out.println("0. Return");

                int optionInt2 = -1;
                boolean hasEntered2 = false;
                do {
                    if (hasEntered2) {
                        System.out.println("Please insert 1 or 2");
                    }
                    hasEntered2 = true;
                    try {
                        Scanner read = new Scanner(System.in);
                        String optionString = read.nextLine();
                        optionInt2 = Integer.parseInt(optionString);
                    } catch (NumberFormatException e) {
                        optionInt2 = -1;
                    }
                } while (optionInt2 < 0 || optionInt2 > 2);
                System.out.println(optionInt2);
                if (optionInt1 != 2) {
                    String newStatus = "";
                    switch (optionInt2) {
                        case (1):
                            newStatus = "OPEN";
                            break;
                        case (2):
                            newStatus = "CLOSED";
                            break;
                    }
                    System.out.printf("Are you sure you want to change the state of course %s-%s to %s? (y/n)\n", courseDTOList.get(optionInt1 - 1).courseTitle, courseDTOList.get(optionInt1 - 1).courseIdentifier, newStatus);
                    boolean hasEntered3 = false;
                    String optionString;
                    do {
                        if (hasEntered3) {
                            System.out.println("Please insert y/n");
                        }
                        hasEntered3 = true;
                        try {
                            Scanner read = new Scanner(System.in);
                            optionString = read.nextLine();
                        } catch (NumberFormatException e) {
                            optionString = "";
                        }
                    } while (!optionString.equals("Y") && !optionString.equals("N") && !optionString.equals("y") && !optionString.equals("n"));
                    if (optionString.equals("y") || optionString.equals("Y")) {
                        try {
                            controller.changeCourseStatus(courseDTOList.get(optionInt1 - 1), newStatus);
                            System.out.println("The operation has succeeded!");
                        } catch (IllegalArgumentException e) {
                            if (optionInt2 == 1) {
                                System.out.println("The operation could not be completed because this class cannot be opened.");
                            } else {
                                System.out.println("The operation could not be completed because this class cannot be closed.");
                            }
                        }
                    } else {
                        System.out.println("The operation was aborted!");
                    }
                }
            }
        }else{
            System.out.printf("There are no courses that can be opened or closed!\n\n");
        }
        return true;
    }

    @Override
    public String headline() {
        return "Open/Close Course";
    }
}