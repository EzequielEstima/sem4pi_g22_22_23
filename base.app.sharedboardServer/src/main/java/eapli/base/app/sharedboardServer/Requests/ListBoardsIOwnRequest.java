package eapli.base.app.sharedboardServer.Requests;

import eapli.base.board.application.ListBoardsIOwnController;
import eapli.base.board.dto.BoardDTOWithTitle;
import eapli.base.sharedBoard.SBPMessageFormat;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class ListBoardsIOwnRequest {
    public void listBoardsIOwn(String message, DataOutputStream outputStream) throws IOException {
        List<BoardDTOWithTitle> boardDTOList = new ListBoardsIOwnController().listBoardsIOwn();
        byte[] boardIOwnListRequest = SBPMessageFormat.createListBoardReceive(boardDTOList);
        outputStream.writeUTF(new String(boardIOwnListRequest));
    }
}
