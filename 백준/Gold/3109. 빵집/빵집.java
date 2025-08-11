import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static int[][] arr;
    static int ways = 0;
    static boolean dfs(int x, int y) {
        arr[x][y] = 1;
        if(y == c - 1) {
            return true;
        } else {
            for(int i = -1 ; i <= 1 ; i++) {
                if(x + i >= 0 && x + i < r && arr[x + i][y + 1] == 0) {
                    if(dfs(x + i, y + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        for(int i = 0 ; i < r ; i++) {
            String[] s = br.readLine().split("");
            for(int j = 0 ; j < c ; j++) {
                if(s[j].equals(".")) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1;
                }
            }
        }

        for(int i = 0 ; i < r ; i++) {
            if(dfs(i, 0)) ways++;
//            for(int[] a : arr) System.out.println(Arrays.toString(a));
//            System.out.println();
        }
        System.out.println(ways);

    }
}