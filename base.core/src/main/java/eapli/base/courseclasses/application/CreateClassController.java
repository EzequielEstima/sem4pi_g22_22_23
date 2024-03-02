package eapli.base.courseclasses.application;

import eapli.base.courseclasses.application.services.CreateClassService;
import eapli.base.coursemanagement.application.ListCourseController;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;

import java.util.ArrayList;
import java.util.Date;

public class CreateClassController {

    private CreateClassService  createClassService = new CreateClassService();


    public ArrayList<CourseDTOWithIdTitle> listCourse(){
        return new ListCourseController().listCourse();
    }

    public boolean verifyIfExistAClassAtTheTime(Date startingDateWithTime, int duration, CourseDTOWithIdTitle courseDTO){
        return new VerifyIfExistAClassAtTheTimeForClassController().verifyIfExistAClassAtTheTime(startingDateWithTime,duration,courseDTO);
    }

    public boolean createClass(String title, Date startingDateWithTime, int numberOfRecurrence, int duration, CourseDTOWithIdTitle courseDTO){
        return createClassService.createClass(title,startingDateWithTime,numberOfRecurrence,duration,courseDTO);
    }


}
