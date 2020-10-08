import java.io.IOException;

public class Hopital {
    public static void main(String[] args) throws IOException {
        SyncSocket CH, CA;
        CH = new SyncSocket("10.253.250.148", 9193);
        System.out.println("h1");
        SyncServerSocket ss = new SyncServerSocket(9191);
        CA = ss.accept();
        System.out.println("h2");
        ProcessusHopital h = new ProcessusHopital(CA, CH);
        System.out.println("h3");
        h.go();
        System.out.println("h9");
    }
}
