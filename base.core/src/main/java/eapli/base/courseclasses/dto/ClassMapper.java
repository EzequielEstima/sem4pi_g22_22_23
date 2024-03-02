package eapli.base.courseclasses.dto;
import eapli.base.courseclasses.domain.Class;
public class ClassMapper {
    public ClassWithWeeklyDateDTO toDTOWithDateAndDuration(Class c){
        ClassDTOBuilder builder = new ClassDTOBuilder();
        return builder.toDTOWithDateAndDuration(c.returnDates(),c.returnDuration());
    }

    public ClassWithIdAndTittleDTO toDTOWithIdAndTittle(Class c) {
        ClassDTOBuilder builder = new ClassDTOBuilder();
        return builder.toDTOWithIdAndTittle(c.returnId(),c.returnTittle());
    }
}
