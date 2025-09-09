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

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static int kmp(String ent, String pat) {
        int[] t = gen(pat);
        int l1 = ent.length();
        int l2 = pat.length();
        int st = 0;
        int find = 0;
        int cnt = 0;

        while (st <= l1 - l2) {
            if (find < l2 && ent.charAt(st + find) == pat.charAt(find)) {
                ++find;
                if (find == l2) {
                    cnt++;
                    st += find - t[find - 1];
                    find = t[find - 1];
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
        return cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String s1 = br.readLine().replaceAll("\\s", "");
        String s2 = br.readLine().replaceAll("\\s", "");

        //int cnt = kmp(s2.concat(s2), s1) - 1;
        //이건 왜 안되냐
        int cnt = kmp(s2.concat(s2.substring(0, n-  1)), s1);
        System.out.println((cnt / gcd(n, cnt)) + "/" + (n / gcd(cnt, n)));
    }
}