import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            String s1 = br.readLine();
            String s2 = br.readLine();
            int len = s1.length();

            int c = 0;
            for(int j = 0 ; j < len ; j++) {
                if(s1.charAt(j) != s2.charAt(j)) c++;
            }

            sb.append("Hamming distance is ").append(c).append(".\n");

        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}