public class ClientMain {


    public static void main(String[] args) {

       SocketClient socketClient = new SocketClient();

        // Som klient beh�ver man veta 2 saker: vilken ip-adress har servern jag vill ansluta till och vilken port ska anv�ndas?
        // I detta fall �r servern och klienten p� samma adress: localhost eller 127.0.0.1 och det �r dessa ni kan anv�nda er av.
        // Porten ska matchas med det som servern angivit, i detta fall port 6667
       socketClient.initialize("localhost", 6667);
    }
}
