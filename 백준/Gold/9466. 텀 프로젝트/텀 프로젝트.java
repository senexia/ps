import java.io.*;
import java.util.*;

public class Main {
    static int n, cnt;
    static int[] arr;
    static boolean[] v;
    static boolean[] complete;
    /*
    맨 처음에는 main에서 호출되는 각 dfs의 시작점을 기록해두고
    얘를 다시 만나면 사이클, 아니면 X로 처리했는데
    되돌리는 비용때문에 시간초과

    그래서 이렇게 하지말고 방문배열을 쓰면서 완료배열까지 두자.

     */
    static void dfs(int x) {
        v[x] = true;
        int next = arr[x];

        if(!v[next]) {
            dfs(next);
        } else if(!complete[next]) {
            for (int i = next; i != x; i = arr[i]) {
                cnt++;
                //경로상 인원
            }
            cnt++;
            //본인포함
        }
        complete[x] = true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int k = 0 ; k < tc ; k++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            v = new boolean[n + 1];
            complete = new boolean[n + 1];
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0 ; i < n ; i++) {
                arr[i + 1] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!v[i]) {
                    dfs(i);
                }
            }
            sb.append(n - cnt).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }


}