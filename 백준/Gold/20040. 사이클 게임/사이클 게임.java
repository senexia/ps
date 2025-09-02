import java.io.*;
import java.util.*;

public class Main {
    static int[] uf;

    static int find(int x) {
        if(uf[x] == x) return x;
        else return uf[x] = find(uf[x]);
    }

    static boolean union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if(a == b) return false;
        uf[a] = b;
        return true;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        uf = new int[n];
        for(int i = 0 ; i < n ; i++) uf[i] = i;

        for(int i = 1 ; i <= m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(!union(a, b)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}


