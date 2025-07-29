import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] eb0 = new long[91]; //0으로 끝나는 개수
        long[] eb1 = new long[91]; //1로 끝나는 개수
        eb0[1] = 0;
        eb1[1] = 1;

        eb0[2] = 1;
        eb1[2] = 0;
        int n = Integer.parseInt(br.readLine());
        for(int i = 3 ; i <= n ; i++) {
            eb0[i] = eb0[i-1] + eb1[i-1];
            eb1[i] = eb0[i-1];
        }
        System.out.println(eb0[n] + eb1[n]);
    }
}