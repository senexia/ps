import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String r1 = ":fan::fan::fan:";
        String r2 = ":fan::" + br.readLine() + "::fan:";
        String r3 = ":fan::fan::fan:";
        bw.write(r1 + "\n");
        bw.write(r2 + "\n");
        bw.write(r3 + "\n");
        bw.flush();
        bw.close();
    }
}