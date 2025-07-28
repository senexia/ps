import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        int[] n = new int[cnt];
        for(int i = 0 ; i < cnt ; i++) {
            n[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(n);
        for(int i : n) bw.write(String.valueOf(i) + "\n");

        bw.flush();
        bw.close();
    }
}