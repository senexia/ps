import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] chess = {1,1,2,2,2,8};
        String[] ipt = br.readLine().split(" ");
        String res = "";

        for(int i = 0 ; i < 6 ; i++) {
            res += chess[i] - Integer.parseInt(ipt[i]);
            res += " ";
        }
        bw.write(res);
        bw.flush();
        bw.close();
    }
}