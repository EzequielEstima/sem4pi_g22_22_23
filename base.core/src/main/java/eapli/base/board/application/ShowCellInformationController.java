package eapli.base.board.application;

import eapli.base.board.application.services.CellRequestInformationService;

public class ShowCellInformationController {
    public int getMaxColumn(String board) {
        CellRequestInformationService service = new CellRequestInformationService();
        return service.getMaxColumn(board);
    }

    public int getMaxRow(String board) {
        CellRequestInformationService service = new CellRequestInformationService();
        return service.getMaxRow(board);
    }
}
