import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < cnt ; i++) {
            String[] infos = br.readLine().split(" ");
            int repeat = Integer.parseInt(infos[0]);
            String[] chars = infos[1].split("");
            String res = "";
            for(String s : chars) {
                res += s.repeat(repeat);
            }
            bw.write(res + "\n");
        }


        bw.flush();
        bw.close();
    }
}