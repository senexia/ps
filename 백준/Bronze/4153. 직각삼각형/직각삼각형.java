import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            while (true) {
                String s = br.readLine();
                if(s.equals("0 0 0")) break;
                StringTokenizer st = new StringTokenizer(s, " ");
                int[] r = new int[3];
                for(int i = 0 ; i < 3 ; i++) {
                    r[i] = Integer.parseInt(st.nextToken());
                }
                Arrays.sort(r);
                if(r[2] * r[2] == r[1] * r[1] + r[0] * r[0]) {
                    bw.write("right\n");
                } else {
                    bw.write("wrong\n");
                }


            }
            bw.flush();
            bw.close();
        }


}
