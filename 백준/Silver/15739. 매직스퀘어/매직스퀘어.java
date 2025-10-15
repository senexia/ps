import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        boolean legit = true;
        HashSet<Integer> set = new HashSet<>();
        int[][] arr = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] < 1 || arr[i][j] > n * n) legit = false;
                if(set.contains(arr[i][j])) legit = false;
                set.add(arr[i][j]);
            }
        }

        int sum = n * (1 + n * n) / 2;
        for(int i = 0 ; i < n ; i++) {
            int s = 0;
            for(int j = 0 ; j < n ; j++) {
                s += arr[i][j];
            }
            if(sum != s) legit = false;
        }
        for(int i = 0 ; i < n ; i++) {
            int s = 0;
            for(int j = 0 ; j < n ; j++) {
                s += arr[j][i];
            }
            if(sum != s) legit = false;
        }
        int s =  0;
        for(int i = 0 ; i < n ; i++) {
            s += arr[i][i];
        }
        if(sum != s) legit = false;
        s = 0 ;
        for(int i = 0 ; i < n ; i++) {
            s += arr[n - i - 1][i];
        }
        if(sum != s) legit = false;

        System.out.println(legit ? "TRUE" : "FALSE");
    }
}