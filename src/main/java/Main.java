import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        final int port = 8989;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Сервер запущен");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                System.out.println("Установленно новое соединение");
                final String text = in.readLine();
                out.println("Привет! Получили от тебя текст: " + text + ". Порт: " + clientSocket.getPort());

            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
