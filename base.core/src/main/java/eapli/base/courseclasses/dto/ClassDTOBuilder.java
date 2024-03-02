package eapli.base.courseclasses.dto;

import java.util.Date;
import java.util.List;

public class ClassDTOBuilder {

    public ClassWithWeeklyDateDTO toDTOWithDateAndDuration(List<Date> dates,
                                                           List<Integer> durations) {
        return new ClassWithWeeklyDateDTO(dates, durations);
    }

    public ClassWithIdAndTittleDTO toDTOWithIdAndTittle(long id, String tittle) {
        return new ClassWithIdAndTittleDTO(id, tittle);
    }
}
