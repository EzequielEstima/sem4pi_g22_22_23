package eapli.base.sharedBoard;

import eapli.base.board.dto.BoardDTOWithTitle;
import eapli.base.board.dto.CellDTOWithColumnRowPostItCreator;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SBPMessageFormat {
    public static final int DEFAULT_VERSION = 1;
    public static final int COMMTEST_CODE = 0;
    public static final int DISCONN_CODE = 1;
    public static final int ACK_CODE = 2;
    public static final int ERR_CODE = 3;
    public static final int AUTH_CODE = 4;
    public static final int LIST_BOARD_I_OWN_SEND = 5;
    public static final int LIST_BOARD = 6;
    public static final int SHARE_BOARD_CODE = 7;
    public static final int ARCHIVE_BOARD_CODE = 8;
    public static final int BOARD_INFO_CODE = 9;
    public static final int VIEW_IN_REAL_TIME_CODE = 10;
    public static final int LIST_BOARD_I_PARTICIPATE_SEND = 11;
    public static final int LIST_BOARD_I_PARTICIPATE_RCV = 12;
    public static final int NUMBER_OF_CELLS_REQUEST_SEND = 13;
    public static final int NUMBER_OF_CELLS_REQUEST_RCV = 14;
    public static final int POST_IT_REQUEST_SEND = 15 ;
    public static final int LIST_ALL_BOARDS_I_PARTICIPATE_AND_CAN_READ = 16;
    public static final int HISTORY_OF_UPDATES_CODE = 17;
    public static final int UNDO_LAST_CHANGE_POST_IT_REQUEST = 18;
    public static final int TASK_LIST_CODE = 19;
    public static final int CHANGE_POST_IT_CONTENT = 20;
    public static final int CHANGE_POST_IT_POSITION = 21;
    public static final int LIST_NOTIFICATION_SEND = 22;
    public static final int LIST_NOTIFICATION_RECEIVE = 23;

    public static final int VERSION_OFFSET = 0;
    public static final int CODE_OFFSET = 1;
    public static final int D_LENGTH1_OFFSET = 2;
    public static final int D_LENGTH2_OFFSET = 3;
    public static final int DATA_OFFSET = 4;

    public static byte[] createAuthRequest(String username, String password){
        return encodeRequest(AUTH_CODE, username + "," + password);
    }

    public static byte[] createCommRequest(){
        return encodeRequest(COMMTEST_CODE, "");
    }

    public static byte[] creteErrorRequest(String errorMessage){
        return encodeRequest(ERR_CODE, errorMessage);
    }

    public static byte[] createAcknowledgeRequest(){
        return encodeRequest(ACK_CODE, "");
    }

    public static byte[] createDisconnRequest(){
        return encodeRequest(DISCONN_CODE, "");
    }

    public static byte[] createListBoardIOwnRequestSend(){
        return encodeRequest(LIST_BOARD_I_OWN_SEND, "");
    }

    public static byte[] createListBoardReceive(List<BoardDTOWithTitle> boardDTOList){
        StringBuilder strBuilder = getBoardData(boardDTOList);
        if(strBuilder.length() == 0){
            return encodeRequest(LIST_BOARD, "");
        }
        return encodeRequest(LIST_BOARD, strBuilder.toString());
    }

    public static byte[] createListBoardIParticipateRequestSend(){
        return encodeRequest(LIST_BOARD_I_PARTICIPATE_SEND, "");
    }
    public static byte[] createListAllBoardsIParticipateAndCanRead(){
        return encodeRequest(LIST_ALL_BOARDS_I_PARTICIPATE_AND_CAN_READ,"");
    }

    public static byte[] createListBoardIParticipateRequestReceive(List<BoardDTOWithTitle> boardDTOList){
        StringBuilder strBuilder = getBoardData(boardDTOList);
        if(strBuilder.length() == 0){
            return encodeRequest(LIST_BOARD_I_PARTICIPATE_RCV, "");
        }
        return encodeRequest(LIST_BOARD_I_PARTICIPATE_RCV, strBuilder.toString());
    }

    private static StringBuilder getBoardData(List<BoardDTOWithTitle> boardDTOList) {
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 0; i < boardDTOList.size(); i++){
            strBuilder.append(boardDTOList.get(i).toString());
            if(i < boardDTOList.size() - 1){
                strBuilder.append(',');
            }
        }
        return strBuilder;
    }

    public static byte[] createShowNumberOfCellsRequestSend(String board) {
        return encodeRequest(NUMBER_OF_CELLS_REQUEST_SEND, board);
    }

    public static byte[] createShowNumberOfCellsRequestRCV(int maxColumn, int maxRow) {
        return encodeRequest(NUMBER_OF_CELLS_REQUEST_RCV, maxColumn + "," + maxRow);
    }

    public static byte[] createPostItRequest(String board, String data, int column, int row) {
        return encodeRequest(POST_IT_REQUEST_SEND, board + "," + data + "," + column + "," + row);
    }

    public static byte[] createChangePostItContentRequest(String board, String content, int row, int column) {
        return encodeRequest(CHANGE_POST_IT_CONTENT, board + "," + row + "," + column  + "," + content);
    }
    public static byte[] createChangePostItPositionRequest(String board, int oldRow, int oldColumn, int newRow, int newColumn) {
        return encodeRequest(CHANGE_POST_IT_POSITION, board + "," + oldRow + "," + oldColumn  + "," + newRow + "," + newColumn);
    }

    public static byte[] createViewInRealTimeRequest(String boardId){
        return encodeRequest(VIEW_IN_REAL_TIME_CODE,boardId);
    }


    public static byte[] createBoardInfoRequest(List<CellDTOWithColumnRowPostItCreator> listCellDTOWithColumnRowPostItCreator){
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 0; i < listCellDTOWithColumnRowPostItCreator.size(); i++){
            strBuilder.append(listCellDTOWithColumnRowPostItCreator.get(i).toString());
            if(i < listCellDTOWithColumnRowPostItCreator.size() - 1){
                strBuilder.append(",;,");
            }
        }
        if(strBuilder.length() == 0){
            return encodeRequest(BOARD_INFO_CODE, "");
        }

        return encodeRequest(BOARD_INFO_CODE,strBuilder.toString());
    }


    public static byte[] createArchiveBoardRequest(String boardTitle){
        return encodeRequest(ARCHIVE_BOARD_CODE, boardTitle);
    }

    public static byte[] createShareBoardRequest(String boardTitle, String email, String permission){
        return encodeRequest(SHARE_BOARD_CODE, boardTitle + ","+ email + "," + permission);
    }

    public static byte[] createHistoryOfUpdatesRequest(String boardTitle){
        return encodeRequest(HISTORY_OF_UPDATES_CODE, boardTitle);
    }

    public static byte[] createTaskListRequest(List<String> taskList){
        StringBuilder stringBuilder = createTaskList(taskList);

        if(stringBuilder.length()==0){
            return encodeRequest(TASK_LIST_CODE, "");
        }

        return encodeRequest(TASK_LIST_CODE, stringBuilder.toString());
    }
    public static byte[] createNotificationListSendRequest(){
        return encodeRequest(LIST_NOTIFICATION_SEND, "");
    }

    public static byte[] createNotificationListReceiveRequest(List<String> notificationList){
        if(notificationList.isEmpty()) return encodeRequest(LIST_NOTIFICATION_RECEIVE, "");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < notificationList.size(); i++){
            stringBuilder.append(notificationList.get(i));
            if(i != notificationList.size()-1){
                stringBuilder.append(",");
            }
        }
        return encodeRequest(LIST_NOTIFICATION_RECEIVE, stringBuilder.toString());
    }

    public static StringBuilder createTaskList(List<String> taskList){
        StringBuilder strBuilder = new StringBuilder();

        for(int i = 0; i < taskList.size(); i++){
            strBuilder.append(taskList.get(i));
            if(i < taskList.size() - 1){
                strBuilder.append(',');
            }
        }

        return strBuilder;
    }

    public static byte[] encodeRequest(int code, String data){
        //Data values
        byte[] dataBytes = data.getBytes(StandardCharsets.UTF_8);

        byte[] request = new byte[DATA_OFFSET+dataBytes.length];

        int length1 = data.length()%256;
        int length2=data.length()/256;

        request[VERSION_OFFSET] = (byte) DEFAULT_VERSION;
        request[CODE_OFFSET] = (byte) code;
        request[D_LENGTH1_OFFSET] = (byte) length1;
        request[D_LENGTH2_OFFSET] = (byte) length2;

        for(int i = 0; i<data.getBytes().length; i++){
            request[DATA_OFFSET+i] = dataBytes[i];
        }

        return request;
    }

    public static List<List<String>> decodeDTO(byte[] request){
        List<String> params = decodeParam(request);
        List<List<String>> finalList = new ArrayList<>();
        List<String> dtoParams = new ArrayList<>();
        for(String string : params){
            if(!string.equals(";")){
                dtoParams.add(string);
            }else{
                finalList.add(dtoParams);
                dtoParams = new ArrayList<>();
            }
        }
        if(!dtoParams.isEmpty()){
            finalList.add(dtoParams);
        }
        return finalList;
    }

    public static List<String> decodeParam(byte[] request){
        String decodedString = new String(request, StandardCharsets.UTF_8);
        decodedString = decodedString.substring(4);
        List<String> paramList = List.of(decodedString.split(","));
        if (paramList.size()== 1 && paramList.get(0).equals("")){return new ArrayList<>();}
        return paramList;
    }

    public static int[] decodeFormat(byte[] request){
        int [] format = new int[DATA_OFFSET];
        for(int i = 0; i < DATA_OFFSET; i++){
            format[i] = request[i];
        }
        return format;
    }

    public static byte[] createUndoLastChangePostItRequest(String board, int selectedColumn, int selectedRow) {
        return encodeRequest(UNDO_LAST_CHANGE_POST_IT_REQUEST, board + "," + selectedColumn + "," + selectedRow);
    }
}
