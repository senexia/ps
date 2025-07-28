import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] infos = br.readLine().split(" ");
        int cnt = Integer.parseInt(infos[0]);
        int val = Integer.parseInt(infos[1]);
        int gaesu = 0;

        int[] coingazua = new int[cnt];
        for(int i = 0 ; i < cnt ; i++) {
            coingazua[i] = Integer.parseInt(br.readLine());
        }
        for(int i = cnt - 1 ; i>=0 ; i--) {
            if(coingazua[i] <= val) {
                gaesu += (val / coingazua[i]);
                val -= (val / coingazua[i]) * coingazua[i];
            }
        }

        bw.write(String.valueOf(gaesu));




        bw.flush();
        bw.close();
    }
}