import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayDeque<int[]> q = new ArrayDeque<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int stx = -1;
        int sty = -1;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        char[][] arr = new char[n][m];
        /*
        열쇠를 가진 상태를 관리해야 하므로 큐에 달고다니기
        ~까지 가진 상태라고 하기엔 획득 순서 보장이 안 됨
        6개밖에 안되니까 a~f를 각각 2^0~2^5라 하고 비트마스킹 하면 될 것 같음
        상태 (x, y, t) : (x, y)에 열쇠정보 t
        그냥 벽부수고 이동하기나 말이 되고싶은 원숭이랑 같은 문제네
         */

//        System.out.println(50*50*64 /1024);
//        System.out.println(4*4*50*50*64 / 1024);
        boolean[][][] v = new boolean[n][m][64];
        for(int i = 0 ; i < n ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < m ; j++) {
                char c = s.charAt(j);
                if(c == '0') {
                    stx = i;
                    sty = j;
                    arr[i][j] = '.';
                } else {
                    arr[i][j] = c;
                }
            }
        }
        v[stx][sty][0] = true;
        q.offer(new int[] {stx, sty, 0, 0});
        //                 x    y   t   depth
        while(!q.isEmpty()) {
            int[] xytd = q.poll();
            int x = xytd[0];
            int y = xytd[1];
            int t = xytd[2];
            int depth = xytd[3];
            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || arr[nx][ny] == '#' || v[nx][ny][t]) continue;
                //맵 밖이거나, 이미 방문했으면 continue
                if(arr[nx][ny] == '1') {
                    System.out.println(depth + 1);
                    return;
                    //다음 스텝이 도착지점인 경우 종료. 다음 지점이므로 depth + 1을 리턴
                } else if(arr[nx][ny] == '.') {
                    //다음 지점이 땅인경우 = 그냥 이동
                    v[nx][ny][t] = true;
                    q.offer(new int[] {nx, ny, t, depth + 1});
                } else if(arr[nx][ny] - 'A' < 10) {
                    //문을 만난 경우
                    int door = (1 << (arr[nx][ny] - 'A'));
                    if((t & door) == door) {
                        //and 해서 같다 = 열쇠가 있다.
                        v[nx][ny][t] = true;
                        q.offer(new int[] {nx, ny, t, depth + 1});
                    }
                } else {
                    //열쇠를 만난 경우
                    int key = arr[nx][ny] - 'a';
                    int next = (t | (1 << key));
                    v[nx][ny][t] = true;
                    q.offer(new int[] {nx, ny, next, depth + 1});
                }
            }
        }
        System.out.println(-1);
    }
}