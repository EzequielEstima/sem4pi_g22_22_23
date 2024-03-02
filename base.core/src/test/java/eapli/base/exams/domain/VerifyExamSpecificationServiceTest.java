package eapli.base.exams.domain;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class VerifyExamSpecificationServiceTest {

    @Test
    public void verifyExamSpecificationAccepts() throws IOException {
        VerifyExamSpecificationService service = new VerifyExamSpecificationService();
        Path path = Paths.get("files/testfiles/US2001/ExamAccepted.txt");
        byte[] fileBytes = Files.readAllBytes(path);
        assertTrue(service.verifyExamSpecification(new String(fileBytes)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyExamSpecificationFail() throws IOException {
        VerifyExamSpecificationService service = new VerifyExamSpecificationService();
        Path path = Paths.get("files/testfiles/US2001/ExamFailed.txt");
        byte[] fileBytes = Files.readAllBytes(path);
        service.verifyExamSpecification(new String(fileBytes));
    }
}