import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] ipt = new int[n];
        int cnt = 0;

        for(int i = 0 ; i < n ; i++) {
            ipt[i] = Integer.parseInt(br.readLine());
        }

        for(int i = n - 1 ; i >= 1 ; i--) {
            if(ipt[i - 1] >= ipt[i]) {
                int gap = ipt[i - 1] - ipt[i] + 1;
                ipt[i - 1] -= gap;
                cnt += gap;
            }
        }
        System.out.println(cnt);
    }
}