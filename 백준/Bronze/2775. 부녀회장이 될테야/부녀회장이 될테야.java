import java.util.*;
import java.io.*;

public class Main {
    static int[][] apt = new int[15][14];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < 14 ; i++) {
            apt[0][i] = i+1;
            apt[i+1][0] = 1;
        }
        for(int cmd = 1 ; cmd <= 14 ; cmd++) {
            for(int gh = 1 ; gh < 14 ; gh++) {
                apt[cmd][gh] = apt[cmd][gh-1] + apt[cmd-1][gh];
            }
        }
//        for(int[] a : apt) System.out.println(Arrays.toString(a));
        for(int i = 0 ; i < n ; i++) {
            int cmd = Integer.parseInt(br.readLine());
            int gh = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(apt[cmd][gh-1]) + "\n");
        }
        bw.flush();
        bw.close();
    }
}