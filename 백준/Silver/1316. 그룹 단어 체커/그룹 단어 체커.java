import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        int cnt = 0;
        int[] chars = new int[26];

        for(int i = 0 ; i < tc ; i++) {
            boolean flag = false;
            Arrays.fill(chars, -1);
            String ipt = br.readLine();
            for(int j = 0 ; j < ipt.length() ; j++) {
                if(chars[ipt.charAt(j) - 'a'] == -1 || chars[ipt.charAt(j) - 'a'] == j - 1) {
                    chars[ipt.charAt(j) - 'a'] = j;
                } else {
                    flag = true;
                }
            }
            if(!flag) cnt++;
        }
        System.out.println(cnt);



    }
}