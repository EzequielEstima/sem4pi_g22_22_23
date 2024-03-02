package eapli.base.courseclasses.application;

import eapli.base.courseclasses.application.services.RescheduleClassService;
import eapli.base.courseclasses.dto.ClassWithIdAndTittleDTO;
import eapli.base.courseclasses.dto.ClassWithWeeklyDateDTO;
import org.springframework.data.util.Pair;

import java.util.List;

public class RequestClassesController {
    private final RescheduleClassService theService = new RescheduleClassService();
    public Pair<List<ClassWithWeeklyDateDTO>, List<ClassWithIdAndTittleDTO>> requestInformation() {
        return theService.requestInformation();
    }
}
