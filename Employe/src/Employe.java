import java.io.IOException;

public class Employe {
    public static void main(String[] args) throws IOException {
        SyncSocket CH, CT;
        SyncServerSocket ssh = new SyncServerSocket(9193);
        System.out.println("e1");
        CH = ssh.accept();
        System.out.println("e2");
        SyncServerSocket sst = new SyncServerSocket(9192);
        CT = sst.accept();
        System.out.println("e3");
        ProcessusEmploye e = new ProcessusEmploye(CH, CT);
        System.out.println("e4");
        e.go();
        System.out.println("e9");
    }
}
