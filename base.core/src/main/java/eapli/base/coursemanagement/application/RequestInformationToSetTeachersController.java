package eapli.base.coursemanagement.application;

import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.coursemanagement.application.services.SetTeacherService;
import eapli.base.usermanagement.dto.TeacherDTOWithAcronym;
import org.springframework.data.util.Pair;

import java.util.List;

public class RequestInformationToSetTeachersController {

    private final SetTeacherService theService = new SetTeacherService();

    public Pair<List<TeacherDTOWithAcronym>, List<CourseDTOWithIdTitle>> requestInformation() {
        return this.theService.requestInformation();
    }

}
