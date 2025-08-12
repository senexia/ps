import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        ArrayDeque<int[]> sr = new ArrayDeque<>();
        ArrayDeque<int[]> sl = new ArrayDeque<>();
        //         (번호, 높이)

        int[] building = new int[n + 1];
        int[] cnt = new int[n + 1];
        int[] adj = new int[n + 1];
        for(int i = 1 ; i < n + 1 ; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i < n + 1 ; i++) {
            while(!sr.isEmpty() && sr.peek()[1] <= building[i]) {
                //모노톤 감소스택 유지
                sr.pop();
            }
            cnt[i] += sr.size(); //남아있는만큼 볼 수 있음
            if(!sr.isEmpty()) {
                adj[i] = sr.peek()[0];
            }

            sr.push(new int[] {i, building[i]});
        }

        for(int i = n ; i >= 1 ; i--) {
            while(!sl.isEmpty() && sl.peek()[1] <= building[i]) {
                //모노톤 감소스택 유지
                sl.pop();
            }
            cnt[i] += sl.size(); //남아있는만큼 볼 수 있음
            if(!sl.isEmpty()) {
                if(adj[i] == 0 || (sl.peek()[0] - i) < (i - adj[i])) {
                    adj[i] = sl.peek()[0];
                }
                //기존에 인접 건물이 없거나, 더 가깝게 할 수 있으면 갱신
            }

            sl.push(new int[] {i, building[i]});
        }
        for(int i = 1 ; i < n + 1 ; i++) {
            if(cnt[i]  == 0) {
                sb.append(0).append("\n");
            } else {
                sb.append(cnt[i]).append(" ").append(adj[i]).append("\n");
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}