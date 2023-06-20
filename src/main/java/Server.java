import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("server started");
        int port = 8084;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    out.println("Write your name");
                    String username = in.readLine();
                    System.out.println(username);
                    out.println("Are you child? (yes/no)");
                    String answer = in.readLine();
                    System.out.println(answer);
                    if (answer.equals("yes")) {
                        out.println(String.format("Welcome to the kids area, %s! Let's play!", username));
                    } else {
                        out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", username));
                    }
                }
            }
        }
    }
}
