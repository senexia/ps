import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cakes1 = Integer.parseInt(br.readLine());
        int cakes2 = Integer.parseInt(br.readLine());
        int residue = cakes1*8 + cakes2*3 - 28;
        bw.write(Integer.toString(residue));
        bw.flush();
        bw.close();
    }
}