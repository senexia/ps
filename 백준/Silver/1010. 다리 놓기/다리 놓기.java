import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        int[][] comb = new int[31][31];
        comb[0][0] = 1;
        for(int i = 0 ; i < 30 ; i++) {
            comb[i][i] = 1;
            comb[i][0] = 1;
            if(i >= 2) {
                for(int j = 1 ; j < i ; j++) {
                    comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
                }
            }
        }
//        for(int[] b : comb) System.out.println(Arrays.toString(b));

        StringTokenizer st;
        for(int i = 0 ; i < tc ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(comb[n][r]) + "\n");
        }
        bw.flush();
        bw.close();
    }
}