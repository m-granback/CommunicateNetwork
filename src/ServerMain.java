public class ServerMain {
    public static void main(String[] args) {
        // Som server �r man den punkt man vill ansluta till
        // Servern liksom alla datorer har en ip-adress, och det �r till serverns ip-adress klienterna vill ansluta.
        // Servern har ett antal applikationer ig�ng och anv�nder sig av olika portar, dessa �r allts� upptagna och kan
        // ej anv�ndas f�r kommunikation. Portar upp till 1024 �r �ronm�rkta av operativsystemet.
        // Tips p� portar att anv�nda sig av 6667, 6668, 6669, 7000

        SocketServer socketServer = new SocketServer();
        socketServer.initialize(6667);

    }
}
