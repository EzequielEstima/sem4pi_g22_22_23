package presentation.viewInRealTime;

import eapli.base.sharedBoard.SBPMessageFormat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class ViewInRealTimeRequest extends Thread {


    private String baseFolder;
    private Socket sock;

    private DataInputStream inS;
    private DataOutputStream outS;
    private String boardTitle;

    private Socket socketServer;

    public ViewInRealTimeRequest (Socket s, String f, String boardTitle, Socket server){
        baseFolder=f;
        sock=s;
        this.boardTitle = boardTitle;
        this.socketServer = server;
    }
    public void run() {
        var clientIp = socketServer.getInetAddress().getHostAddress();
        DataOutputStream dosServer;
        DataInputStream disServer;
        try {
            Socket socketServerClone = new Socket(clientIp, 5000);

            try {
                dosServer= new DataOutputStream(socketServerClone.getOutputStream());
                disServer = new DataInputStream(socketServerClone.getInputStream());
                outS = new DataOutputStream(sock.getOutputStream());
                inS = new DataInputStream(sock.getInputStream());

                try {
                    HTTPmessage request = new HTTPmessage(inS);
                    HTTPmessage response = new HTTPmessage();
                    String content =  null;

                    if(request.getMethod().equals("GET")) {
                        if (request.getURI().equals("/table")) {
                            dosServer.writeUTF(new String(SBPMessageFormat.createViewInRealTimeRequest(boardTitle)));
                            String boardInfo = disServer.readUTF();
                            int[] format = SBPMessageFormat.decodeFormat(boardInfo.getBytes());
                            if (format[1] == SBPMessageFormat.BOARD_INFO_CODE) {
                                List<List<String>> boardCellsInfo = SBPMessageFormat.decodeDTO(boardInfo.getBytes());
                                content = getTableInHTML(boardCellsInfo,boardTitle);
                            }else if (format[1] == SBPMessageFormat.ERR_CODE){
                                System.out.println(SBPMessageFormat.decodeParam(boardInfo.getBytes()));
                            }
                            if (content != null) {
                                response.setContentFromString(content, "text/html");
                                response.setResponseStatus("200 Ok");
                            } else {
                                response.setContentFromString(
                                        "<span id=\"loading\">Error loading content, trying again...</span>", "text/html");
                                response.setResponseStatus("404 Not Found");
                            }
                        } else {
                            String fullname = baseFolder/* + "/"*/;
                            if (request.getURI().equals("/")) fullname += "/index.html";
                            else fullname += request.getURI();

                            if (response.setContentFromFile(fullname)) {
                                response.setResponseStatus("200 Ok");
                            } else {
                                response.setContentFromString(
                                        "<html><body><h1>404 File not found</h1></body></html>", "text/html");
                                response.setResponseStatus("404 Not Found");
                            }
                        }
                        response.send(outS);
                    }

                }catch(IOException ex) {
                    System.out.println("Thread error when reading request");
                }

            }
            catch(IOException ex) { System.out.println("Thread error on data streams creation"); }

            try {
                sock.close();
                socketServerClone.close();
            }
            catch(IOException ex) {
                System.out.println("CLOSE IOException");
            }
        } catch (IOException e) {
            System.out.println("Error when communicating to the server");
        }
    }

    private static synchronized String getTableInHTML(List<List<String>>  boardCellsInfo, String boardTitle) {

        int maxRow = getMaxRowNumber(boardCellsInfo);
        int maxCol = getMaxColumnNumber(boardCellsInfo);
        StringBuilder html = new StringBuilder();
        html.append("<h1>" + boardTitle + "</h1>\n");
        html.append("<table>\n<tr>\n<th></th>\n");
        for (int col = 1; col <= maxCol; col++) {
            String colTitle = getColumnTitle(boardCellsInfo, col);
            html.append("<th>").append(colTitle).append("</th>\n");
        }
        html.append("</tr>\n");

        for (int row = 1; row <= maxRow; row++) {
            String rowTitle = getRowTitle(boardCellsInfo, row);
            html.append("<tr>\n");
            html.append("<th>").append(rowTitle).append("</th>\n");
            for (int col = 1; col <= maxCol; col++) {
                String cellData = getCellData(boardCellsInfo, row, col);
                html.append("<td>").append(cellData).append("</td>\n");
            }
            html.append("</tr>\n");
        }
        html.append("</table>");
        return html.toString();
    }

    private static int getMaxRowNumber(List<List<String>> boardCellsInfo) {
        int maxRow = 0;
        for (List<String> row : boardCellsInfo) {
            if (!row.isEmpty()) {
                String s = row.get(0).replaceAll("[^0-9]", "");
                int rowNumber = Integer.parseInt(s);
                if (rowNumber > maxRow) {
                    maxRow = rowNumber;
                }
            }
        }
        return maxRow;
    }

    private static int getMaxColumnNumber(List<List<String>> boardCellsInfo) {
        int maxCol = 0;
        for (List<String> row : boardCellsInfo) {
            if (!row.isEmpty()) {
                int colNumber = Integer.parseInt(row.get(2).replaceAll("[^0-9]", ""));
                if (colNumber > maxCol) {
                    maxCol = colNumber;
                }
            }
        }
        return maxCol;
    }

    private static String getColumnTitle(List<List<String>> boardCellsInfo, int col) {
        for (List<String> rowData : boardCellsInfo) {
            int colNum = Integer.parseInt(rowData.get(2).replaceAll("[^0-9]", ""));
            if (colNum == col) {
                if (rowData.get(3).isEmpty())return "" + col;
                return rowData.get(3);
            }
        }
        return ""+col;
    }

    private static String getRowTitle(List<List<String>> data, int row) {
        for (List<String> rowData : data) {
            int rowNum = Integer.parseInt(rowData.get(0).replaceAll("[^0-9]", ""));
            if (rowNum == row) {
                if (rowData.get(1).isEmpty()) return "" + row;
                return rowData.get(1);
            }
        }
        return ""+row;
    }

    public static String getCellData(List<List<String>> data, int row, int col) {
        for (List<String> rowData : data) {
            int rowNum = Integer.parseInt(rowData.get(0).replaceAll("[^0-9]", ""));
            int colNum = Integer.parseInt(rowData.get(2).replaceAll("[^0-9]", ""));
            if (rowNum == row && colNum == col) {
                if(rowData.get(4).endsWith(".jpg") || rowData.get(4).endsWith(".png")){
                    return "<img src=\" "+ rowData.get(4)+ "\" alt=\"Image Not Found\" width=\"300\" height=\"200\"> " +
                            "<br><br><span class=\"small\";>Name: " + rowData.get(7) + "<br>Email: " + rowData.get(6) +
                            "<br>Time:" + rowData.get(5)+"</span>";
                }else if (!rowData.get(4).isBlank() && !rowData.get(4).isEmpty()){
                    return rowData.get(4) +
                            "<br><br><span class=\"small\";>Name: " + rowData.get(7) + "<br>Email: " + rowData.get(6) +
                            "<br>Time:" + rowData.get(5)+" </span>";
                }
                return rowData.get(4);
            }
        }
        return "";
    }


}
