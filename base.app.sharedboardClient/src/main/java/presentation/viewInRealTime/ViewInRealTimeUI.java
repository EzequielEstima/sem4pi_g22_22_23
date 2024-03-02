package presentation.viewInRealTime;

import eapli.base.sharedBoard.SBPMessageFormat;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import presentation.shareBoard.StringPrinter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class ViewInRealTimeUI extends AbstractUI {

    private final Socket socketServer;

    static private final String BASE_FOLDER="www";

    private ServerSocket sock;

    public ViewInRealTimeUI(Socket socket){
        this.socketServer = socket;
    }
    @Override
    protected boolean doShow() {
        DataOutputStream dosServer;
        DataInputStream disServer;
        try {
            dosServer= new DataOutputStream(socketServer.getOutputStream());
            dosServer.writeUTF(new String(SBPMessageFormat.createListAllBoardsIParticipateAndCanRead()));
            disServer = new DataInputStream(socketServer.getInputStream());
            String message = disServer.readUTF();
            if(SBPMessageFormat.decodeFormat(message.getBytes())[SBPMessageFormat.CODE_OFFSET] == SBPMessageFormat.LIST_BOARD) {
                List<String> boardList = SBPMessageFormat.decodeParam(message.getBytes());
                if (!boardList.isEmpty()) {
                    SelectWidget<String> selected = new SelectWidget<>("Select the board.", boardList, new StringPrinter());
                    selected.show();
                    if (selected.selectedOption() != 0) {
                        String board = selected.selectedElement();
                        int port;
                        int i = 1;
                        InetAddress addrs[];
                        Socket cliSock;
                        while (true) {
                            String hostName = InetAddress.getLocalHost().getHostName();
                            addrs = InetAddress.getAllByName(hostName);
                            System.out.println("Address Available to use: ");
                            for (InetAddress add: addrs) {
                                System.out.println(i +". " +add.getHostAddress());
                                i++;
                            }
                            do {
                                i = Console.readInteger("Select address: ");
                            } while (i < 1 || i > addrs.length);
                            port = Console.readInteger("Insert the port:");
                            if (port == socketServer.getPort()){
                                System.out.println("This port is not valid!!!\n\n");
                            }else{
                                break;
                            }
                        }
                        try {
                            sock = new ServerSocket(port,50,addrs[i-1]);
                            System.out.println("Connecting to http://" + sock.getInetAddress().getHostAddress() + ":" + sock.getLocalPort());
                        } catch (IOException ex) {
                            System.out.println("Server failed to open local port " + port);
                            return false;
                        }

                        while (true) {
                            try {
                                cliSock = sock.accept();

                            } catch (IOException e) {

                                System.out.println("Server error - " + e.getMessage());

                                return false;
                            }
                            ViewInRealTimeRequest request = new ViewInRealTimeRequest(cliSock, BASE_FOLDER,board, socketServer);
                            request.start();
                        }
                    }
                }else{
                    System.out.println("Currently you are not participating in any board");
                }
            }
        } catch (IOException e) {
            System.out.printf("Your connection to the server has been lost.\n\n");
        }
        return false;
    }

    @Override
    public String headline() {
        return "View Board in Real Time";
    }
}
