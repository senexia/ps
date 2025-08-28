import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        long[] arr, minb, maxb;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int sqrt = (int)Math.sqrt(n);
        arr = new long[n];
        minb = new long[1 + (n-1)/sqrt];
        maxb = new long[1 + (n-1)/sqrt];
        Arrays.fill(minb, Integer.MAX_VALUE);
        Arrays.fill(maxb, Integer.MIN_VALUE);
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Long.parseLong(br.readLine());
            minb[i/sqrt] = Math.min(arr[i], minb[i/sqrt]);
            maxb[i/sqrt] = Math.max(arr[i], maxb[i/sqrt]);
        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(minb));
//        System.out.println(Arrays.toString(maxb));

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            int start = a / sqrt;
            int end = b / sqrt;

            long tmin = Long.MAX_VALUE;
            long tmax = Long.MIN_VALUE;

            if(start == end) {
                for(int j = a ; j <= b ; j++) {
                    if(tmin > arr[j]) tmin = arr[j];
                    if(tmax < arr[j]) tmax = arr[j];
                }
                sb.append(tmin).append(" ").append(tmax).append("\n");
            } else {
                for(int j = a ; j < (start + 1) * sqrt ; j++) {
                    if(tmin > arr[j]) tmin = arr[j];
                    if(tmax < arr[j]) tmax = arr[j];
                }
                for(int j = start + 1 ; j < end ; j++) {
                    if(tmin > minb[j]) tmin = minb[j];
                    if(tmax < maxb[j]) tmax = maxb[j];
                }
                for(int j = end * sqrt ; j <= b ; j++) {
                    if(tmin > arr[j]) tmin = arr[j];
                    if(tmax < arr[j]) tmax = arr[j];
                }
                sb.append(tmin).append(" ").append(tmax).append("\n");
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);

    }
}