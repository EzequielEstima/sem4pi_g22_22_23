package eapli.base.courseclasses.application.services;

import eapli.base.courseclasses.domain.Class;
import eapli.base.courseclasses.domain.Duration;
import eapli.base.courseclasses.domain.ScheduledDate;
import eapli.base.courseclasses.domain.WeeklyDate;
import eapli.base.courseclasses.dto.ClassMapper;
import eapli.base.courseclasses.dto.ClassWithIdAndTittleDTO;
import eapli.base.courseclasses.dto.ClassWithWeeklyDateDTO;
import eapli.base.courseclasses.repositories.ClassRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Teacher;
import eapli.base.usermanagement.repositories.TeacherRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RescheduleClassService {
    private final ClassRepository classRepository = PersistenceContext.repositories().classRepository();
    private final ClassMapper classMapper = new ClassMapper();
    private final TeacherRepository teacherRepository = PersistenceContext.repositories().teacherRepository();

    public Pair<List<ClassWithWeeklyDateDTO>, List<ClassWithIdAndTittleDTO>> requestInformation() {
        AuthorizationService authz = AuthzRegistry.authorizationService();
        SystemUser user = authz.session().get().authenticatedUser();
        Teacher teacher = teacherRepository.findTeacherBySystemUser(user);
        Iterable<Class> classes = classRepository.findAll(teacher);
        if (classes==null||!classes.iterator().hasNext()){
            throw new IllegalArgumentException("There is no classes to reschedule");
        }
        List<ClassWithWeeklyDateDTO> listDTO = new ArrayList<>();
        List<ClassWithIdAndTittleDTO> listDTO2 = new ArrayList<>();
        for (Class c : classes) {
            listDTO.add(classMapper.toDTOWithDateAndDuration(c));
        }
        for (Class c : classes) {
            listDTO2.add(classMapper.toDTOWithIdAndTittle(c));
        }
        return Pair.of(listDTO,listDTO2);
    }

    public boolean rescheduleClass(List<Date> dates, List<Integer> durations, ClassWithIdAndTittleDTO selectedClass) {
        List<ScheduledDate> scheduledDateList = new ArrayList<>();
        for (int i = 0; i<dates.size(); i++){
            scheduledDateList.add(new ScheduledDate(new Duration(durations.get(i)),new eapli.base.courseclasses.domain.Date(dates.get(i))));
        }
        WeeklyDate weeklyDate = new WeeklyDate(scheduledDateList,false);
        Class c = classRepository.findById(selectedClass.id);
        boolean flag = c.reschedule(weeklyDate);
        if (flag) {
            classRepository.save(c);
            return true;
        }
        return false;
    }
}
