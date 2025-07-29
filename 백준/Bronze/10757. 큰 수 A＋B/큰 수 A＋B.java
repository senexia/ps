
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        BigInteger b1 = new BigInteger(st.nextToken());
        BigInteger b2 = new BigInteger(st.nextToken());
        b1 = b1.add(b2);
        System.out.println(b1.toString());
    }
}