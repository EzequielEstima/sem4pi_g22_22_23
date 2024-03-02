import eapli.base.sharedBoard.SBPMessageFormat;
import eapli.framework.io.util.Console;
import presentation.MainMenu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

public class sharedBoardAppClient {
    public static void main(String[] args) {
        int option;
        do {
            System.out.println("Is the server local or remote?");
            System.out.println("1.Local");
            System.out.println("2.Remote");
             option = Console.readInteger("0.Exit");
            if (option > -1 && option < 3) {
                break;
            }
            System.out.println("ERROR: Please insert a correct option");
        }while (true);
        String ip = null;
        if(option != 0) {
            try{
                switch (option) {
                    case 1:
                        ip = InetAddress.getLocalHost().getHostAddress();
                        break;
                    case 2:
                        ip = Console.readLine("Please insert the ip of the Server:");
                        break;
                }
                final var clientIP = ip;
                Socket socket = new Socket(clientIP, 5000);
                System.out.println("Connected");
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                boolean error;
                do {
                    String username = Console.readLine("Username");
                    String password = Console.readLine("Password");
                    byte[] authRequest = SBPMessageFormat.createAuthRequest(username, password);
                    dos.writeUTF(new String(authRequest));

                    byte[] message = dis.readUTF().getBytes();

                    int[] arrayFormat = SBPMessageFormat.decodeFormat(message);
                    if (arrayFormat[SBPMessageFormat.CODE_OFFSET] == SBPMessageFormat.ACK_CODE) {
                        error = false;
                        final MainMenu menu = new MainMenu(socket);
                        menu.mainLoop();
                    } else {
                        error = true;
                        List<String> params = SBPMessageFormat.decodeParam(message);
                        System.out.println(params.get(0));
                    }
                } while (error);
            } catch (IOException e) {
                System.out.println("Could not connect to server. Please make sure it you running the server app.");
            }
        }
    }
}
