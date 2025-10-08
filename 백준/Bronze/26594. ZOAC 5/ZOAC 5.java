import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char c = s.charAt(0);
        int cnt = 1;
        int b = s.length();
        for(int i = 1 ; i < b ; i++) {
            if(s.charAt(i) != c) break;

            cnt++;
        }
        System.out.println(cnt);
    }
}