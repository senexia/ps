import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] arr = new int [9][9];
        int max = -1;
        int r = 0, c = 0;
        for(int i = 0 ; i < 9 ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < 9 ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(max < arr[i][j]) {
                    max = arr[i][j];
                    r = i + 1;
                    c = j + 1;
                }
            }
        }
        bw.write(String.valueOf(max) + "\n");
        bw.write(String.valueOf(r) + " " + String.valueOf(c));




        bw.flush();
        bw.close();
    }
}