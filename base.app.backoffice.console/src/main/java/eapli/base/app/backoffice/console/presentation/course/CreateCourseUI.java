package eapli.base.app.backoffice.console.presentation.course;

import eapli.base.coursemanagement.application.CreateCourseController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class CreateCourseUI extends AbstractUI {

    CreateCourseController controller = new CreateCourseController();

    @Override
    protected boolean doShow() {
        String courseId = Console.readLine("Course identifier");
        String courseTitle = Console.readLine("Course title");
        String courseName = Console.readLine("Course name");
        String description = Console.readLine("Course description");
        int minEnrollments = Console.readInteger("Course minimum number of enrollments");
        int maxEnrollments = Console.readInteger("Course maximum number of enrollments");

        System.out.print("\n\n");

        printInsertedInfo(courseId,courseTitle,courseName,description,maxEnrollments,minEnrollments);

        System.out.print("\n");
        boolean conf = Console.readBoolean("Are you sure you want to create a course with this information?(y/n)");

        if (conf) {
            try {
                controller.createCourse(courseId,courseTitle,courseName,description,maxEnrollments,minEnrollments);
            } catch ( IllegalArgumentException e ) {
                System.out.println("\n[ERROR]\n");
                System.out.println(e.getMessage());
                System.out.print("\n");
            }
        }
        return true;
    }

    private void printInsertedInfo(String courseId, String courseTitle, String courseName, String description, int maxEnrollments, int minEnrollments) {
        System.out.printf("Course identifier: %s\n",courseId);
        System.out.printf("Course title: %s\n",courseTitle);
        System.out.printf("Course name: %s\n",courseName);
        System.out.printf("Course description: %s\n",description);
        System.out.printf("Course minimum number of enrollments: %d\n",minEnrollments);
        System.out.printf("Course maximum number of enrollments: %d\n",maxEnrollments);
    }

    @Override
    public String headline() {
        return "Create course";
    }
}
