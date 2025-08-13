import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0 ; t < tc ; t++) {
            int max = -1;
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int[] temp = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i < n ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            for(int i = 0 ; i < n ; i++) {
                if(i % 2 == 0) {
                    temp[i / 2] = arr[i];
                } else {
                    temp[n - i / 2 - 1] = arr[i];
                }
            }
            for(int i = 0 ; i < n ; i++) {
                if(max < Math.abs(temp[i % n] - temp[(i + 1) % n])) max = Math.abs(temp[i % n] - temp[(i + 1) % n]);
            }
            sb.append(max).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}