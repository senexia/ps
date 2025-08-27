import java.io.*;
import java.util.*;


public class Main {

    static int sqrt;
    static long[] arr;
    static long[] bkt;

    static void update(int loc, long next) {
        long diff = next - arr[loc];
        arr[loc] = next;
        bkt[loc/sqrt] += diff;
    }
    static long sum(int a, int b) {
        int start = a / sqrt;
        int end = b / sqrt;
        long sum = 0;
        if(start == end) {
            for(int i = a ; i <= b ; i++) {
                sum += arr[i];
            }
            return sum;
        } else {
            for(int i = a ; i < (start + 1) * sqrt ; i++) {
                sum += arr[i];
            }
            for(int i = start + 1 ; i < end ; i++) {
                sum += bkt[i];
            }
            for(int i = end * sqrt ; i <= b ; i++) {
                sum += arr[i];
            }
            return sum;
        }
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        sqrt = (int)Math.sqrt(n);
        arr = new long[n];
        bkt = new long[1 + (n-1)/sqrt];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Long.parseLong(br.readLine());
            bkt[i / sqrt] += arr[i];
        }

//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(bkt));
//        System.out.println("===========");
        for(int i = 0 ; i < m + k ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) update(b - 1, c);
            else sb.append(sum(b - 1, (int) c - 1)).append("\n");
//            System.out.println(Arrays.toString(arr));
//            System.out.println(Arrays.toString(bkt));
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}