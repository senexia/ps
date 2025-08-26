import java.io.*;
import java.util.*;


class Op {
    int x;
    int y;
    int r;
    public Op(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}

public class Main {
    static int[] perm;
    static Op[] ops;
    static boolean[] v;
    static int[][] arr;
    static int n, m, k;
    static int ans = Integer.MAX_VALUE;
    static ArrayDeque<Integer> q = new ArrayDeque<>();

    static int calc() {
        int min = Integer.MAX_VALUE;
        for(int[] a : arr) {
            int sum = 0;
            for(int i : a) {
                sum += i;
            }
            if(min > sum) min = sum;
        }
        return min;
    }

    static void rot(Op op) {
        int x = op.x;
        int y = op.y;
        int r = op.r;
        for(int t = 0 ; t < r ; t++) {
            for(int i = y - r + t ; i <= y + r - t; i++) q.offer(arr[x - r + t][i]);
            for(int i = x - r + t + 1 ; i <= x + r - t ; i++) q.offer(arr[i][y + r - t]);
            for(int i = y + r - t - 1 ; i >= y - r + t ; i--) q.offer(arr[x + r - t][i]);
            for(int i = x + r - t - 1 ; i > x - r + t ; i--) q.offer(arr[i][y - r + t]);
        }

        for(int t = 0 ; t < r ; t++) {
            for(int i = y - r + t + 1 ; i <= y + r - t; i++) arr[x - r + t][i] = q.poll();
            for(int i = x - r + t + 1 ; i <= x + r - t ; i++) arr[i][y + r - t] = q.poll();
            for(int i = y + r - t - 1 ; i >= y - r + t ; i--) arr[x + r - t][i] = q.poll();
            for(int i = x + r - t - 1 ; i >= x - r + t ; i--) arr[i][y - r + t] = q.poll();
        }

//        while(!q.isEmpty()) System.out.print(q.poll() + " ");
//        System.out.println("Rot" + x + " " + y + " " + r);
//        for(int[] a : arr) {
//            System.out.println(Arrays.toString(a));
//        }
//        System.out.println();
    }
    static void invrot(Op op) {
        int x = op.x;
        int y = op.y;
        int r = op.r;

        for(int t = 0 ; t < r ; t++) {
            for(int i = y - r + t + 1 ; i <= y + r - t; i++) q.offer(arr[x - r + t][i]);
            for(int i = x - r + t + 1 ; i <= x + r - t ; i++) q.offer(arr[i][y + r - t]);
            for(int i = y + r - t - 1 ; i >= y - r + t ; i--) q.offer(arr[x + r - t][i]);
            for(int i = x + r - t - 1; i >= x - r + t ; i--) q.offer(arr[i][y - r + t]);
        }

        for(int t = 0 ; t < r ; t++) {
            for(int i = y - r + t ; i <= y + r - t; i++) arr[x - r + t][i] = q.poll();
            for(int i = x - r + t + 1 ; i <= x + r - t ; i++) arr[i][y + r - t] = q.poll();
            for(int i = y + r - t - 1 ; i >= y - r + t ; i--) arr[x + r - t][i] = q.poll();
            for(int i = x + r - t - 1 ; i > x - r + t ; i--) arr[i][y - r + t] = q.poll();
        }
//        System.out.println("invRot" + x + " " + y + " " + r);
//        for(int[] a : arr) {
//            System.out.println(Arrays.toString(a));
//        }
//        System.out.println();
    }

    static void dfs(int cnt) {
        if(cnt == k) {
            int c = calc();
            if(ans > c) ans = c;
            return;
        }

        for(int i = 0 ; i < k ; i++) {
            if(v[i]) continue;
            v[i] = true;
            rot(ops[i]);
            dfs(cnt + 1);
            v[i] = false;
            invrot(ops[i]);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        perm = new int[k];
        v = new boolean[k];
        for(int i = 0 ; i < k ; i++) perm[i] = i;

        ops = new Op[k];
        arr = new int[n][m];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < k ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            ops[i] = new Op(a - 1, b - 1, c);
        }

        dfs(0);
        System.out.println(ans);

    }
}