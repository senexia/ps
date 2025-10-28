import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] freq = new int[8001];
        int fmax = 0;
        //입력 절댓값이 4000이하 -> 가능한 정수는 8001개.
        //입력 x에 대하여 x + 4000에 저장.

        int sum = 0;
        double cnt = n;

        for(int i = 0 ; i < n ; i++) {
            int tok = Integer.parseInt(br.readLine());
            arr[i] = tok;
            sum += tok;
            freq[tok + 4000]++;
            if(fmax < freq[tok + 4000]) {
                fmax = freq[tok + 4000];
            }
        }
        Arrays.sort(arr);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < 8001 ; i++) {
            if(freq[i] == fmax) pq.offer(i - 4000);
        }

        if(pq.size() != 1) pq.poll();

        sb.append(Math.round(sum / cnt)).append("\n")
          .append(arr[(n - 1)/2]).append("\n")
          .append(pq.poll()).append("\n")
          .append(arr[n - 1] - arr[0]);
        System.out.println(sb);
    }
}