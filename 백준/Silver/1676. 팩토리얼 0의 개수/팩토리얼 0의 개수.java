import java.util.*;
import java.io.*;

public class Main {
    static int[] zeros;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int zeros = n/5 + n/25 + n/125;;
        //5^1 = 5, 5^2 = 25, 5^3 = 125, 5^4 = 625, ...
        bw.write(String.valueOf(zeros));
        bw.flush();
        bw.close();
    }
}
