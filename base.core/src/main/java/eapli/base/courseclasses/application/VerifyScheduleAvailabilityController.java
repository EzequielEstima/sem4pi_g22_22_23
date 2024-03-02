package eapli.base.courseclasses.application;

import eapli.base.courseclasses.application.services.VerifyScheduleAvailabilityService;
import eapli.base.coursemanagement.application.ListCourseController;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;

import java.util.List;

public class VerifyScheduleAvailabilityController {

    public boolean verifyScheduleAvailability(java.util.Date dateWithTime, int  duration, CourseDTOWithIdTitle courseDTO, List<String> studentMechNumList){
        return new VerifyScheduleAvailabilityService().verifyScheduleAvailability(dateWithTime,duration,courseDTO,studentMechNumList);
    }
}
