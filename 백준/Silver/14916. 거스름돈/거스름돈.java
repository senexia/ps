import java.io.*;
import java.util.*;

public class Main {
    public static int[] cases;
    public static int dp(int n) {
        for(int i = 6 ; i <= n ; i++) {
            if(cases[i - 2] == -1 && cases[i - 5] == -1) cases[i] = -1;
            else {
                cases[i] = cases[i-2] + 1;
                if(cases[i - 2] != -1 && cases[i-2] + 1 < cases[i]) cases[i] = cases[i-2] + 1;
                else if(cases[i - 5] != -1 && cases[i-5] + 1 < cases[i]) cases[i] = cases[i-5] + 1;
            }
        }
        return cases[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        cases = new int[m + 1];
        if(m == 1 || m == 3) bw.write(String.valueOf(-1));
        else if (m == 2 || m == 5) bw.write(String.valueOf(1));
        else if (m == 4) bw.write(String.valueOf(2));
        else {
            cases[1] = -1;
            cases[3] = -1;
            cases[2] = 1;
            cases[4] = 2;
            cases[5] = 1;
            bw.write(String.valueOf(dp(m)));
        }


        bw.flush();
        bw.close();
    }
}