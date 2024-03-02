package eapli.base.app.user.console.presentation.enrollment;

import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.enrollments.application.RequestEnrollmentController;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.List;

public class RequestEnrollmentUI extends AbstractUI {

    private final RequestEnrollmentController controller = new RequestEnrollmentController();

    @Override
    protected boolean doShow() {

        List<CourseDTOWithIdTitle> courseDTOList= this.controller.listAllStudentAvailableCourses();
        if (courseDTOList.size() == 0){
            System.out.println("\n[ERROR]");
            System.out.println("There are no courses open to enrollments at the moment");
            return false;
        }else{
            final SelectWidget<CourseDTOWithIdTitle> selector = new SelectWidget<>("Select a course:\n(Course identifier | Course title)",
                    courseDTOList , new CourseDTOWithIdTitlePrinter());

            selector.show();
            final CourseDTOWithIdTitle selectedCourse = selector.selectedElement();
            if(selectedCourse != null){

                try {
                    controller.createEnrollment(selectedCourse);
                    System.out.println("\nEnrollment request was successfully registered\n");
                } catch (Exception e) {
                    System.out.println("\n[ERROR]");
                    System.out.println(e.getMessage());
                }
            }

        }
        return true;
    }

    @Override
    public String headline() {
        return "Request enrollment";
    }
}
