import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int res1 = (a + b) % c;
        int res2 = ((a % c) + (b % c))%c;
        int res3 = (a * b) % c;
        int res4 = ((a % c) * (b % c))%c;

        bw.write(String.valueOf(res1) + "\n");
        bw.write(String.valueOf(res2) + "\n");
        bw.write(String.valueOf(res3) + "\n");
        bw.write(String.valueOf(res4) + "\n");
        bw.flush();
        bw.close();
    }
}