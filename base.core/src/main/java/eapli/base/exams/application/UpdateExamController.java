package eapli.base.exams.application;

import eapli.base.exams.application.services.CreateUpdateExamService;
import eapli.base.exams.dto.ExamDTOWithDatesExamTitleCourseId;

import java.util.Date;
import java.util.List;

public class UpdateExamController {

        public List<ExamDTOWithDatesExamTitleCourseId> listTeacherExams(){
            return new ListTeacherExamsController().listTeacherExams();
        }

        public boolean updateExam(String structure, Date initialDate, Date finalDate, ExamDTOWithDatesExamTitleCourseId examDTO){
            return new CreateUpdateExamService().updateExam(structure,initialDate,finalDate,examDTO);
        }
}
