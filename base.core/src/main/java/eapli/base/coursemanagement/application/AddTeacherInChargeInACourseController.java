package eapli.base.coursemanagement.application;

import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.coursemanagement.application.services.SetTeacherService;
import eapli.base.usermanagement.dto.TeacherDTOWithAcronym;

public class AddTeacherInChargeInACourseController {

    private final SetTeacherService theService = new SetTeacherService();

    public boolean addTeacherInCharge(TeacherDTOWithAcronym teacherDTO, CourseDTOWithIdTitle courseDTO) {
        return this.theService.addTeacherInCharge(teacherDTO, courseDTO);
    }

}
