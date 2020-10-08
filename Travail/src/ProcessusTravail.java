import java.io.IOException;

public class ProcessusTravail {
    private SyncSocket CA, CT;

    public ProcessusTravail(SyncSocket ca, SyncSocket ct) {
        CA = ca;
        CT = ct;
    }

    public void go() throws IOException {
        CT.receive("autorisation");
        System.out.println("here");
        CT.receive("code");
        System.out.println("here2");
        CA.receive("code");
        System.out.println("here3");
        CA.receive("demandePlages");
        String calcul = "";
        CA.send("plagesLibres");
    }
}
