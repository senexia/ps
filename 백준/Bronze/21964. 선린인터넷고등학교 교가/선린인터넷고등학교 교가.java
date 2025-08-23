import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        br.readLine();
        String s = br.readLine();
        int len = s.length();
        for(int i = len - 5 ; i < len ; i++) {
            sb.append(s.charAt(i));
        }
        System.out.println(sb);
    }
}