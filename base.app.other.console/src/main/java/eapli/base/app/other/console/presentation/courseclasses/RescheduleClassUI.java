package eapli.base.app.other.console.presentation.courseclasses;

import eapli.base.courseclasses.application.RequestClassesController;
import eapli.base.courseclasses.application.RescheduleClassController;
import eapli.base.courseclasses.dto.ClassWithIdAndTittleDTO;
import eapli.base.courseclasses.dto.ClassWithWeeklyDateDTO;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.springframework.data.util.Pair;

import java.util.Date;
import java.util.List;


public class RescheduleClassUI extends AbstractUI {
    private final RescheduleClassController rescheduleClassController = new RescheduleClassController();
private final RequestClassesController requestClassesController = new RequestClassesController();

    @Override
    protected boolean doShow() {

        try {

            Pair<List<ClassWithWeeklyDateDTO>, List<ClassWithIdAndTittleDTO>> pair = requestClassesController.requestInformation();

            List<ClassWithWeeklyDateDTO> dates = pair.getFirst();
            List<ClassWithIdAndTittleDTO> classes = pair.getSecond();

            if (!classes.isEmpty()) {

                int i = 0;

                System.out.println("Classes:");
                for (ClassWithIdAndTittleDTO c : classes) {
                    i++;
                    System.out.println(i+". ID:"+c.id + " - Tittle:" + c.tittle);
                }
                System.out.println("Select one:");

                int option = Console.readOption(1, classes.size(), classes.size() + 1);

                if (option == classes.size() + 1) {
                    do {
                        option = Console.readOption(1, classes.size(), classes.size() + 1);
                    }while (option == classes.size() + 1);
                }

                ClassWithIdAndTittleDTO selectedClass = classes.get(option - 1);
                ClassWithWeeklyDateDTO datesDTO = dates.get(option - 1);

                i = 0;

                System.out.println("Dates:");
                for (int j = 0; j < datesDTO.dates.size(); j++) {
                    i++;
                    System.out.println(i+". Date:"+datesDTO.dates.get(j) + " - Duration:" + datesDTO.durations.get(j));
                }
                System.out.println("Select one you want to change:");

                option = Console.readOption(1, datesDTO.dates.size(), datesDTO.dates.size() + 1);

                if (option == datesDTO.dates.size() + 1) {
                    do {
                        option = Console.readOption(1, datesDTO.dates.size(), datesDTO.dates.size() + 1);
                    }while (option == datesDTO.dates.size() + 1);
                }

                Date newDate = Console.readDate("Specify the new date (yyyy/MM/dd HH:mm)", "yyyy/MM/dd HH:mm");

                datesDTO.dates.set(option - 1, newDate);
                datesDTO.durations.set(option - 1, Console.readInteger("Specify the new duration in minutes"));

                if (rescheduleClassController.rescheduleClass(datesDTO.dates, datesDTO.durations, selectedClass)) {
                    System.out.println("Class rescheduled");
                    return true;
                }
            }
            else {
                System.out.println("There are no classes to reschedule");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Reschedule a class";
    }
}
