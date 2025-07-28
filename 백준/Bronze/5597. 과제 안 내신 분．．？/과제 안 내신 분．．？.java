import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] hw = new boolean[30];
        Arrays.fill(hw, false);
        for(int i = 0 ; i < 28 ; i++) {
            int idx = Integer.parseInt(br.readLine()) - 1;
            hw[idx] = true;
        }
        for(int i = 0 ; i < 30 ; i++) {
            if(!hw[i]) {
                bw.write(Integer.toString(i + 1));
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
    }
}