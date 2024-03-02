package eapli.base.coursemanagement.application;

import eapli.base.coursemanagement.application.services.ListCourseService;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;


import java.util.ArrayList;

public class ListCourseController {

    ListCourseService service = new ListCourseService();

    public ArrayList<CourseDTOWithIdTitle> listCourse(){
        return service.listCourse();
    }
}
