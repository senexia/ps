import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++) {
            String e = " ";
            String s = "*";
            bw.write(e.repeat(n-i) + s.repeat(2 * i - 1)+ "\n");
        }



        bw.flush();
        bw.close();
    }
}