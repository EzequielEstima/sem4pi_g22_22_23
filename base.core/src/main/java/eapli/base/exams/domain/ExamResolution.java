package eapli.base.exams.domain;

import eapli.base.exceptions.InvalidIdException;
import eapli.base.exceptions.NegativeParameterException;
import eapli.base.exceptions.ParameterNullBlankException;
import eapli.base.usermanagement.domain.Student;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ExamResolution implements AggregateRoot<ExamResolutionId> {

    @EmbeddedId
    private ExamResolutionId examResolution_Id;

    private Grade grade;

    @ManyToOne
    @JoinColumn
    private Student student;
    @ManyToOne
    @JoinColumn
    private Exam exam;

    public ExamResolution(ExamResolutionId id, Grade grade, Student student, Exam exam) throws ParameterNullBlankException {
        if (validateIdGradeStudentAndExam(id,grade, student,exam)) {
            this.examResolution_Id = id;
            this.grade = grade;
            this.student = student;
            this.exam = exam;
        }
    }

    private boolean validateIdGradeStudentAndExam(ExamResolutionId id, Grade grade, Student student, Exam exam) throws ParameterNullBlankException {
        return ensureIdIsNotNull(id) && ensureGradeIsNotNull(grade)
                && ensureStudentIsNotNull(student) && ensureExamIsNotNull(exam);
    }

    private boolean ensureExamIsNotNull(Exam exam) throws ParameterNullBlankException {
        if(exam == null){
            throw new ParameterNullBlankException("Exam resolution exam cannot be null.");
        }
        return true;
    }

    private boolean ensureStudentIsNotNull(Student student) throws ParameterNullBlankException {
        if(student == null){
            throw new ParameterNullBlankException("Exam resolution student cannot be null.");
        }
        return true;
    }

    private boolean ensureIdIsNotNull(ExamResolutionId id) throws ParameterNullBlankException {
        if(id == null){
            throw new ParameterNullBlankException("Exam resolution id cannot be null.");
        }
        return true;
    }

    private boolean ensureGradeIsNotNull(Grade grade) throws ParameterNullBlankException {
        if(grade == null){
            throw new ParameterNullBlankException("Exam resolution grade cannot be null.");
        }
        return true;
    }

    public ExamResolution(long id, double grade, Student student, Exam exam) throws InvalidIdException, NegativeParameterException, ParameterNullBlankException {
        if (ensureStudentIsNotNull(student) && ensureExamIsNotNull(exam)){
            this.examResolution_Id = new ExamResolutionId(id);
            this.grade = new Grade(grade);
            this.student = student;
            this.exam = exam;
        }
    }

    protected ExamResolution() {
        //Only for ORM
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof ExamResolution)) {
            return false;
        }

        final ExamResolution that = (ExamResolution) other;

        return examResolution_Id.equals(that.examResolution_Id) && grade.equals(that.grade)
                && exam.equals(that.exam) && student.equals(that.student);
    }

    @Override
    public ExamResolutionId identity() {
        return this.examResolution_Id;
    }

    public String returnExamTitleString(){
        return exam.returnExamTitleString();
    }


    public String returnGradeString(){
        return grade.toString();
    }
}
