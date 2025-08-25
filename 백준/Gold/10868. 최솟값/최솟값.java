import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int sqrt = (int)Math.sqrt(n);

        int[] arr = new int[n];
        int[] bucket = new int[1 + (n - 1)/sqrt];
        Arrays.fill(bucket, Integer.MAX_VALUE);

        for(int i = 0 ; i < n ; i++) {
            int k = Integer.parseInt(br.readLine());
            bucket[i/sqrt] = Math.min(bucket[i/sqrt], k);
            arr[i] = k;
        }
//        System.out.println(Arrays.toString(bucket));
//        System.out.println(Arrays.toString(arr));

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            int start = a / sqrt;
            int end = b / sqrt;
            int min = Integer.MAX_VALUE;
            if(start == end) {
                for(int j = a ; j <= b ; j++) {
                    min = Math.min(min, arr[j]);
                }
            } else {
                for(int j = a ; j < (start + 1) * sqrt ; j++) {
                    min = Math.min(min, arr[j]);
                }

                for(int j = start + 1 ; j < end ; j++) {
                    min = Math.min(min, bucket[j]);
                }

                for(int j = end * sqrt ; j <= b ; j++) {
                    min = Math.min(min, arr[j]);
                }
            }
            sb.append(min).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}