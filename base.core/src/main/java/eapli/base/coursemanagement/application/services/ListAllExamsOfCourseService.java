package eapli.base.coursemanagement.application.services;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.coursemanagement.dto.CourseMapper;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.exams.domain.Exam;
import eapli.base.exams.dto.*;
import eapli.base.exams.repositories.ExamRepository;
import eapli.base.formativeexams.domain.FormativeExam;
import eapli.base.formativeexams.dto.FormativeExamDTOWithId;
import eapli.base.formativeexams.dto.FormativeExamDTOWithIdMapper;
import eapli.base.formativeexams.repositories.FormativeExamRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class ListAllExamsOfCourseService {

    private final CourseRepository courseRepository = PersistenceContext.repositories().courseRepository();
    private final ExamRepository examRepository = PersistenceContext.repositories().examRepository();
    private final FormativeExamRepository formativeExamRepository = PersistenceContext.repositories().formativeExamRepository();

    public List<CourseDTOWithIdTitle> listAllCourses(){
        List<CourseDTOWithIdTitle> courseDTOList = new ArrayList<>();
        CourseMapper courseMapper = new CourseMapper();
        Iterable<Course> courseList = courseRepository.findAll();
        if(courseList.spliterator().getExactSizeIfKnown()==0){
            throw new IllegalArgumentException("There are no courses available.");
        }
        for (Course course: courseList) {
            CourseDTOWithIdTitle courseDTOWithIdTitle = courseMapper.toDTOWithIdTitle(course);
            courseDTOList.add(courseDTOWithIdTitle);
        }

        return courseDTOList;
    }
    public List<ExamDTOWithExamTitleDateInterval> listExamsFromCourse(CourseDTOWithIdTitle selectedCourseDTO){
        List<ExamDTOWithExamTitleDateInterval> examDTOList = new ArrayList<>();
        ExamDTOWithExamTitleDateIntervalMapper examDTOWithDatesCourseIdMapper = new ExamDTOWithExamTitleDateIntervalMapper();
        List<Exam> examList = examRepository.findExamsFromCourse(new CourseIdentifier(selectedCourseDTO.courseIdentifier));
        if(examList.isEmpty()){
            throw new IllegalArgumentException("There no exams in the selected course.");
        }
        for (Exam exam : examList) {
            ExamDTOWithExamTitleDateInterval examDTOWithExamIdDateInterval = examDTOWithDatesCourseIdMapper.toDto(exam);
            examDTOList.add(examDTOWithExamIdDateInterval);
        }

        return examDTOList;
    }

    public List<FormativeExamDTOWithId> listFormativeExamsFromCourse(CourseDTOWithIdTitle selectedCourseDTO){
        List<FormativeExamDTOWithId> examDTOList = new ArrayList<>();
        FormativeExamDTOWithIdMapper formativeExamDTOWithBuilder = new FormativeExamDTOWithIdMapper();
        List<FormativeExam> formativeExamList = formativeExamRepository.findFormativeExamsFromCourse(new CourseIdentifier(selectedCourseDTO.courseIdentifier));
        if(formativeExamList.isEmpty()){
            throw new IllegalArgumentException("There no formative exams in the selected course.");
        }
        for (FormativeExam formativeExam : formativeExamList) {
            FormativeExamDTOWithId formativeExamDTOWithId = formativeExamDTOWithBuilder.toDto(formativeExam);
            examDTOList.add(formativeExamDTOWithId);
        }

        return examDTOList;
    }

}
