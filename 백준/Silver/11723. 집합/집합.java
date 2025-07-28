import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        boolean[] set = new boolean[21];
        String[] ipt = new String[2];
        for(int i = 0 ; i < m ; i++) {
            ipt = br.readLine().split(" ");
            if (ipt[0].equals("add")) {
                int x = Integer.parseInt(ipt[1]);
                set[x] = !set[x] ? true : set[x];
            }
            if (ipt[0].equals("remove")) {
                int x = Integer.parseInt(ipt[1]);
                set[x] = set[x] ? false : set[x];
            }
            if (ipt[0].equals("check")) {
                int x = Integer.parseInt(ipt[1]);
                bw.write(set[x] ? "1\n" : "0\n");
            }
            if (ipt[0].equals("toggle")) {
                int x = Integer.parseInt(ipt[1]);
                set[x] = !set[x];
            }
            if (ipt[0].equals("all")) {
                Arrays.fill(set, true);
            }
            if (ipt[0].equals("empty")) {
                Arrays.fill(set, false);
            }
        }
        bw.flush();
        bw.close();
    }
}
