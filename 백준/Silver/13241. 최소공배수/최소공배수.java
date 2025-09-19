import java.io.*;
import java.util.*;

public class Main {
    static long gcd(long a, long b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        //정수론 깔짝 하는 문제
        //a * b = gcd(a, b) * lcm(a, b)임을 이용한다.

        Long a = Long.parseLong(st.nextToken());
        Long b = Long.parseLong(st.nextToken());

        Long gcd = gcd(a, b);
        System.out.println(a * b / gcd);
    }
}