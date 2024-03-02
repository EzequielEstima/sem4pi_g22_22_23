package eapli.base.exams.application.services;

import eapli.base.exams.domain.ExamTitle;
import eapli.base.exams.repositories.ExamRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class ShowStudentExamViewService {

    public String showStudentExamView(String examTitle) {
        ExamRepository examRepo = PersistenceContext.repositories().examRepository();
        ExamTitle title = new ExamTitle(examTitle);
        return examRepo.ofIdentity(title).get().returnStudentViewOfExamSpecification();
    }
}
