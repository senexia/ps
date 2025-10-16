import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int curr = n * n;
        int dir = 0;
        int[][] arr = new int[n][n];

        int x = 0;
        int y = 0;
        int memx = 0;
        int memy = 0;
        while(curr > 0) {
            if(curr == target) {
                memx = x + 1;
                memy = y + 1;
            }
            arr[x][y] = curr--;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 0) {
                x = nx;
                y = ny;
            } else {
                dir = (dir + 1) % 4;
                x = x + dx[dir];
                y = y + dy[dir];
            }
        }
//        for(int[] ar : arr) {
//            System.out.println(Arrays.toString(ar));
//        }

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        sb.append(memx).append(" ").append(memy);
        System.out.print(sb);
    }
}