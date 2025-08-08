import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[][] arr;

    //상하반전
    static void op1() {
        int bound = n / 2;
        int temp;
        for(int i = 0 ; i < bound ; i++) {
            for(int j = 0 ; j < m ; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[n - 1 - i][j];
                arr[n - 1 - i][j] = temp;
            }
        }
    }
    //좌우반전
    static void op2() {
        int bound = m / 2;
        int temp;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < bound ; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[i][m - 1 - j];
                arr[i][m - 1 - j] = temp;
            }
        }
    }
    static void op3() {
        int[][] ret = new int[m][n];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                ret[j][n - 1 - i] = arr[i][j];
            }
        }
        arr = new int[m][n];
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                arr[i][j] = ret[i][j];
            }
        }
        int temp = n;
        n = m;
        m = temp;
    }
    static void op4() {
        int[][] ret = new int[m][n];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                ret[m - j - 1][i] = arr[i][j];
            }
        }
        arr = new int[m][n];
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                arr[i][j] = ret[i][j];
            }
        }
        int temp = n;
        n = m;
        m = temp;
    }
    static void op5() {
        /*
        1번배열 0 <= i < n/2  &  0 <= j < m/2
        2번배열 n/2 <= i < n  &  0 <= j < m/2
        3번배열 n/2 <= i < n  &  m/2 <= j < m
        4번배열 0 <= i < n/2  &  m/2 <= j < m

        1번의 (x, y)에 대하여 각각의 소배열에 대응되는 자리는
        2번 : (x, y + m/2)
        3번 : (x + n/2, y + m/2)
        4번 : (x + n/2, y)
        */
        int xhalf = n/2;
        int yhalf = m/2;
        int temp;
        for(int i = 0 ; i < xhalf ; i++) {
            for(int j = 0 ; j < yhalf ; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[i+xhalf][j];
                arr[i+xhalf][j] = arr[i+xhalf][j+yhalf];
                arr[i+xhalf][j+yhalf] = arr[i][j+yhalf];
                arr[i][j+yhalf] = temp;
            }
        }
    }
    static void op6() {
        int xhalf = n/2;
        int yhalf = m/2;
        int temp;
        for(int i = 0 ; i < xhalf ; i++) {
            for(int j = 0 ; j < yhalf ; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[i][j+yhalf];
                arr[i][j+yhalf] = arr[i+xhalf][j+yhalf];
                arr[i+xhalf][j+yhalf] = arr[i+xhalf][j];
                arr[i+xhalf][j] = temp;
            }
        }
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < r ; i++) {
            int op = Integer.parseInt(st.nextToken());
            if(op == 1) op1();
            if(op == 2) op2();
            if(op == 3) op3();
            if(op == 4) op4();
            if(op == 5) op5();
            if(op == 6) op6();
        }
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
//        for(int[] b : arr) System.out.println(Arrays.toString(b));
        System.out.print(sb);
    }
}