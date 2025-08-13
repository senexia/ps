import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws Exception {
        //테케 오류나서 scanner써야함
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tc = sc.nextInt();
        for(int t = 1 ; t <= tc ; t++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
            long ways = 0;
            int up = 0;
            int down = 0;

            for(int i = 0 ; i < n - 1 ; i++) {
                if(arr[i] < arr[i + 1]) {
                    if(down > 0) {
                        ways += up * down;
                        up = 0;
                        down = 0;
                    }
                    up++;
                } else if(arr[i] > arr[i + 1]) {
                    if(up > 0) down++;
                }
            }

            if(up > 0 && down > 0) ways += up * down;


            sb.append("#").append(t).append(" ").append(ways).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}