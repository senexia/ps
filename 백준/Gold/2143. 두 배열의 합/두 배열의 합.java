import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] ps1 = new int[n + 1];
        int[] arr1;
        st = new StringTokenizer(br.readLine(), " ");
        if(n != 1) {
            arr1 = new int[n * (n + 1) / 2];
            for(int i = 1 ; i < n + 1 ; i++) {
                ps1[i] = ps1[i - 1] + Integer.parseInt(st.nextToken());
            }
            int ptr = 0;
            for(int i = 1 ; i < n + 1 ; i++) {
                for(int j = 0 ; j < i ; j++) {
                    arr1[ptr++] = ps1[i] - ps1[j];
                }
            }
        } else {
            arr1 = new int[1];
            arr1[0] = Integer.parseInt(st.nextToken());
        }





        n = Integer.parseInt(br.readLine());
        int[] ps2 = new int[n + 1];
        int[] arr2;
        st = new StringTokenizer(br.readLine(), " ");
        if(n != 1) {
            arr2 = new int[n * (n + 1) / 2];
            for(int i = 1 ; i < n + 1 ; i++) {
                ps2[i] = ps2[i - 1] + Integer.parseInt(st.nextToken());
            }

            int ptr = 0;
            for(int i = 1 ; i < n + 1 ; i++) {
                for(int j = 0 ; j < i ; j++) {
                    arr2[ptr++] = ps2[i] - ps2[j];
                }
            }
        } else {
            arr2 = new int[1];
            arr2[0] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int s = 0;
        int e = arr2.length - 1;
        int b1 = arr1.length;
        long cnt = 0;
        int sum = 0;
        while(s < b1 && e >= 0) {
            sum = arr1[s] + arr2[e];
            if(sum < t) {
                s++;
            } else if(sum > t) {
                e--;
            } else {
                long c1 = 0;
                long c2 = 0;
                int v1 = arr1[s];
                int v2 = arr2[e];
                while(s < b1 && arr1[s] == v1) {
                    s++;
                    c1++;
                }
                while(e >= 0 && arr2[e] == v2) {
                    e--;
                    c2++;
                }
                cnt += c1 * c2;
            }
        }
        System.out.println(cnt);
    }
}