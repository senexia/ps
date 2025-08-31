import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] exp = {1, 2, 4, 8, 16, 32, 64, 128};
    //2^n 미리 계산
    static int[][] arr;

    static int wc = 0;
    static int bc = 0;

    static void recursive(int x, int y, int len) {
        // 왼쪽 위 좌표 x, y   한 변 길이 len
        if(len == 1) {
            if(arr[x][y] == 0) wc++;
            else bc++;
            return;
        }
        boolean allSame = true;
        int a = arr[x][y];
        for(int i = x ; i < x + len ; i++) {
            for(int j = y ; j < y + len ; j++) {
                if(arr[i][j] != a) {
                    allSame = false;
                    break;
                }
            }
            if(!allSame) break;
        }
        if(allSame) {
            if(a == 1) bc++;
            else wc++;
            return;
        }
        recursive(x, y, len/2);
        recursive(x + len/2, y, len/2);
        recursive(x, y + len/2, len/2);
        recursive(x + len/2, y + len/2, len/2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursive(0, 0, n);
        System.out.println(wc);
        System.out.println(bc);
    }
}