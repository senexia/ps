import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        HashSet<Integer> hs;

        for(int t = 0 ; t < n ; t++) {
            hs = new HashSet<>();
            int x = Integer.parseInt(st.nextToken());

            //약수 전부 구해서 set에 넣음
            for(int i = 1 ; i * i <= x ; i++) {
                if(x % i == 0) {
                    hs.add(i);
                    hs.add(x / i);
                }
            }

            int sum = 0;
            for(int i : hs) {
                if(x == i) continue;
                sum += i;
            }

            if(sum < x) sb.append("Deficient\n");
            else if(sum == x) sb.append("Perfect\n");
            else sb.append("Abundant\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}