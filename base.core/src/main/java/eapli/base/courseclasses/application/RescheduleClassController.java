package eapli.base.courseclasses.application;

import eapli.base.courseclasses.application.services.RescheduleClassService;
import eapli.base.courseclasses.dto.ClassWithIdAndTittleDTO;
import eapli.base.courseclasses.dto.ClassWithWeeklyDateDTO;
import org.springframework.data.util.Pair;

import java.util.Date;
import java.util.List;

public class RescheduleClassController {
    private final RescheduleClassService theService = new RescheduleClassService();

    public boolean rescheduleClass(List<Date> dates, List<Integer> durations, ClassWithIdAndTittleDTO selectedClass) {
        return theService.rescheduleClass(dates, durations, selectedClass);
    }
}
