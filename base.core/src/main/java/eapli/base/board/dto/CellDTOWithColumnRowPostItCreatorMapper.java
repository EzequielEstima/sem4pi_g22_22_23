package eapli.base.board.dto;

import eapli.base.board.domain.Cell;
import eapli.base.usermanagement.domain.Person;

public class CellDTOWithColumnRowPostItCreatorMapper {

    public static CellDTOWithColumnRowPostItCreator toDTO(Cell cell, Person person){
        CellDTOWithColumnRowPostItCreatorBuilder builder = new CellDTOWithColumnRowPostItCreatorBuilder();
        if (person != null) {
            return builder.withRowTitle(cell.returnRowTitleString()).withRowIdentifier(cell.returnRowIdentifierString())
                    .withColumnTitle(cell.returnColumnTitleString()).withColumnIdentifier(cell.returnColumnIdentifierString())
                    .withContent(cell.returnPostItContentString()).withDate(cell.returnPostItDateString()).
                    withName(person.returnShortNameString()).withEmail(person.returnEmailString()).build();
        }
            return builder.withRowTitle(cell.returnRowTitleString()).withRowIdentifier(cell.returnRowIdentifierString())
                    .withColumnTitle(cell.returnColumnTitleString()).withColumnIdentifier(cell.returnColumnIdentifierString())
                    .withContent(cell.returnPostItContentString()).withDate(cell.returnPostItDateString()).
                    withName(" ").withEmail("").build();
    }

}
