import java.io.*;
import java.util.*;

public class Main {
    static ArrayDeque<Integer> q = new ArrayDeque<>();

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
                    q.offer(st + 1);
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
        StringBuilder sb = new StringBuilder();

        String s1 = br.readLine();
        String s2 = br.readLine();

        sb.append(kmp(s1, s2)).append("\n");
        while(!q.isEmpty()) {
            int x = q.poll();
            sb.append(x).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}