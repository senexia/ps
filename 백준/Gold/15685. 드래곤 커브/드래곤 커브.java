import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] v = new boolean[101][101];
    static int firstX, firstY;
    static int cenX, cenY; //회전변환 기준
    static void dragon(int x, int y, int dir, int g) {
        List<int[]> points = new ArrayList<>();
        v[x][y] = true; // 첫 점 OK
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        v[nx][ny] = true; // 두번째 점 OK
        points.add(new int[]{x,y});
        points.add(new int[]{nx,ny});

        cenX = nx;
        cenY = ny;

        if(g == 0) {
            return;
        } else {
            for(int i = 0 ; i < g ; i++) {
                List<int[]> tempList = new ArrayList<>();
                for(int[] coord : points) {
                    int a = coord[0];
                    int b = coord[1];
                    //집합의 각 점에 대하여

                    v[cenX + cenY - b][a - cenX + cenY] = true;
                    tempList.add(new int[] {cenX + cenY - b, a - cenX + cenY});
                    //회전시킨 점이 다음 세대의 그래프가 되므로 방문처리 및 집합에 포함

                }
                int t1 = cenX + cenY - firstY;
                int t2 = firstX - cenX + cenY;
                cenX = t1;
                cenY = t2;
                for(int[] a : tempList) points.add(new int[] {a[0], a[1]});
                //다음 회전중심 점 계산
            }
        }
    }
    static int cal() {
        int cnt = 0;
        for(int i = 0 ; i < 100 ; i++) {
            for(int j = 0 ; j < 100 ; j++) {
                if(v[i][j] && v[i+1][j] && v[i][j+1] && v[i+1][j+1]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //입력 : x, y, 방향d, 세대g  ->  스텝 개수 2^g회 : 맥스 1024회
        //1024 * 20 = 20480회 (n 최대가 20이므로)
        //기존 점의 집합에 있는 (x, y)에 대하여
        //회전변환으로부터 (a+b-y, x-a+b)가 다시 S에 포함됨.
        //완전 처음에 주어진 점을 회전시킨 점이 해당 step의 마지막 점이 됨
        //즉, 다음 step에서 회전변환의 기준점이 되므로, 첫점만 잘 관리하면 됨.
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            firstX = x;
            firstY = y;
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            dragon(x, y, d, g);
        }
        System.out.println(cal());
    }
}