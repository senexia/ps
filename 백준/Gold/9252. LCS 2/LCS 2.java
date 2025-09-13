import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int l1 = s1.length();
        int l2 = s2.length();
        int max = 0;

        int[][] arr = new int[l1 + 1][l2 + 1];
        for(int i = 0 ; i < l1 ; i++) {
            for(int j = 0 ; j < l2 ; j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    arr[i + 1][j + 1] = arr[i][j] + 1;
                } else {
                    arr[i + 1][j + 1] = Math.max(arr[i][j + 1], arr[i + 1][j]);
                }
                if(max < arr[i + 1][j + 1]) max = arr[i + 1][j + 1];
            }
        }
//        for(int[] a : arr) System.out.println(Arrays.toString(a));
        if(max == 0) {
            System.out.println(0);
            return;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int x = l1;
        int y = l2;
        while(arr[x][y] != 0) {
            if(arr[x][y] == arr[x - 1][y]) {
                x--;
            } else if(arr[x][y] == arr[x][y - 1]) {
                y--;
            } else {
                x--;
                y--;
                stack.push(s1.charAt(x));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(max);
        System.out.println(sb);
    }
}