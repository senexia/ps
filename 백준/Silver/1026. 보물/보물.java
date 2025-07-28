import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        int[] a = new int[tc];
        int[] b = new int[tc];
        int sum = 0;

        String[] t1 = br.readLine().split(" ");
        String[] t2 = br.readLine().split(" ");

        for(int i = 0 ; i < tc ; i++) {
            a[i] = Integer.parseInt(t1[i]);
            b[i] = Integer.parseInt(t2[i]);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i = 0 ; i < tc ; i++) {
            sum += b[i] * a[tc - i - 1];
        }
        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
    }
}