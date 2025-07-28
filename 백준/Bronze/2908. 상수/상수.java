import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt = br.readLine().split(" ");
        String[] d1 = ipt[0].split("");
        String[] d2 = ipt[1].split("");

        int n1 = Integer.parseInt(d1[2]) * 100 + Integer.parseInt(d1[1]) * 10 + Integer.parseInt(d1[0]);
        int n2 = Integer.parseInt(d2[2]) * 100 + Integer.parseInt(d2[1]) * 10 + Integer.parseInt(d2[0]);
        bw.write(Integer.toString(Math.max(n1, n2)));

        bw.flush();
        bw.close();
    }
}