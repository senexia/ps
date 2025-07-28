import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tot = Integer.parseInt(br.readLine());

        int lcnt = tot/4;
        String l = "long ";
        String s = l.repeat(lcnt);
        String res = s + "int";
        bw.write(res);

        bw.flush();
        bw.close();
    }
}