import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int l1 = s1.length();
        int l2 = s2.length();

        int[][] arr = new int[l1 + 1][l2 + 1];
        for(int i = 0 ; i < l1 + 1 ; i++) arr[i][0] = 0;
        for(int i = 0 ; i < l2 + 1 ; i++) arr[0][i] = 0;

        for(int i = 1 ; i < l1 + 1 ; i++) {
            for(int j = 1 ; j < l2 + 1 ; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) arr[i][j] = arr[i - 1][j - 1] + 1;
                else arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
            }
        }
//        for(int[] a : arr) System.out.println(Arrays.toString(a));

        int max = 0;
        for(int i = 1 ; i < l1 + 1 ; i++) {
            for(int j = 1 ; j < l2 + 1 ; j++) {
                if(max < arr[i][j]) max = arr[i][j];
            }
        }
        System.out.println(max);
    }
}