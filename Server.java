import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    private Socket socket = null;
    private ServerSocket serverSocket =null;
    private InputStreamReader input = null;
    private BufferedReader bufferedReader;
    String message;
    private DataOutputStream output = null;

    public Server() {
        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("Server Started");

            while (true) {
                socket = serverSocket.accept();

                output = new DataOutputStream(socket.getOutputStream());
                output.writeUTF("Welcome to Server");

                input = new InputStreamReader(socket.getInputStream());
                bufferedReader = new BufferedReader(input);

                message = bufferedReader.readLine();

                System.out.println(message);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Server server = new Server();
    }
}