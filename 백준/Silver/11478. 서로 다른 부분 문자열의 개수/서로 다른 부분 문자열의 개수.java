import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> s = new HashSet<>();

        String gs = br.readLine();
//        System.out.println(gs.substring(4, 5));
        for(int i = 0 ; i < gs.length() ; i++) {
            for(int j = i + 1 ; j <= gs.length() ; j++) {
                s.add(gs.substring(i, j));
            }
        }
        System.out.println(s.size());
    }
}