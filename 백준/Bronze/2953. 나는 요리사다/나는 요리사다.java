import java.io.*;
import java.util.*;

public class Main {
    static int argmax = -1;
    static int max = -1;
    static int cnt = 1;
    static void cal(StringTokenizer st) {
        int s = 0;
        for(int i = 0 ; i < 4 ; i++) {
            s += Integer.parseInt(st.nextToken());
        }
        if(max < s) {
            argmax = cnt;
            max = s;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0 ; i < 5 ; i++) {
            cal(new StringTokenizer(br.readLine(), " "));
            cnt++;
        }
        System.out.println(argmax + " " + max);
    }
}