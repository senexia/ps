import java.io.*;
import java.util.*;

public class Main {
    static int[] gen(String s) {
        int len = s.length();
        int[] t = new int[len];
        int j = 0;
        for(int i = 1 ; i < len ; i++) {
            while(j > 0 && s.charAt(i) != s.charAt(j)) {
                j = t[j - 1];
            }
            if(s.charAt(i) == s.charAt(j)) {
                j++;
                t[i] = j;
            }
        }
        return t;
    }

    static boolean kmp(String ent, String pat) {
        int[] t = gen(pat);
        int l1 = ent.length();
        int l2 = pat.length();
        int st = 0;
        int find = 0;

        while (st <= l1 - l2) {
            if (find < l2 && ent.charAt(st + find) == pat.charAt(find)) {
                ++find;
                if (find == l2) {
                    return true;
                }
            } else {
                if (find == 0) {
                    ++st;
                } else {
                    st += find - t[find - 1];
                    find = t[find - 1];
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();

        System.out.println(kmp(s1, s3) && kmp(s2, s3) ? "YES" : "NO");
    }
}