package eapli.base.courseclasses.application;

import eapli.base.courseclasses.application.services.VerifyIfExistAClassControllerForCourseService;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;

import java.util.Date;

public class VerifyIfExistAClassAtTheTimeForClassController {

    public boolean verifyIfExistAClassAtTheTime(Date startingDateWithTime, int duration, CourseDTOWithIdTitle courseDTO){
        return new VerifyIfExistAClassControllerForCourseService().verifyIfExistAClassAtTheTime(startingDateWithTime,duration,courseDTO);
    }


}
