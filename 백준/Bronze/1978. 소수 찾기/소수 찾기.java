import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] num = new int[n];
        for(int i = 0 ; i < n ; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int pCnt = 0;
        Arrays.sort(num);
        int maxVal = num[num.length - 1];
        boolean[] isPrime = new boolean[maxVal + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2 ; i * i <= maxVal ; i++) {
            if(isPrime[i]) {
                for(int j = 2 ; i * j <= maxVal ; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        for(int i : num) {
            if(isPrime[i]) pCnt++;
        }
        bw.write(String.valueOf(pCnt));



        bw.flush();
        bw.close();
    }
}
