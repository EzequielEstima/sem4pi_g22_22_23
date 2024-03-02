package eapli.base.infrastructure.bootstrapers;

import eapli.base.board.application.CreateBoardController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardBootstrapperBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersBootstrapperBase.class);

    final CreateBoardController createBoardController = new CreateBoardController();

    protected boolean createBoardBaseBootstrap(final String boardTitle,final int rowNumber,final int columnNumber) {
        return createBoardController.createBoard(boardTitle, rowNumber, columnNumber);
    }

}
