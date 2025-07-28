import java.util.*;
import java.io.*;

public class Main {
    static int[] zeros;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int i = 1;
        while(true) {
            if(n > 3*i*(i-1) + 1) i++;
            else break;
        }
        bw.write(String.valueOf(i));
        bw.flush();
        bw.close();
    }
}
