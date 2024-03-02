package eapli.base.app.sharedboardServer.Requests;

import eapli.base.board.application.ListAllBoardsIParticipateAndCanReadController;
import eapli.base.board.dto.BoardDTOWithTitle;
import eapli.base.sharedBoard.SBPMessageFormat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class ListAllBoardsIParticipateAndCanRead {

    public void ListAllBoardsIParticipateAndCanRead(String message, DataOutputStream outputStream) throws IOException {
        List<BoardDTOWithTitle> listBoardDTO = new ListAllBoardsIParticipateAndCanReadController().listAllBoardsIParticipateAndCanRead();
        outputStream.writeUTF(new String(SBPMessageFormat.createListBoardReceive(listBoardDTO)));
    }
}
