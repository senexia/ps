import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int cnt = 0;
        while(true) {
            if(b % 10 == 1) {
                cnt++;
                b = (b - 1) / 10;
            } else if((b % 10) % 2 == 0) {
                cnt++;
                b /= 2;
            } else {
                System.out.println("-1");
                return;
            }
            if(b == a) break;
            if(b < 1) {
                System.out.println("-1");
                return;
            }
        }
        System.out.println(cnt + 1);
    }
}