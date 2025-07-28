import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] num = new int[cnt];

        for(int i = 0 ; i < cnt ; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        int sum = 0;
        for(int i = 0 ; i < cnt ; i++) {
            sum += (num.length - i) * num[i];
        }
        System.out.println(sum);
    }
}