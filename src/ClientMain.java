public class ClientMain {


    public static void main(String[] args) {

       SocketClient socketClient = new SocketClient();

        // Som klient behöver man veta 2 saker: vilken ip-adress har servern jag vill ansluta till och vilken port ska användas?
        // I detta fall är servern och klienten på samma adress: localhost eller 127.0.0.1 och det är dessa ni kan använda er av.
        // Porten ska matchas med det som servern angivit, i detta fall port 6667
       socketClient.initialize("localhost", 6667);
    }
}
