import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = 0;
        for(int i = 0 ; i < 5 ; i++) {
            int k = Integer.parseInt(st.nextToken());
            s += k * k;
        }
        bw.write(String.valueOf(s % 10));


        bw.flush();
        bw.close();
    }
}