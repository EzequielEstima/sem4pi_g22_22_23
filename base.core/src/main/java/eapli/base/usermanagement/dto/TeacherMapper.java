package eapli.base.usermanagement.dto;

import eapli.base.usermanagement.domain.Teacher;

import java.util.List;

public class TeacherMapper {
    public static TeacherDTOWithAcronym toDTOWithAcronym(Teacher teacher) {
        TeacherDTOBuilder teacherDTOBuilder = new TeacherDTOBuilder();
        return teacherDTOBuilder.withAcronym(teacher.returnAcronymString()).buildWithAcronym();
    }

}
