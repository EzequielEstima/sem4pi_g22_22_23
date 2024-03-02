package eapli.base.exams.application.services;

import eapli.base.exams.domain.ExamResolution;
import eapli.base.exams.dto.ExamResolutionDTOExamTitleGrade;
import eapli.base.exams.dto.ExamResolutionDTOWithExamTitleGradeMapper;
import eapli.base.exams.repositories.ExamResolutionRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;

public class ListStudentGradesService {

    public List<ExamResolutionDTOExamTitleGrade> listMyGrades(){
        SystemUser systemUser = AuthzRegistry.authorizationService().session().get().authenticatedUser();
        ExamResolutionRepository examResolutionRepository = PersistenceContext.repositories().examResolutionRepository();
        List<ExamResolution> listExamResolution = examResolutionRepository.findStudentGrades(systemUser);
        List<ExamResolutionDTOExamTitleGrade> listExamResolutionDTO = new ArrayList<>();
        for (ExamResolution exam: listExamResolution) {
            listExamResolutionDTO.add(ExamResolutionDTOWithExamTitleGradeMapper.toDto(exam));
        }
        return listExamResolutionDTO;
    }

}
