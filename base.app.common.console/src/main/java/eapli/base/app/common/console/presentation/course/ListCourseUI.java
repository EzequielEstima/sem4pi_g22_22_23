package eapli.base.app.common.console.presentation.course;

import eapli.base.coursemanagement.application.ListCourseController;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;

public class ListCourseUI extends AbstractUI{


    ListCourseController controller = new ListCourseController();


    @Override
    protected boolean doShow() {
        ArrayList<CourseDTOWithIdTitle> listCourseDTO = controller.listCourse();
        for (CourseDTOWithIdTitle courseDTO: listCourseDTO){
            System.out.println(courseDTO);
        }
        return true;
    }

    @Override
    public String headline() {
        return "List course";
    }
}
