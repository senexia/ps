import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int ascii = s.charAt(0);
        bw.write(Integer.toString(ascii));

        bw.flush();
        bw.close();
    }
}