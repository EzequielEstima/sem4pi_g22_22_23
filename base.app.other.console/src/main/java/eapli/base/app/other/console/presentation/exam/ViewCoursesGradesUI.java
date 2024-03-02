package eapli.base.app.other.console.presentation.exam;

import eapli.base.exams.application.ViewCourseGradesController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;

public class ViewCoursesGradesUI extends AbstractUI {

    private static ViewCourseGradesController viewCourseGradesController = new ViewCourseGradesController();

    @Override
    protected boolean doShow() {

        List<String> courseList = viewCourseGradesController.listTeacherCourses();

        if (!courseList.isEmpty()) {

            Map<Integer, List<String>> gradesByCourse = new HashMap<>();
            int changeOption = 0;

            System.out.println("\n1. Select a set of courses\n2. Select All Courses\n0. Return\n");
            changeOption = Console.readOption(1, 2, 0);

            while (changeOption != -1) {
                if (changeOption == 1) {

                    List<String> coursesCopy = new ArrayList<>();
                    coursesCopy.addAll(courseList);
                    int size = courseList.size();

                    int option = -1;

                    List<String> selectedCourses = new ArrayList<>();

                    while(option != 0) {

                        for (int i = 0; i < size; i++) {

                            System.out.printf("%d. Course Id: %s\n", i + 1, coursesCopy.get(i));
                        }

                        System.out.println("0. end\n");

                        option = (Console.readOption(1, size, 0));

                        if(option!=0) {

                            selectedCourses.add(coursesCopy.get(option - 1));
                            coursesCopy.remove(option - 1);

                            size--;

                            if (size == 0) {
                                option = 0;
                            }

                            System.out.println("\nThe course you selected was added to the set of courses.\n");

                        }

                    }

                    if (!coursesCopy.equals(courseList)) {

                        gradesByCourse = viewCourseGradesController.listGradesFromTeacherCourse(selectedCourses);

                        gradesByCoursePrinter(gradesByCourse, selectedCourses);

                        changeOption = -1;

                    }

                } else if (changeOption == 2) {

                    gradesByCourse = viewCourseGradesController.listGradesFromTeacherCourse(courseList);

                    gradesByCoursePrinter(gradesByCourse, courseList);

                    changeOption = -1;

                }

                changeOption = -1;
            }
        }else

        {

            System.out.println("You have no courses available!");

        }


        return false;

    }



    @Override
    public String headline() {
        return "View Courses Grades";
    }

    private void gradesByCoursePrinter(Map<Integer, List<String>> gradesByCourse, List<String> courses){

        for (Map.Entry<Integer, List<String>> info: gradesByCourse.entrySet()) {

            System.out.printf("\nCourse: %s\n", courses.get(info.getKey()-1));
            int size = info.getValue().size();

            if(size == 0){

                System.out.println("There are no grades in this course.");

            }else{

                System.out.println("Grades List:");

                for (int i = 0; i < size; i++) {
                    System.out.printf("%d. %s \n", i+1, info.getValue().get(i));
                }

            }

        }

    }
}
