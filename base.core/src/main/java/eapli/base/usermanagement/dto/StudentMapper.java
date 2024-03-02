package eapli.base.usermanagement.dto;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.dto.CourseDTOBuilder;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitleStatus;
import eapli.base.usermanagement.domain.Student;

public class StudentMapper {
    public static StudentDTOWithMechNumber toDTOWithMechNumber(Student student){
        StudentDTOBuilder studentDTOBuilder = new StudentDTOBuilder();
        return studentDTOBuilder.withMechanographicNumber(student.returnMechanographicNumberString()).buildWithMechNumber();
    }
}
