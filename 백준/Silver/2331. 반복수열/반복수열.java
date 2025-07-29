
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;

        map.put(x, 1);
        int i = 2;
        while(true) {
            int sum = 0;
            while(x > 0) {
                int adder = 1;
                for(int j = 0 ; j < p ; j++) {
                    adder *= (x % 10);
                }
                sum += adder;
                x /= 10;
            }
            if(map.containsKey(sum)) {
                res = map.get(sum);
                break;
            } else {
                map.put(sum, i++);
                x = sum;
            }
        }
        System.out.println(res - 1);
    }
}