package eapli.base.app.backoffice.console.presentation.enrollment;

import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.enrollments.application.ApproveRejectEnrollmentController;
import eapli.base.usermanagement.dto.StudentDTOWithMechNumber;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;
import java.util.Scanner;

public class ApproveRejectEnrollmentUI extends AbstractUI {
    protected boolean doShow(){
        ApproveRejectEnrollmentController controller = new ApproveRejectEnrollmentController();
        List<CourseDTOWithIdTitle> courseDTOList = controller.listCoursesWithEnrollments();
        if(!courseDTOList.isEmpty()){
            System.out.println("For which course would you like to approve/reject enrollments?");
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
                String newStatus = "REJECTED";
                boolean canOnlyReject = false;
                boolean wantToContinue = true;
                try{
                    controller.verifyIfWillExceedEnrollmentLimits(courseDTOList.get(optionInt1-1));
                }catch (IllegalStateException e){
                    canOnlyReject = true;
                    System.out.println("The course that you have chosen doesn't have any enrollment!");
                    System.out.println("Do you want to continue?(y/n)");
                    String optionString;
                    boolean hasEntered3 = false;
                    Scanner read = new Scanner(System.in);
                    do{
                        if(hasEntered3) System.out.println("Please insert y or n.");
                        hasEntered3 = true;
                        optionString = read.nextLine();
                    }while(!optionString.equals("Y") && !optionString.equals("N") && !optionString.equals("y") && !optionString.equals("n"));
                    if(optionString.equalsIgnoreCase("N")){
                        wantToContinue = false;
                    }
                }
                if(wantToContinue){
                    List<StudentDTOWithMechNumber> studentDTOList = controller.listStudentsPendingInCourse(courseDTOList.get(optionInt1 - 1));
                    System.out.println("Please choose the student that you want to change the enrollment state.");
                    for (i = 1; i <= studentDTOList.size(); i++) {
                        System.out.printf("%d. %s\n", i, studentDTOList.get(i - 1).mechanographicNumber);
                    }
                    System.out.println("0. Return");
                    int optionInt2 = -1;
                    boolean hasEntered2 = false;
                    do {
                        if (hasEntered2) {
                            System.out.printf("Please insert a number between one and %d\n", i);
                        }
                        hasEntered2 = true;
                        try {
                            Scanner read = new Scanner(System.in);
                            String optionString = read.nextLine();
                            optionInt2 = Integer.parseInt(optionString);
                        } catch (NumberFormatException e2) {
                            optionInt2 = -1;
                        }
                    } while (optionInt2 < 0 || optionInt2 > studentDTOList.size());
                    if (optionInt2 != 0) {
                        if (!canOnlyReject) {
                            newStatus = canAcceptReject();
                        }
                        controller.changeEnrollmentStatus(courseDTOList.get(optionInt1 - 1), studentDTOList.get(optionInt2 - 1), newStatus);
                        if(newStatus.equalsIgnoreCase("Accepted")){
                            System.out.println("The enrollment was successfully accepted.");
                        }else{
                            System.out.println("The enrollment was successfully rejected.");
                        }
                    }
                }
            }
        }else{
            System.out.println("There are no courses with enrollments!");
        }
        return true;
    }

    @Override
    public String headline() {
        return "Approve/Reject Enrollments";
    }

    private String canAcceptReject(){
        System.out.println("Would you like to accept or reject?");
        System.out.println("1. Accept");
        System.out.println("2. Reject");
        boolean hasEntered = false;
        String optionString = "-1";
        int option = -1;
        Scanner read = new Scanner(System.in);
        do{
            if(hasEntered){
                System.out.println("Please insert 1 or 2.");
            }
            hasEntered = true;
            try{
                optionString = read.nextLine();
                option = Integer.parseInt(optionString);
            }catch (NumberFormatException e){
                option = -1;
            }
        }while(option < 1 || option>2);
        switch (option){
            case(1): return "ACCEPTED";
            case(2): return "REJECTED";
        }
        return "ERROR";
    }
}
