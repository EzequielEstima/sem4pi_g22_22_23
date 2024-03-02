package eapli.base.app.user.console.presentation.enrollment;

import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.framework.visitor.Visitor;

public class CourseDTOWithIdTitlePrinter implements Visitor<CourseDTOWithIdTitle> {
    @Override
    public void visit(CourseDTOWithIdTitle visitee) {
        System.out.printf("%-20s | %-20s", visitee.courseIdentifier, visitee.courseTitle);
    }
}
