import java.io.*;
import java.util.*;

public class Main {
    static int[] uf;

    static int find(int x) {
        if(x == uf[x]) return x;
        return uf[x] = find(uf[x]);
    }

    static boolean union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if(a != b) {
            uf[b] = a;
            return true;
        }
        //0 1 2  -> 0 1 1
        //y를 변경

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int cnt = 0;

        uf = new int[n + 1];
        for(int i = 0 ; i < n + 1 ; i++) uf[i] = i;

        for(int i = 0 ; i < m ; i++) {
            int ipt = Integer.parseInt(br.readLine());
            int e = ipt;
            boolean placed = false;

            while(true) {
                //그냥 무조건. N이 들어오면 최대한 N에 가까운 곳에 넣는다
                //유파를 이렇게밖에 못쓰겠는데 풀이가 뭔지 모르겠음
                //0부터 N까지 루프돌면서 비어있는지를 find로 줄이는게 의도인건지
                if(e == 0) break;

                if(uf[e] == e) {
                    uf[e] = e - 1;
                    cnt++;
                    placed = true;
                    break;
                } else {
                    e = find(uf[e]);
                }
            }
            if(!placed) break;
        }
        System.out.println(cnt);
    }
}