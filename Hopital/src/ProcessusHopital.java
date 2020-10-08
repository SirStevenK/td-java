import java.io.IOException;

public class ProcessusHopital {
    private SyncSocket CA, CH;

    public ProcessusHopital(SyncSocket ca, SyncSocket ch) {
        CA = ca;
        CH = ch;
    }

    public void go() throws IOException {
        CH.receive("demandeRdvVs");
        System.out.println("dme");
        CH.send("code");
        CH.receive("typeMedecin");
        CA.send("code");
        CA.send("demandePlages");
        CA.receive("plagesLibres");
    }
}
