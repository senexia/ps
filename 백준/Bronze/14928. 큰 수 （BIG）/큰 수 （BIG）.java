import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int rem = 0;
        int div = 20000303;
        for(int i = 0 ; i < s.length() ; i++) {
            int cur = s.charAt(i) - '0';
            rem = (10 * rem + cur) % div;
        }
        System.out.println(rem);
    }
}