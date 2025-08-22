import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        int overallsum = 0;
        int sup = -1;
        for(int i = 0 ; i < n ; i++) {
            int tok = Integer.parseInt(st.nextToken());
            overallsum += tok;
            sup = sup < tok ? tok : sup;
            arr[i] = tok;
        }

        int max = Integer.parseInt(br.readLine());

        if(overallsum <= max) {
            System.out.println(sup);
            return;
        }


        int low = 1;
        int mid = 0;
        int high = max;
        int bound = 0;
        while(low <= high) {
            mid = (low + high)/2;
            int sum = 0;
            for(int i : arr) {
                sum += Math.min(i, mid);
            }

            if(sum <= max) {
                low = mid + 1;
                bound = mid;
            } else {
                high = mid - 1;
            }

        }
        System.out.println(bound);
    }
}