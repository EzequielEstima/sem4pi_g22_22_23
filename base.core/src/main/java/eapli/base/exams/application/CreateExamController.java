package eapli.base.exams.application;

import eapli.base.coursemanagement.application.ListCourseController;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.exams.application.services.CreateUpdateExamService;

import java.util.ArrayList;
import java.util.Date;

public class CreateExamController {

    public ArrayList<CourseDTOWithIdTitle> listCourse(){
        return new ListCourseController().listCourse();
    }

    public boolean createExam(String structure, CourseDTOWithIdTitle courseDto,Date initialDate,Date finalDate){
        return new CreateUpdateExamService().createExam(structure,courseDto,initialDate,finalDate);
    }

}
