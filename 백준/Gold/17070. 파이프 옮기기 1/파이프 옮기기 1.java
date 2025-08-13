import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int cnt = 0;
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    static void dir1(int x, int y) {
//        System.out.println("Called 1");
        //왼쪽 보는 상태에서 가능한 선택지는
        //왼쪽으로 가기
        if(y + 1 < n && arr[x][y + 1] == 0) {
//            System.out.println("called 1-1");
            q.offer(new int[] {x, y + 1, 1});
        }
        //아래로 틀기
        if(y + 1 < n && x + 1 < n && arr[x + 1][y] == 0 && arr[x][y + 1] == 0 && arr[x + 1][y + 1] == 0) {
//            System.out.println("called 1-2");
            q.offer(new int[] {x + 1, y + 1, 2});
        }
    }
    static void dir2(int x, int y) {
//        System.out.println("called 2");
        //대각 -> 가로
        if(y + 1 < n && arr[x][y + 1] == 0) {
            q.offer(new int[] {x, y + 1, 1});
        }
        //대각 -> 대각
        if(x + 1 < n && y + 1 < n && arr[x + 1][y] == 0 && arr[x][y + 1] == 0 && arr[x + 1][y + 1] == 0) {
            q.offer(new int[] {x + 1, y + 1, 2});
        }
        //대각 -> 세로
        if(x + 1 < n && arr[x + 1][y] == 0) {
            q.offer(new int[] {x + 1, y, 3});
        }
    }
    static void dir3(int x, int y) {
//        System.out.println("called 3");
        //세로 -> 세로
        if(x + 1 < n && arr[x + 1][y] == 0) {
            q.offer(new int[] {x + 1, y, 3});
        }
        //세로 -> 대각
        if(x + 1 < n && y + 1 < n && arr[x + 1][y] == 0 && arr[x][y + 1] == 0 && arr[x + 1][y + 1] == 0) {
            q.offer(new int[] {x + 1, y + 1, 2});
        }
    }

    static void bfs(int hx, int hy, int dir) {

        //hx, hy : head 좌표
        //dir : 향하는 방향. 1이면 오른쪽, 2면 대각, 3이면 아래.
        q.offer(new int[] {hx, hy, dir});
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            if(temp[0] == n - 1 && temp[1] == n - 1) {
                cnt++;
                continue;
            }
            if(temp[2] == 1) dir1(temp[0], temp[1]);
            else if(temp[2] == 2) dir2(temp[0], temp[1]);
            else dir3(temp[0], temp[1]);
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 1, 1);
        System.out.println(cnt);
    }
}