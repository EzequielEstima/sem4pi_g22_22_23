package eapli.base.exams.application.services;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.exams.domain.Exam;
import eapli.base.exams.domain.ExamResolution;
import eapli.base.exams.domain.ExamTitle;
import eapli.base.exams.repositories.ExamRepository;
import eapli.base.exams.repositories.ExamResolutionRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewCourseGradesService {

    CourseRepository courseRepository = PersistenceContext.repositories().courseRepository();

    ExamRepository examRepository = PersistenceContext.repositories().examRepository();

    ExamResolutionRepository examResolutionRepository = PersistenceContext.repositories().examResolutionRepository();

    private static ViewCourseGradesService viewCourseGradesService = new ViewCourseGradesService();

    public List<String> listTeacherCourses(){

        List<String> courseList = new ArrayList<>();

        SystemUser systemUser = AuthzRegistry.authorizationService().session().get().authenticatedUser();
        List<Course> courseEntityList = courseRepository.findTeacherInChargeCourses(systemUser);
        courseEntityList.addAll(courseRepository.findTeacherLecturesCourses(systemUser));
        for (Course course : courseEntityList) {

            courseList.add(course.returnCourseIdentifierString());

        }

        return courseList;
    }

    public Map<Integer, List<String>> listGradesFromTeacherCourse(List<String> courses){

        Map<Integer, List<String>> gradesByCourse = new HashMap<>();

        int size = courses.size();

        for (int i = 0; i < size; i++) {

            List<Exam> examList = examRepository.findExamsFromCourse(new CourseIdentifier(courses.get(i)));

            if(!examList.isEmpty()) {

                int sizeExamList = examList.size();
                List<String> gradeList = new ArrayList<>();

                for (int j = 0; j < sizeExamList; j++) {

                    List<ExamResolution> examResolutionList = examResolutionRepository.findExamResolutionsByExamId(new ExamTitle(examList.get(j).returnExamTitleString()));

                    if(!examResolutionList.isEmpty()){

                        for (ExamResolution examResolution : examResolutionList) {

                            gradeList.add(examResolution.returnGradeString());

                        }

                    }


                }

                gradesByCourse.put(i + 1, gradeList);

            }else {

                gradesByCourse.put(i + 1, new ArrayList<>());

            }

        }

        return gradesByCourse;

    }
}
