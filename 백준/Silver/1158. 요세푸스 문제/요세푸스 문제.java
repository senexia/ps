import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[n];
        boolean[] v = new boolean[n];
        int cnt = 0;
        int step = 0;
        for(int i = 0 ; i < n ; i++) arr[i] = i + 1;
        sb.append("<");
        int idx = -1;

        while(!(cnt == n)) {
            while(!(step == k)) {
                idx++;
                if(!v[idx % arr.length]) step++;
            }
            step = 0;
            v[idx % arr.length] = true;
            sb.append(arr[idx % arr.length]);
            cnt++;
            if(cnt != n) sb.append(", ");
            else break;
        }
        sb.append(">");
        bw.write(sb.toString());



        bw.flush();
        bw.close();
    }
}