import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    public SocketClient() {

    }
    public void initialize(String ipAdress, int port){


        // Använder med fördel try-with-resources här så den stänger resurserna automatiskt (.close())
        System.out.println("Client started, connecting...");
        try (Socket socket = new Socket(ipAdress, port)){
            System.out.println("Connected to server!");
            handleServerCommunication(socket);
            PrintWriter write = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true){
                String incomingMessage = reader.readLine();
                if(incomingMessage.equals("Du gissade rätt!")){
                    System.out.println("Server disconnected");
                    break;
                }
                System.out.println(incomingMessage);
                Scanner scanner = new Scanner(System.in);
                System.out.print("Gissa ett ord: ");
                write.println(scanner.nextLine());
            }

        } catch (IOException e){
            System.out.println("Misslyckades");
        }
    }

    private void handleServerCommunication(Socket socket) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                Scanner scanner = new Scanner(System.in)
        ){
            String message = "";
            System.out.println("Make a guess, an integer between 1 and 10");
            int guess = scanner.nextInt();
            while (true){
                Thread.sleep(100);
                if(checkServerMessage(reader)){
                    System.out.println("Exiting");
                }
                System.out.print("Your guess: ");
                guess = scanner.nextInt();
                writer.println(guess);
            }


        } catch (InterruptedException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private boolean checkServerMessage(BufferedReader reader) {
        try {
            if(reader.ready()){
                String messageFromServer = reader.readLine();
                if(messageFromServer.equals("correct")){
                    System.out.println("Lokalt: servern meddelade att det var korrekt gissning!");
                    return true;
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
