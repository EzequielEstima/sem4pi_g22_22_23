package eapli.base.exams.domain;

import eapli.base.exceptions.InvalidIdException;
import eapli.base.exceptions.NegativeParameterException;
import eapli.base.exceptions.ParameterNullBlankException;
import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.domain.Teacher;
import eapli.base.usermanagement.domain.builder.StudentBuilder;
import eapli.base.usermanagement.domain.builder.TeacherBuilder;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import static org.junit.Assert.*;

public class ExamResolutionTest {



    @Test(expected = ParameterNullBlankException.class)
    public void ensureIdCannotBeNull() throws NegativeParameterException, ParameterNullBlankException, IOException {
        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();
        Path path = Paths.get("files/testfiles/US2001/ExamAccepted.txt");
        byte[] fileBytes = Files.readAllBytes(path);
        String str = new String(fileBytes);
        Exam exam = new ExamBuilder().withExamSpecification(str).withTeacher(aTeacher).withDateInterval(new Date(1000,1,10),new Date (1000,1,11)).build();

        Student aStudent = new StudentBuilder().withMecanographicNumber(1,"2000")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();


        ExamResolution instance = new ExamResolution(null,new Grade((double)20),aStudent,exam);
    }

    @Test(expected = ParameterNullBlankException.class)
    public void ensureGradeCannotBeNull() throws ParameterNullBlankException, InvalidIdException, IOException {
        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();
        Path path = Paths.get("files/testfiles/US2001/ExamAccepted.txt");
        byte[] fileBytes = Files.readAllBytes(path);
        String str = new String(fileBytes);
        Exam exam = new ExamBuilder().withExamSpecification(str).withTeacher(aTeacher).withDateInterval(new Date(1000,1,10),new Date (1000,1,11)).build();

        Student aStudent = new StudentBuilder().withMecanographicNumber(1,"2000")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();

        ExamResolution instance = new ExamResolution(new ExamResolutionId((long) 2),null,aStudent,exam);
    }

    @Test
    public void ensureEqualExamResolutionsAreTheSame() throws NegativeParameterException, InvalidIdException, IOException, ParameterNullBlankException {
        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();
        Path path = Paths.get("files/testfiles/US2001/ExamAccepted.txt");
        byte[] fileBytes = Files.readAllBytes(path);
        String str = new String(fileBytes);
        Exam exam = new ExamBuilder().withExamSpecification(str).withTeacher(aTeacher).withDateInterval(new Date(1000,1,10),new Date (1000,1,11)).build();

        Student aStudent = new StudentBuilder().withMecanographicNumber(1,"2000")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();


        ExamResolution instance1 = new ExamResolution(1, 20,aStudent, exam);
        ExamResolution instance2 = new ExamResolution(1, 20, aStudent,exam);
        assertTrue(instance1.sameAs(instance2));
    }

    @Test
    public void ensureDiffExamResolutionsAreNotTheSame() throws NegativeParameterException, InvalidIdException, IOException, ParameterNullBlankException {
        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();
        Path path = Paths.get("files/testfiles/US2001/ExamAccepted.txt");
        byte[] fileBytes = Files.readAllBytes(path);
        String str = new String(fileBytes);
        Exam exam = new ExamBuilder().withExamSpecification(str).withTeacher(aTeacher).withDateInterval(new Date(1000,1,10),new Date (1000,1,11)).build();

        Student aStudent = new StudentBuilder().withMecanographicNumber(1,"2000")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();


        ExamResolution instance1 = new ExamResolution(1, 20,aStudent, exam);
        ExamResolution instance2 = new ExamResolution(2, 21, aStudent,exam);
        assertFalse(instance1.sameAs(instance2));
    }
}