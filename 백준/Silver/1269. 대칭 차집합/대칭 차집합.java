import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < a ; i++) {
            s1.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < b ; i++) {
            s2.add(Integer.parseInt(st.nextToken()));
        }
        if(a > b) {
            for(int n : s2) {
                if(s1.contains(n)) c++;
            }
        } else {
            for(int n : s1) {
                if(s2.contains(n)) c++;
            }
        }
        System.out.println(a + b - 2 * c);
    }
}