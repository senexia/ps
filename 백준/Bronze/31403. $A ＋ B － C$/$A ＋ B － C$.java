import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(a + b - c) + "\n");
        int d = Integer.parseInt(Integer.toString(a).concat(Integer.toString(b)));
        bw.write(String.valueOf(d - c) + "\n");


        bw.flush();
        bw.close();
    }
}