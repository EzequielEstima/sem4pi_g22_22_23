package eapli.base.formativeexams.domain;

public class FormativeExamFactory {
    public FormativeExam build(long formativeExamId, String formativeStructure) {
        if (formativeExamId <= 0) {
            throw new IllegalArgumentException("The formative exam id must be greater than zero");
        }
        if (formativeStructure == null || formativeStructure.trim().isEmpty()) {
            throw new IllegalArgumentException("The formative exam structure must not be null or empty");
        }
        return new FormativeExam(new FormativeStructure(formativeStructure), new FormativeExamID(formativeExamId));
    }
}
