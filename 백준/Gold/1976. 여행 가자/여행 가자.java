import java.io.*;
import java.util.*;

public class Main {
    static int[] uf;

    static int find(int x) {
        if(x == uf[x]) return x;
        return uf[x] = find(uf[x]);
    }

    static void union(int x, int y) {
        if(find(x) != find(y)) {
            uf[find(x)] = find(y);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        uf = new int[n + 1];
        for(int i = 1 ; i <= n ; i++) uf[i] = i;
        for(int i = 1 ; i <= n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= n ; j++) {
                int tok = Integer.parseInt(st.nextToken());
                if(tok == 1) {
                    union(i, j);
                }
            }
        }

        int temp = 0;
        boolean movable = true;
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            if(temp == 0) temp = find(Integer.parseInt(st.nextToken()));
            else {
                if(temp != find(Integer.parseInt(st.nextToken()))) {
                    movable = false;
                    break;
                }
            }
        }
        System.out.println(movable ? "YES" : "NO");

    }
}