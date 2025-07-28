import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sums = br.readLine().split(" ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(Long.parseLong(sums[0]) + Long.parseLong(sums[1]) + Long.parseLong(sums[2])));
        bw.flush();
        bw.close();
    }
}