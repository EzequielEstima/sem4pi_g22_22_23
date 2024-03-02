package eapli.base.exams.domain;


import eapli.base.usermanagement.domain.Teacher;
import eapli.base.usermanagement.domain.builder.TeacherBuilder;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import static org.junit.Assert.*;

public class ExamTest {


    @Test(expected = IllegalArgumentException.class)
    public void ensureThatExamSpecificationCannotBeCreateWithNullValues() {
        Exam test= new ExamBuilder().build();
    }

    @Test
    public void ensureExamsEqualsPassesForTheSameExamTitle() throws IOException {
        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();

        Path path = Paths.get("files/testfiles/US2001/ExamAccepted.txt");
        byte[] fileBytes = Files.readAllBytes(path);
        String str = new String(fileBytes);

        Exam exam = new ExamBuilder().withExamSpecification(str).withTeacher(aTeacher).withDateInterval(new Date(1000,1,10),new Date (1000,1,11)).build();
        Exam anotherExam = new ExamBuilder().withExamSpecification(str).withTeacher(aTeacher).withDateInterval(new Date(1000,1,10),new Date (1000,1,11)).build();
        assertTrue(exam.equals(anotherExam));
    }

    @Test
    public void ensureExamsEqualsFailsForDifferenteExamTitle() throws IOException {

        Path path = Paths.get("files/testfiles/US2001/ExamAccepted.txt");
        byte[] fileBytes = Files.readAllBytes(path);
        path = Paths.get("files/testfiles/US2001/ExamAccepted2.txt");
        byte[] fileBytes2 = Files.readAllBytes(path);

        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();
        Exam exam = new ExamBuilder().withExamSpecification(new String(fileBytes)).withTeacher(aTeacher).withDateInterval(new Date(1000,1,10),new Date (1000,1,11)).build();
        Exam anotherExam = new ExamBuilder().withExamSpecification(new String(fileBytes2)).withTeacher(aTeacher).withDateInterval(new Date(1000,1,10),new Date (1000,1,11)).build();

        assertFalse(exam.equals(anotherExam));
    }

    @Test
    public void ensureExamsEqualsAreTheSameForTheSameInstance() {
        Exam exam = new Exam();

        assertTrue(exam.equals(exam));
    }

    @Test
    public void ensureExamsEqualsFailsForDifferenteObjectTypes(){
        Exam exam = new Exam();
        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();
        assertFalse(exam.equals(aTeacher));
    }

    @Test
    public void ensureExamsIsTheSameAsItsInstance() throws IOException {

        Path path = Paths.get("files/testfiles/US2001/ExamAccepted.txt");
        byte[] fileBytes = Files.readAllBytes(path);

        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();
        Exam exam = new ExamBuilder().withExamSpecification(new String(fileBytes)).withTeacher(aTeacher).withDateInterval(new Date(1000,1,10),new Date (1000,1,11)).build();

        assertTrue(exam.sameAs(exam));
    }

    @Test
    public void ensureTwoExamsWithDifferentExamTitleAreNotTheSame() throws IOException {

        Path path = Paths.get("files/testfiles/US2001/ExamAccepted.txt");
        byte[] fileBytes = Files.readAllBytes(path);
        path = Paths.get("files/testfiles/US2001/ExamAccepted2.txt");
        byte[] fileBytes2 = Files.readAllBytes(path);

        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();
        Exam exam = new ExamBuilder().withExamSpecification(new String(fileBytes)).withTeacher(aTeacher).withDateInterval(new Date(1000,1,10),new Date (1000,1,11)).build();
        Exam anotherExam = new ExamBuilder().withExamSpecification(new String(fileBytes2)).withTeacher(aTeacher).withDateInterval(new Date(1000,1,10),new Date (1000,1,11)).build();

        assertFalse(exam.sameAs(anotherExam));
    }


}