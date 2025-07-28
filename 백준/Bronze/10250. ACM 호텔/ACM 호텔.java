import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < c ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int back = (n - 1) / h + 1;
            int front = (n % h == 0) ? h : n % h;
            bw.write(String.valueOf(100 * front + back) + "\n");
        }

        bw.flush();
        bw.close();
    }
}