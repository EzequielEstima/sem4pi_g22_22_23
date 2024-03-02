package eapli.base.coursemanagement.domain;

import eapli.base.courseclasses.domain.Class;
import eapli.base.courseclasses.domain.ExtraClass;
import eapli.base.enrollments.domain.Enrollment;
import eapli.base.exams.domain.Exam;
import eapli.base.formativeexams.domain.FormativeExam;
import eapli.base.questionmanagement.domain.Question;
import eapli.base.usermanagement.domain.Teacher;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Course implements AggregateRoot<CourseIdentifier> {
    @EmbeddedId
    private CourseIdentifier courseId;

    private CourseTitle courseTitle;

    private CourseName courseName;

    private Description courseDescription;

    private EnrollmentLimits enrollmentLimits;

    private CourseStatus courseStatus;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Question> questionList = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Teacher teacherInCharge;

    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Teacher> teachersList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Enrollment> enrollmentsList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<ExtraClass> extraClassesList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Class> classesList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Exam> examsList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<FormativeExam> formativeExams = new ArrayList<>();

    public Course(CourseIdentifier courseId, CourseTitle courseTitle, CourseName courseName, Description description, EnrollmentLimits enrollmentLimits, CourseStatus courseStatus, Teacher teacherInCharge) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseName = courseName;
        this.courseDescription = description;
        this.enrollmentLimits = enrollmentLimits;
        this.courseStatus = courseStatus;
        this.teacherInCharge = teacherInCharge;
    }

    protected Course() {
        //Only for ORM
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Course)) {
            return false;
        }

        final Course that = (Course) other;

        return courseId.equals(that.courseId) && courseTitle.equals(that.courseTitle) && courseName.equals(that.courseName) && courseDescription.equals(that.courseDescription)
                && enrollmentLimits.equals(that.enrollmentLimits) && courseStatus.equals(that.courseStatus) && teacherInCharge.equals(that.teacherInCharge)
                && enrollmentsList.equals(that.enrollmentsList) && teachersList.equals(that.teachersList)
                && classesList.equals(that.classesList) && extraClassesList.equals(that.extraClassesList);
    }

    @Override
    public int compareTo(CourseIdentifier other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public CourseIdentifier identity() {
        return courseId;
    }

    @Override
    public boolean hasIdentity(CourseIdentifier id) {
        return AggregateRoot.super.hasIdentity(id);
    }

    public String returnCourseTitleString(){
        return courseTitle.returnCourseTitleString();
    }
    public String returnCourseIdentifierString(){
        return courseId.returnCourseIdentifierString();
    }
    public String returnCourseStatusString(){
        return courseStatus.returnCourseStatusString();
    }

    public boolean changeStatus(String newStatus){
        CourseStatusValue courseStatusValue = CourseStatusValue.valueOf(newStatus);
        CourseStatus newCourseStatus = new CourseStatus(courseStatusValue);
        if(newCourseStatus.returnCourseStatusInt() == courseStatus.returnCourseStatusInt() + 1) {
            courseStatus = new CourseStatus(courseStatusValue);
            return true;
        }
        throw new IllegalArgumentException("The course you're trying to change the status cannot change to that one right now.");
    }

    public boolean hasTeacherInCharge(){
        return this.teacherInCharge != null;
    }
    public boolean hasThisTeacherInCharge(Teacher teacher){
        return this.teacherInCharge.sameAs(teacher);
    }

    public boolean verifyIfWillExceedEnrollmentLimits(int numberOfAcceptedEnrollments, int numberOfNewEnrollments){
        return enrollmentLimits.verifyIfWillExceedEnrollmentLimits(numberOfAcceptedEnrollments, numberOfNewEnrollments);
    }

    public boolean addEnrollment(Enrollment newEnrollment) {
        enrollmentsList.add(newEnrollment);
        return true;
    }

    /**
     * Method that adds a teacher to a course
     * @param newTeacher Object of type Teacher that will be added as a teacher of the course
     * @return boolean
     */

    public boolean addTeachersToList(List<Teacher> newTeacher) {
        for (Teacher teacher : newTeacher) {
            if (teachersList.contains(teacher)) {
                return false;
            }
            teachersList.add(teacher);
        }
        return true;
    }
    /**
     * Method that adds a teacher in charge to a course
     * @param teacherInCharge Object of type Teacher that will be added as the teacher in charge of the course
     * @return boolean
     */
    public boolean addTeacherInCharge(Teacher teacherInCharge){
        this.teacherInCharge = teacherInCharge;
        return true;
    }

    public boolean verifyIfExistAClassAtTheTime(Date startingDateWithTime, int duration){
        for (Class courseClass: classesList) {
            if (courseClass.verifyIfAClassAtTheTime(startingDateWithTime,duration)){
                return true;
            }
        }
        return false;
    }

    public boolean verifyIfExistAnExtraClassAtTheTime(Date startingDateWithTime, int duration){
        for (ExtraClass extraClass: extraClassesList) {
            if (extraClass.verifyIfExistAnExtraClassAtTheTime(startingDateWithTime,duration)){
                return true;
            }
        }
        return false;
    }

    public boolean addClass(Class courseClass) {
        classesList.add(courseClass);
        return true;
    }

    public boolean addExtraClass(ExtraClass extraClass){
        extraClassesList.add(extraClass);
        return true;
    }

    public boolean addQuestion(Question question) {
        return questionList.add(question);
    }
    public boolean addExam(Exam exam){
        examsList.add(exam);
        return true;
    }

    public boolean addFormativeExam(FormativeExam formativeExam){
        formativeExams.add(formativeExam);
        return true;
    }

    public boolean hasTeacherInList(List<Teacher> teacherList) {
        return this.teachersList.equals(teacherList);
    }

    public List<Exam> findAllDoableExams(Date currDate) {
        List<Exam> result = new ArrayList<>();
        for (Exam ex : examsList){
            if (!ex.cannotBeTaken(currDate)){
                result.add(ex);
            }
        }
        return result;
    }
}
