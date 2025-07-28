import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] dp = new int[n][3];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < 3 ; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] temp = {dp[0][0], dp[0][1], dp[0][2]};
        for(int i = 1 ; i < n ; i++) {
            //위에서 아래로 내려가는거로 생각하면 경우가 점점 확장되므로
            //아래칸의 입장에서 현재 자리로 도달 가능한 경우의 수가 뭐가 있는지를 고려
            //예 : 가장 왼쪽칸의 경우, 바로 위에서 아래로 내려오거나, 위의 중앙칸에서 왼쪽 아래로 내려오기 가능.
            int a = temp[0] > temp[1] ? temp[0] + dp[i][0] : temp[1] + dp[i][0];
            int b = Math.max(temp[0], Math.max(temp[1], temp[2])) + dp[i][1];
            int c = temp[1] > temp[2] ? temp[1] + dp[i][2] : temp[2] + dp[i][2];
            temp[0] = a;
            temp[1] = b;
            temp[2] = c;
//            System.out.println(Arrays.toString(temp));
        }
//        for(int[] a : dp) System.out.println(Arrays.toString(a));
        int max = Math.max(temp[0], Math.max(temp[1], temp[2]));
        temp = new int[] {dp[0][0], dp[0][1], dp[0][2]};
        for(int i = 1 ; i < n ; i++) {
            int a = temp[0] > temp[1] ? temp[1] + dp[i][0] : temp[0] + dp[i][0];
            int b = Math.min(temp[0], Math.min(temp[1], temp[2])) + dp[i][1];
            int c = temp[1] > temp[2] ? temp[2] + dp[i][2] : temp[1] + dp[i][2];
            temp[0] = a;
            temp[1] = b;
            temp[2] = c;
        }
        int min = Math.min(temp[0], Math.min(temp[1], temp[2]));
        System.out.println(max + " " + min);
    }
}