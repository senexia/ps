import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> l = new ArrayList<>();
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            else l.add(n);
        }
        if(l.isEmpty()) return;
        int max = Collections.max(l);
        boolean[] p = new boolean[2 * max + 1];
        Arrays.fill(p, true);
        p[0] = false;
        p[1] = false;
        for(int i = 2 ; i * i <= 2 * max ; i++) {
            if(p[i]) {
                for(int j = 2 ; i * j <= 2 * max ; j++) {
                    p[i * j] = false;
                }
            }
        }
        int[] parsum = new int[2 * max + 1];
        parsum[0] = 0;
        parsum[1] = 0;
        for(int i = 2 ; i <= 2 * max ; i++) {
            parsum[i] = parsum[i - 1] + (p[i] ? 1 : 0);
            //parsum[i] : 1, 2, 3, ..., i 중 소수 개수
        }

        for(int i : l) {
            bw.write(String.valueOf(parsum[2 * i] - parsum[i]) + "\n");
        }
        bw.flush();
        bw.close();
    }
}