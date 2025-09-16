import java.io.*;
import java.util.*;

public class Main {
    static int bx, by, cnt;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] arr;
    static boolean[][] v;
    static ArrayDeque<Integer> visited = new ArrayDeque<>();
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    static HashSet<Integer> keys;

    static int hash(int x, int y) {
        return 105 * x + y;
    }
    static int getx(int h) {
        return h / 105;
    }
    static int gety(int h) {
        return h % 105;
    }

    static void bfs(int i, int j) {
        q.offer(new int[] {i, j});
        while(!q.isEmpty()) {
            boolean b = false;
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            for(int k = 0 ; k < 4 ; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || nx >= bx || ny < 0 || ny >= by || v[nx][ny] || arr[nx][ny] == '*') continue;
                //가능한 상태는
                //땅이거나, 문서거나, 열쇠거나, 문이거나
                //전부 닿는순간 .로 바꿔도 됨 (문은 열쇠 있는경우만)
                //중복코드를 줄일 수 있을듯 열쇠처리를 맨앞으로 당기면
                char c = arr[nx][ny];
                if(c == '.') {
                    //do nothing
                } else if(c == '$') {
                    cnt++;
                } else if('a' <= c && c <= 'z') {
                    int nk = c - 'a';
                    if(!keys.contains(nk)) {
                        //없던 키를 얻을때만 상태공간이 바뀌므로 contains가 true라면 큐 리셋 안해도 됨
                        keys.add(nk);
                        q.clear();
                        visitreset();
                        b = true;
                    }
                } else if('A' <= c && c <= 'Z') {
                    if(!keys.contains(c - 'A')) continue;
                }
                arr[nx][ny] = '.';
                v[nx][ny] = true;
                visited.offer(hash(nx, ny));
                q.offer(new int[] {nx, ny});
                if(b) break;

//                if(arr[nx][ny] - 'a' < 26) {
//                    q.clear();
//                    visitreset();
//                } else if(arr[nx][ny] - 'A' >= 0) {
//                    if(!keys.contains(arr[nx][ny] - 26)) continue;
//                    //열쇠 없으면 넘김
//                } else if(arr[nx][ny] == '$') {
//                    cnt++;
//                }
//                v[nx][ny] = true;
//                visited.offer(hash(nx, ny));
//                q.offer(new int[] {nx, ny});
//                cnt++;
//                arr[nx][ny] = '.'; //이게 중복연산이긴 한데 이걸 하는순간 코드가독성이 확좋아짐
            }
        }
    }

    static void visitreset() {
        while(!visited.isEmpty()) {
            int h = visited.poll();
            int x = getx(h);
            int y = gety(h);
            v[x][y] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        /*
        맵 밖을 오가는걸 어떻게 구현할까 -> 입력받을 때 i = 0, n-1 or j = 0, n-1이면서 '.'인거 전부 넣기?
        는 좀 무지성같음
        n * m크기의 맵을 입력받았으면 (n + 2) * (m + 2)크기의 맵으로 만들자
        그런다음 껍데기는 전부 .로 하면 맵 밖 이동 구현 끝

        문이랑 열쇠 26개나 되므로 방문배열 3차원으로 상태관리는 좀 어려움 메모리때매
        1. 해시맵으로 보유키 관리한다.
        2. 열쇠를 먹을 때마다 상태공간이 바뀐다
        2-1. 열쇠먹은게 감지 -> 방문배열 전부 초기화 / 큐 전부 비우고 지금칸기준 다시 BFS
        2-2. 방문배열 비우는건 Arrays fill 쓰면 오버헤드가 크다
        2-3. 지금까지 방문했던 좌표들을 저장하는 큐를 하나 둔다
        2-4. 열쇠를 먹은 순간 그 큐를 비워가며 방문배열을 다시 false로 바꾼다
        2-5. 이를 위해 (x, y)를 정수 t로 해싱 필요   ->   102 * x + y쓰면 될듯

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < tc ; t++) {
            q.clear();
            visited.clear();
            cnt = 0;
            keys = new HashSet<>();

            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            bx = n + 2;
            by = m + 2;

            arr = new char[bx][by];
            v = new boolean[bx][by];
            for(int i = 0 ; i < bx ; i++) {
                arr[i][0] = '.';
                arr[i][m + 1] = '.';
            }
            for(int i = 0 ; i < by ; i++) {
                arr[0][i] = '.';
                arr[n + 1][i] = '.';
            }

            for(int i = 0 ; i < n ; i++) {
                String s = br.readLine();
                for(int j = 0 ; j < m ; j++) {
                    arr[i + 1][j + 1] = s.charAt(j);
                }
            }

            String k = br.readLine();
            if(!k.equals("0")) {
                int len = k.length();
                for(int i = 0 ; i < len ; i++) keys.add(k.charAt(i) - 'a');
            }
            bfs(0, 0);
            sb.append(cnt).append("\n");

//            for(char[] c : arr) System.out.println(Arrays.toString(c));
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}
