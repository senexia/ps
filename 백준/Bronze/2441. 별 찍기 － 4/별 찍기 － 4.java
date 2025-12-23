import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < n ; t++) {
            for(int i = 0 ; i < t ; i++) {
                sb.append(" ");
            }
            for(int i = 0 ; i < n - t ; i++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}