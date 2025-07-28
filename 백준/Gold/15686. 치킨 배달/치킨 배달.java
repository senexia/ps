import java.io.*;
import java.util.*;


public class Main {
    static int n, m;
    static int ret = Integer.MAX_VALUE;

    static List<int[]> house = new ArrayList<>();
    static List<int[]> chick = new ArrayList<>();
    static boolean[] v;

    static void comb(int idx, int cnt) {
        if (cnt == m) {
            int sum = 0;
            for (int[] h : house) {
                int hd = Integer.MAX_VALUE;
                for (int i = 0; i < chick.size(); i++) {
                    if (v[i]) {
                        int d = Math.abs(h[0] - chick.get(i)[0]) + Math.abs(h[1] - chick.get(i)[1]);
                        hd = d < hd ? d : hd;
                    }
                }
                sum += hd;
            }
            if (sum < ret) ret = sum;
            return;
        }
        if (idx == chick.size()) return;
        v[idx] = true;
        comb(idx + 1, cnt + 1);
        v[idx] = false;
        comb(idx + 1, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) house.add(new int[]{i, j});
                else if (x == 2) chick.add(new int[]{i, j});
            }
        }

        v = new boolean[chick.size()];
        comb(0, 0);
        System.out.println(ret);
    }

}
