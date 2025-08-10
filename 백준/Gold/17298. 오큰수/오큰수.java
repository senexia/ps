import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> s = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] okensu = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        s.push(0);
        for(int i = 1 ; i < n ; i++) {
            while(!s.isEmpty()) {
                if(arr[i] > arr[s.peek()]) {
                    okensu[s.pop()] = arr[i];
                } else {
                    break;
                }
            }
            s.push(i);
        }
        while(!s.isEmpty()) okensu[s.pop()] = -1;
        for(int i = 0 ; i < n ; i++) sb.append(okensu[i]).append(" ");
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}