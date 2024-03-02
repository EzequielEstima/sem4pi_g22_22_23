package eapli.base.courseclasses.dto;

import java.util.Date;
import java.util.List;

public class ClassWithWeeklyDateDTO {
    public List<Date> dates;
    public List<Integer> durations;
    public ClassWithWeeklyDateDTO(List<Date> dates, List<Integer> durations) {
        this.dates = dates;
        this.durations = durations;
    }
}
