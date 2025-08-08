import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, g;
    static int[][] arr;
    static void rotate(int depth) {
        int period = 2 * (n - 2 * depth) + 2 * (m - 2 * depth) - 4;
        List<Integer> temp = new ArrayList<>();

        //윗줄부터 시계방향으로
        //위
        for(int j = depth ; j <= m - depth - 1 ; j++) temp.add(arr[depth][j]);
        //오른쪽
        for(int i = depth + 1 ; i <= n - depth - 1 ; i++) temp.add(arr[i][m - depth - 1]);
        //아래
        for(int j = m - depth - 2 ; j >= depth ; j--) temp.add(arr[n - depth - 1][j]);
        //왼쪽
        for(int i = n - depth - 2 ; i >= depth + 1 ; i--) temp.add(arr[i][depth]);
//        System.out.println(temp);
        int shift = k % period;

        int t = shift;
        //윗줄부터 시계방향으로
        //위
        for(int j = depth ; j <= m - depth - 1 ; j++) {
            arr[depth][j] = temp.get(t);
            t = (t + 1) % period;
        }
        //오른쪽
        for(int i = depth + 1 ; i <= n - depth - 1 ; i++) {
            arr[i][m - depth - 1] = temp.get(t);
            t = (t + 1) % period;
        }
        //아래
        for(int j = m - depth - 2 ; j >= depth ; j--) {
            arr[n - depth - 1][j] = temp.get(t);
            t = (t + 1) % period;
        }
        //왼쪽
        for(int i = n - depth - 2 ; i >= depth + 1 ; i--) {
            arr[i][depth] = temp.get(t);
            t = (t + 1) % period;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        g = Math.min(n, m)/2; //몇겹인지
        arr = new int[n][m];

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < g ; i++) {
            rotate(i);
        }
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}