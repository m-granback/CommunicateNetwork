import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class SocketServer {
    private int secretNumber;
    public void initialize(int port) {

        // Den hemliga siffran som klienten ska gissa sig fram till
        Random random = new Random();
        secretNumber = random.nextInt(10) + 1;

        // Anv�nder med f�rdel try-with-resources h�r s� den st�nger resurserna automatiskt (.close())
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started, waiting for connection...");
            Socket socket = serverSocket.accept(); // H�r v�ntar den tills en klient ansluter
            System.out.println("Connection established");
            handleClient(socket);

        } catch (IOException e){
            System.out.println("Anslutningen br�ts");
        }
        System.out.println("Servern avslutas");
    }

    private void handleClient(Socket socket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));PrintWriter writer = new PrintWriter(socket.getOutputStream(), true))
        {
            String message;
            while ((message = reader.readLine()) != null){
                System.out.println("Fr�n klient: " + message);
                    processMessage(message, writer);
            }
        } catch (IOException e) {
            System.out.println("En error occurred: " + e.getMessage());
        }
    }

    private void processMessage(String message, PrintWriter writer) {
        if(Integer.parseInt(message) == secretNumber){
            writer.println("From server: You guessed the correct number!");
        } else {
            writer.println("From server: Nope... guess again...");
        }
        System.out.println("Received: " + message);
    }
}