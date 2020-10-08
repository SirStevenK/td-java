import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;

public class SyncSocket extends Socket {
    private Socket s;
    private BufferedReader in;
    private PrintWriter out;

    public SyncSocket(Socket s) throws IOException {
        this.s = s;
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out = new PrintWriter(s.getOutputStream(), true);
    }

    public SyncSocket(String host, int port) throws IOException {
        this(new Socket(host, port));
    }

    public synchronized void send(String msg) throws IOException {
        out.println(msg);
        boolean response = false;
        System.out.println("Send - " +  msg);
        while(!response) {
            String r = in.readLine();
            if (r.equals(msg+"ACK")) {
                response = true;
                System.out.println("-> Done");
            }
        }
    }

    public synchronized String receive(String msg) throws IOException {
        System.out.println("Receive - " +  msg);
        while (true) {
            String m = in.readLine();
            if (m.equals(msg)) {
                out.println(m+"ACK");
                System.out.println("-> Done");
                return m;
            }
        }
    }

    public synchronized String receive(Collection<String> msgs) throws IOException {
        while (true) {
            String m = in.readLine();
            if (msgs.contains(m)) {
                out.println(m+"ACK");
                return m;
            }
        }
    }
}