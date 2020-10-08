import java.io.IOException;

public class Travail {
    public static void main(String[] args) throws IOException {
        SyncSocket CA, CT;
        CA = new SyncSocket("10.253.250.148", 9191);
        System.out.println("t1");
        CT = new SyncSocket("10.253.250.148", 9192);
        System.out.println("t2");
        ProcessusTravail t = new ProcessusTravail(CA, CT);
        System.out.println("t3");
        t.go();
        System.out.println("t9");
    }
}
