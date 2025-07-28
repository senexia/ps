import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        boolean find = false;
        int ans = 0;

        for(int i = 1 ; i <= n ; i++) {
            int sum = i;
            int curr = i;
            while (curr > 0) {
                sum += curr % 10;
                curr /= 10;
            }

            if (sum == n) {
                find = true;
                ans = i;
                break;
            }
        }
        bw.write(String.valueOf(ans));


        bw.flush();
        bw.close();
    }
}