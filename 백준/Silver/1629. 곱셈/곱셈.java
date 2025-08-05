import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long res = 1;
        while(b > 0) {
            if(b % 2 != 0) res = (res % c) * (a % c) % c;
            a = (a % c) * (a % c) % c;
            b /= 2;
        }
        System.out.println(res);
    }
}