package eapli.base.question.domain;

import eapli.base.questionmanagement.domain.VerifyQuestionService;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class VerifyQuestionServiceTest {
    @Test(expected = IllegalArgumentException.class)
    public void verifyMultipleChoiceQuestionWrongTest() throws IOException {
        VerifyQuestionService service = new VerifyQuestionService();
        Path path = Paths.get("files/testfiles/US2007/wrongQuestion.txt");
        byte[] fileBytes = Files.readAllBytes(path);
        service.verifyQuestion(new String(fileBytes));
    }
    @Test
    public void verifyAcceptsMultipleChoiceQuestionTest() throws IOException {
        VerifyQuestionService service = new VerifyQuestionService();
        Path path = Paths.get("files/testfiles/US2007/multipleChoiceQuestionCorrect.txt");
        byte[] fileBytes = Files.readAllBytes(path);
        assertTrue(service.verifyQuestion(new String(fileBytes)));
    }
    @Test
    public void verifyAcceptsMultipleChoiceWithMultiAnswersTest() throws IOException {
        VerifyQuestionService service = new VerifyQuestionService();
        Path path = Paths.get("files/testfiles/US2007/matchingMultipleChoiceQuestionCorrect.txt");
        byte[] fileBytes = Files.readAllBytes(path);
        assertTrue(service.verifyQuestion(new String(fileBytes)));
    }
    @Test
    public void verifyAcceptsTypeQuestionTest() throws IOException {
        VerifyQuestionService service = new VerifyQuestionService();
        Path path = Paths.get("files/testfiles/US2007/matchingTypeQuestionCorrect.txt");
        byte[] fileBytes = Files.readAllBytes(path);
        assertTrue(service.verifyQuestion(new String(fileBytes)));
    }

    @Test
    public void verifyAcceptsShortAnswerTest() throws IOException{
        VerifyQuestionService service = new VerifyQuestionService();
        Path path = Paths.get("files/testfiles/US2007/matchingShortAnswerQuestionCorrect.txt");
        byte[] fileBytes = Files.readAllBytes(path);
        assertTrue(service.verifyQuestion(new String(fileBytes)));
    }

    @Test
    public void verifyAcceptsNumericalQuestionTest() throws IOException{
        VerifyQuestionService service = new VerifyQuestionService();
        Path path = Paths.get("files/testfiles/US2007/matchingNumericalQuestionCorrect.txt");
        byte[] fileBytes = Files.readAllBytes(path);
        assertTrue(service.verifyQuestion(new String(fileBytes)));
    }

    @Test
    public void verifyAcceptsTrueFalseQuestionTest() throws IOException{
        VerifyQuestionService service = new VerifyQuestionService();
        Path path = Paths.get("files/testfiles/US2007/matchingTrueFalseQuestionCorrect.txt");
        byte[] fileBytes = Files.readAllBytes(path);
        assertTrue(service.verifyQuestion(new String(fileBytes)));
    }

    @Test
    public void verifyAcceptsMissingWordsQuestionTest() throws IOException{
        VerifyQuestionService service = new VerifyQuestionService();
        Path path = Paths.get("files/testfiles/US2007/matchingSelectMissingWordsQuestionCorrect.txt");
        byte[] fileBytes = Files.readAllBytes(path);
        assertTrue(service.verifyQuestion(new String(fileBytes)));
    }
}
