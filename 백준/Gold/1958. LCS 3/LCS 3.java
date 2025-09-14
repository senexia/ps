import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();

        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        int max = 0;

        int[][][] arr = new int[l1 + 1][l2 + 1][l3 + 1];
        for(int i = 0 ; i < l1 ; i++) {
            for(int j = 0 ; j < l2 ; j++) {
                for(int k = 0 ; k < l3 ; k++) {
                    if(s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)) {
                        arr[i + 1][j + 1][k + 1] = 1 + arr[i][j][k];
                    } else {
                        arr[i + 1][j + 1][k + 1] =
                                Math.max(arr[i + 1][j + 1][k],
                                        Math.max(arr[i][j + 1][k + 1], arr[i + 1][j][k + 1]));
                    }
                    max = Math.max(max, arr[i + 1][j + 1][k + 1]);
                }
            }
        }
        System.out.println(max);
    }
}