import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = 0 ; i < n ; i++) {
            String s = br.readLine();

            if(s.equals("ENTER")) {
                cnt += set.size();
                set.clear();
            } else {
                set.add(s);
            }
        }
        cnt += set.size();
        System.out.println(cnt);

    }

}