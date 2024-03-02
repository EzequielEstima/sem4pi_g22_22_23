package eapli.base.app.sharedboardServer.Requests;

import eapli.base.board.application.BoardInformationController;
import eapli.base.board.dto.CellDTOWithColumnRowPostItCreator;
import eapli.base.sharedBoard.SBPMessageFormat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class ViewInRealTimeRequest {

    public void viewInRealTime(String message, DataOutputStream outputStream) throws IOException {
        List<String> param = SBPMessageFormat.decodeParam(message.getBytes());
        try{
            List<CellDTOWithColumnRowPostItCreator> listCellDTOWithColumnRowPostItCreator =
                    new BoardInformationController().getBoardInformation(param.get(0));
            outputStream.writeUTF(
                    new String(SBPMessageFormat.createBoardInfoRequest(listCellDTOWithColumnRowPostItCreator)));
        }catch (Exception e){
            outputStream.writeUTF(
                    new String(SBPMessageFormat.creteErrorRequest(e.getMessage())));
        }
    }
}
