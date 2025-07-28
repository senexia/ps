import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < c ; i++) {
            String ipt = br.readLine();
            int cnt = 0;
            int sum = 0;

            for(int j = 0 ; j < ipt.length() ; j++) {
                if(ipt.charAt(j) == 'O') {
                    cnt++;
                } else {
                    sum += cnt * (cnt + 1) / 2;
                    cnt = 0;
                }
            }
            sum += cnt * (cnt + 1) / 2;
            bw.write(String.valueOf(sum) + "\n");

        }

        bw.flush();
        bw.close();
    }
}