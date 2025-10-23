import java.io.*;
import java.util.*;

public class Main {
    static int n, m, id;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int[][] type;

    static HashMap<Integer, Integer> cntById;
    static ArrayDeque<int[]> q = new ArrayDeque<>();

    static int bfs(int sx, int sy) {
        type[sx][sy] = id;
        q.offer(new int[]{sx, sy});
        int cnt = 1;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0 && type[nx][ny] == 0) {
                    type[nx][ny] = id;
                    q.offer(new int[] {nx, ny});
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        type = new int[n][m];
        cntById = new HashMap<>();
        id = 1;

        for(int i = 0 ; i < n ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = s.charAt(j) - '0';
                if(arr[i][j] == 1) {
                    type[i][j] = -1;
                }
            }
        }

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(arr[i][j] == 1 || type[i][j] != 0) continue;

                int cnt = bfs(i, j);
                cntById.put(id, cnt);
                id++;
            }
        }

//        for(int[] a : arr) System.out.println(Arrays.toString(a));
//        System.out.println();
//        for(int[] a : type) System.out.println(Arrays.toString(a));


        HashSet<Integer> v = new HashSet<>();
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(arr[i][j] == 0) {
                    sb.append(0);
                } else {
                    int sum = 1;
                    for(int k = 0 ; k < 4 ; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
                            int id = type[nx][ny];
                            if(v.contains(id)) continue;

                            sum += cntById.get(id);
                            v.add(id);
                        }
                    }
                    v.clear();
                    sb.append(sum % 10);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}