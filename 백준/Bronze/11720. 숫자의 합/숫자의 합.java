import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] sv = br.readLine().split("");
        int[] iv = new int[sv.length];
        for(int i = 0 ; i < iv.length ; i++) {
            iv[i] = Integer.parseInt(sv[i]);
        }
        int sum = 0;
        for(int i : iv) {
            sum += i;
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}