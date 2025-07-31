import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] buffer;
    static boolean[][] v;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int nx, ny;



    static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});
        v[x][y] = true;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int px = temp[0];
            int py = temp[1];
            int adjcnt = 0;
            for(int i = 0 ; i < 4 ; i++) {
                nx = px + dx[i];
                ny = py + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(arr[nx][ny] == 0) {
                        //물 개수 먼저 확인
                        adjcnt++;
                    }
                }
            }

            //각 땅마다 1일이 지날 때 얼마 녹는지를 저장하는 배열
            //(다음날 배열) = (이전날 배열) - (buffer 배열)
            buffer[px][py] = adjcnt;
            for(int i = 0 ; i < 4 ; i++) {
                nx = px + dx[i];
                ny = py + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] != 0 && !v[nx][ny]) {
                    v[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int days = 0; // 경과한 날
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        v = new boolean[n][m];
        buffer = new int[n][m];
        List<int[]> coords = new ArrayList<>();
        //배열 초기화
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++) {
                int ipt = Integer.parseInt(st.nextToken());
                arr[i][j] = ipt;
                if(ipt != 0) {
                    coords.add(new int[] {i, j});
                    //얼음 좌표 담기
                }
            }
        }

        while(true) {
            int comp = 0; //몇개로 나뉘었는지
            for(int i = 0 ; i < coords.size() ; i++) {
                int a = coords.get(i)[0];
                int b = coords.get(i)[1];
                if(!v[a][b] && arr[a][b] != 0) {
                    comp++;
                    bfs(a, b);
                }
            }
            //2개 이상으로 나뉨
            if(comp > 1) {
                System.out.println(days);
                return;
            }
            //나뉜거 있는지 검사 먼저 한 뒤 days++
            //안그러면 이미 나뉜 상태에서 day하나 더 늘어난 뒤 출력됨
            days++;
            for(int i = 1 ; i < n - 1 ; i++) {
                for(int j = 1 ; j < m - 1 ; j++) {
                    if(arr[i][j] <= buffer[i][j]) {
                        arr[i][j] = 0;
                        //다 녹았으므로 얼음 개수 차감
                    } else {
                        arr[i][j] -= buffer[i][j];
                        //녹는 중
                    }
                }
            }
            coords.removeIf(p -> arr[p[0]][p[1]] == 0);
            //얼음 남은게 없음 = 나뉜거 없이 그냥 다녹음
            if(coords.isEmpty()) {
                System.out.println("0");
                return;
            }
            for(boolean[] b : v) Arrays.fill(b, false);
            for(int[] b : buffer) Arrays.fill(b, 0);
        }

    }
}