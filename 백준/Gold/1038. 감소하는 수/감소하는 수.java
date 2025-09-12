import java.io.*;
import java.util.*;

public class Main {
    static boolean matched = false;
    static int n, cnt;
    static StringBuilder sb = new StringBuilder();
    static void gshns(int digit, int prev) {
        for(int i = digit - 1 ; i < prev ; i++) {
            sb.append(i);
            if(digit - 1 > 0) {
                gshns(digit - 1, i);
            } else {
                //다음 자리수가 없다 -> 완성됐따
//                cnt++;
                //0부터 도니까
                if(n == cnt++) {
                    System.out.println(sb);
                    System.exit(0);
                }
            }
            sb.setLength(sb.length() - 1);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        cnt = 0;
        if(n == 0) {
            System.out.println(0);
            return;
        }
        //k자리수라고 가정하면 10^k 자리에 오는 숫자는 k - 1보다는 커야 함
        //그래야 그 다음 자리수를 감소시키게 잡을 수 있으니까
        //그럼 재귀나 백트래킹 느낌으로 될거같은데

        //9876543210 -> 10자리
        int digit = 1;
        while(!matched) {
            gshns(digit++, 10);
            if(digit == 11) {
                System.out.println(-1);
                return;
            }
        }
    }
}