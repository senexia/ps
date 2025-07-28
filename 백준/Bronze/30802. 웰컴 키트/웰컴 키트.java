import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] size = new int[6];
        for(int i = 0 ; i < 6 ; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int bundle = Integer.parseInt(st.nextToken());
        int pen = Integer.parseInt(st.nextToken());
        int sumt = 0;
        for(int i : size) sumt += Math.ceil((double) i / bundle);
        int p1 = n / pen;
        int p2 = n % pen;
        bw.write(String.valueOf(sumt) + "\n");
        bw.write(String.valueOf(p1) + " " + String.valueOf(p2));
        bw.flush();
        bw.close();
    }
}
