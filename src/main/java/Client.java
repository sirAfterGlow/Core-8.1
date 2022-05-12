import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        final String host = "127.0.0.1";
        final int port = 8989;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out =
                     new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in =
                     new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("Сообщение от клиента");

            String responce = in.readLine();
            System.out.println(responce);

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
