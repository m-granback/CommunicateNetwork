public class ServerMain {
    public static void main(String[] args) {
        // Som server är man den punkt man vill ansluta till
        // Servern liksom alla datorer har en ip-adress, och det är till serverns ip-adress klienterna vill ansluta.
        // Servern har ett antal applikationer igång och använder sig av olika portar, dessa är alltså upptagna och kan
        // ej användas för kommunikation. Portar upp till 1024 är öronmärkta av operativsystemet.
        // Tips på portar att använda sig av 6667, 6668, 6669, 7000

        SocketServer socketServer = new SocketServer();
        socketServer.initialize(6667);

    }
}
