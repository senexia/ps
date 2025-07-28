import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n == k || k == 0) {
            System.out.println("1");
            return;
        }
        int num = 1;
        int denom = 1;
        for(int i = 0 ; i < k ; i++) {
            num *= n - i;
            denom *= k - i;
        }
        System.out.println(num / denom);
    }
}