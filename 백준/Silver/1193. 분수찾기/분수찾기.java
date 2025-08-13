import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int line = (int)Math.floor((1 + Math.sqrt(8 * n - 7))/2);
        int start = (line * line - line + 2) / 2;

        if(line % 2 == 0) {
            int difference = n - start;
            int total = line + 1;
            sb.append(difference + 1).append("/").append(total - difference - 1);
        } else {
            int difference = line - (n - start);
            int total = line + 1;
            sb.append(difference).append("/").append(total - difference);
        }
        /*
        대각선 기준 line번째 대각선에는 원소가 line개 있음
        위쪽 기준으로 대각선의 시작번호가 1, 2, 4, 7, ...., 1 + n(n-1)/2
        이때 line번호가 홀수냐 짝수냐에 따라 위에서부터 세는지, 아래부터 세는지가 달라지므로
        이를 홀짝따라 구분하여 해결 (분자분모합이 total이므로 여기서 빼는식으로
        */

        System.out.println(sb);
    }
}