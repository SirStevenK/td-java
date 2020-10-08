import java.io.IOException;

public class ProcessusEmploye {
    private SyncSocket CH, CT;

    public ProcessusEmploye(SyncSocket ch, SyncSocket ct) {
        CH = ch;
        CT = ct;
    }

    public void go() throws IOException {
        CH.send("demandeRdvVs");
        CH.receive("code");
        CH.send("typeMedecin");
        CH.receive("heureDateRdvVs");
        CT.send("autorisation");
        CT.send("code");
    }
}
