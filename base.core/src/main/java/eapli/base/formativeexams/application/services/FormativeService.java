package eapli.base.formativeexams.application.services;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.formativeexams.domain.FormativeExam;
import eapli.base.formativeexams.domain.FormativeExamFactory;
import eapli.base.formativeexams.repositories.FormativeExamRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.questionmanagement.domain.Question;
import eapli.base.questionmanagement.repositories.QuestionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FormativeService {
    private final VerifyGrammarService verifyGrammarService = new VerifyGrammarService();
    private final QuestionRepository questionRepository = PersistenceContext.repositories().questionRepository();
    private final FormativeExamRepository formativeExamRepository = PersistenceContext.
            repositories().formativeExamRepository();
    private final CourseRepository courseRepository = PersistenceContext.repositories().courseRepository();
    public boolean createFormativeExam(String type, int number, CourseDTOWithIdTitle courseDTO) {
        // TODO
        String matching = "#Matching Type",multipleChoice = "#Multiple Choice",shortAnswer = "#Short Answer",
                numerical = "#Numerical",selectMissingWords = "#Select Missing Words",trueOrFalse = "#True/False Question";

        if (type.equals(matching)||type.equals(multipleChoice)||type.equals(shortAnswer)||
                type.equals(numerical)||type.equals(selectMissingWords)||type.equals(trueOrFalse)) {

            Iterable<Question> questions = questionRepository.findAll();
            List<String> structureList = new ArrayList<>();

            if (questions == null || !questions.iterator().hasNext()) {
                throw new IllegalArgumentException("There are no questions in the system");
            }

            for (Question question : questions) {
                structureList.add(question.returnStructureToString());
            }

            List<String> matchingQuestionStructures = new ArrayList<>();
            for (String string : structureList) {
                if (string.startsWith(type)) {
                    matchingQuestionStructures.add(string);
                }
            }

            if (matchingQuestionStructures.isEmpty()){
                throw new IllegalArgumentException("There are no questions of the type " + type + " in the system");
            }

            // get random questions from matchingQuestionStructures with number as size

            Random random = new Random();
            List<Integer> randomNumbers = new ArrayList<>();

            int n=0;

            if(matchingQuestionStructures.size()<number){
                number = matchingQuestionStructures.size();
            }

            while (n < number) {
                int r = random.nextInt(matchingQuestionStructures.size());
                if (!randomNumbers.contains(r)) {
                    randomNumbers.add(r);
                    n++;
                }
            }

            // Generate a random integer between a specific range
            StringBuilder structureBuilder = new StringBuilder();
            for (int i = 0; i < number; i++) {
                structureBuilder.append(matchingQuestionStructures.get(randomNumbers.get(i))).append("\n");
            }
            String structure = structureBuilder.toString();

            if(verifyGrammarService.verifyGrammar(structure)){
                FormativeExamFactory formativeExamFactory = new FormativeExamFactory();
                FormativeExam formativeExam= formativeExamFactory.build(formativeExamRepository.count()+1,structure);
                Course course = courseRepository.findCourseById(courseDTO.courseIdentifier);
                course.addFormativeExam(formativeExam);
                formativeExamRepository.save(formativeExam);
                courseRepository.save(course);
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("The provided type is not matching with the possibles types of questions in the system");
    }

}
