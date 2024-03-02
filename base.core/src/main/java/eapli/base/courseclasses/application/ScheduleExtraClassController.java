package eapli.base.courseclasses.application;

import eapli.base.courseclasses.application.services.ScheduleExtraClassService;
import eapli.base.coursemanagement.application.ListCourseController;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;

import java.util.List;

public class ScheduleExtraClassController {

    private ScheduleExtraClassService service = new ScheduleExtraClassService();

    public List<CourseDTOWithIdTitle> listAllTeacherAvailableCourses() {
        return new ListCourseController().listCourse();
    }

    public boolean verifyScheduleAvailability(java.util.Date dateWithTime, int duration, CourseDTOWithIdTitle courseDTO, List<String> studentMechNumList) {
        return new VerifyScheduleAvailabilityController().verifyScheduleAvailability(dateWithTime, duration, courseDTO, studentMechNumList);
    }

    public boolean createExtraClass(java.util.Date dateWithTime, int duration, CourseDTOWithIdTitle courseDTO, List<String> studentMechNumList){
        return service.createExtraClass(dateWithTime,duration,courseDTO,studentMechNumList);
    }
}
