
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;

    static int max = 0;


    static void threeByTwo() {
        //세로3 가로2
        /*              가능한 모양
        ■         ■     ■         ■     ■ ■     ■ ■
        ■         ■     ■ ■     ■ ■       ■     ■
        ■ ■     ■ ■       ■     ■         ■     ■

        ■ ■             ■         ■
        ■ ■     ■ ■     ■ ■     ■ ■
                ■ ■     ■         ■
        */
        for(int i = 0 ; i < n - 2 ; i++) {
            for(int j = 0 ; j < m - 1 ; j++) {
                int tsum = arr[i][j] + arr[i][j+1]
                        + arr[i+1][j] + arr[i+1][j+1]
                        + arr[i+2][j] + arr[i+2][j+1];
                //순서대로 윗줄 6개
                if(max < tsum - arr[i][j+1] - arr[i+1][j+1]) max = tsum - arr[i][j+1] - arr[i+1][j+1];
                if(max < tsum - arr[i][j] - arr[i+1][j]) max = tsum - arr[i][j] - arr[i+1][j];
                if(max < tsum - arr[i][j+1] - arr[i+2][j]) max = tsum - arr[i][j+1] - arr[i+2][j];
                if(max < tsum - arr[i][j] - arr[i+2][j+1]) max = tsum - arr[i][j] - arr[i+2][j+1];
                if(max < tsum - arr[i+1][j] - arr[i+2][j]) max = tsum - arr[i+1][j] - arr[i+2][j];
                if(max < tsum - arr[i+1][j+1] - arr[i+2][j+1]) max = tsum - arr[i+1][j+1] - arr[i+2][j+1];


                //순서대로 아래 4개
                if(max < tsum - arr[i+2][j] - arr[i+2][j+1]) max = tsum - arr[i+2][j] - arr[i+2][j+1];
                if(max < tsum - arr[i][j] - arr[i][j+1]) max = tsum - arr[i][j] - arr[i][j+1];
                if(max < tsum - arr[i][j+1] - arr[i+2][j+1]) max = tsum - arr[i][j+1] - arr[i+2][j+1];
                if(max < tsum - arr[i][j] - arr[i+2][j]) max = tsum - arr[i][j] - arr[i+2][j];
            }
        }
    }

    static void twoByThree() {
        //세로2 가로3
        /*             가능한 모양
        ■ ■ ■       ■ ■ ■         ■ ■         ■
            ■       ■           ■ ■         ■ ■ ■

            ■       ■           ■ ■         ■ ■ ■
        ■ ■ ■       ■ ■ ■         ■ ■         ■
        */
        for(int i = 0 ; i < n - 1 ; i++) {
            for(int j = 0 ; j < m - 2 ; j++) {
                int tsum = arr[i][j] + arr[i][j+1] + arr[i][j+2]
                        + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2];

                //순서대로 윗줄 4개
                if(max < tsum - arr[i+1][j] - arr[i+1][j+1]) max = tsum - arr[i+1][j] - arr[i+1][j+1];
                if(max < tsum - arr[i+1][j+1] - arr[i+1][j+2]) max = tsum - arr[i+1][j+1] - arr[i+1][j+2];
                if(max < tsum - arr[i][j] - arr[i+1][j+2]) max = tsum - arr[i][j] - arr[i+1][j+2];
                if(max < tsum - arr[i][j] - arr[i][j+2]) max = tsum - arr[i][j] - arr[i][j+2];

                //순서대로 아래 4개
                if(max < tsum - arr[i][j] - arr[i][j+1]) max = tsum - arr[i][j] - arr[i][j+1];
                if(max < tsum - arr[i][j+1] - arr[i][j+2]) max = tsum - arr[i][j+1] - arr[i][j+2];
                if(max < tsum - arr[i+1][j] - arr[i][j+2]) max = tsum - arr[i+1][j] - arr[i][j+2];
                if(max < tsum - arr[i+1][j] - arr[i+1][j+2]) max = tsum - arr[i+1][j] - arr[i+1][j+2];
            }
        }
    }

    static void oneByFour() {
        for(int i = 0 ; i < n - 3 ; i++) {
            for(int j = 0 ; j < m ; j++) {
                int sum = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+3][j];
                if(max < sum) max = sum;
            }
        }
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m - 3 ; j++) {
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i][j+3];
                if(max < sum) max = sum;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        threeByTwo();
        twoByThree();
        oneByFour();
        System.out.println(max);


    }
}