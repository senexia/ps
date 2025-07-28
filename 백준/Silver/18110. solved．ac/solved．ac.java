import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        int[] vote = new int[m];
        int sum = 0;
        if(m == 0) {
            bw.write("0");
            bw.close();
            return;
        }

        int trunc = (int)Math.round(m * 0.5 * 0.3);
//        System.out.println(trunc);
        for(int i = 0 ; i < m ; i++) {
            vote[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(vote);
        for(int i = trunc ; i < m - trunc ; i++) {
            sum += vote[i];
        }
//        System.out.println("sum : " + sum);
//        System.out.println("denom : " + (m - 2*trunc));
        int ret = (int)Math.round((double)(sum)/(m - 2*trunc));
        bw.write(String.valueOf(ret));
        bw.flush();
        bw.close();
    }
}
