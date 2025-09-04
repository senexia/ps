import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, sqrt;
    static int mod = 1000000007;
    static int[] arr;
    static long[] bucket;
    static int[] zerocnt;
    static boolean[] lazy;
    static StringBuilder sb = new StringBuilder();

    static void modify(int loc, int val) {
        //0을 0이 아닌거로 바꾸기
        //0이 아닌걸 0으로 바꾸기
        if(val == 0) {
            if(arr[loc - 1] != 0) zerocnt[(loc - 1)/sqrt]++;
            //0이 아닌걸 0으로 바꾸면 zero 개수 늘려줌
            //0을 0으로 바꾸면 뭐 걍 두면 되니까

        } else {
            if(arr[loc - 1] == 0) zerocnt[(loc - 1)/sqrt]--;
            //0을 0이 아닌거로 바꾸면 zero 개수 빼줌
            //0아닌거 -> 0아닌거는 상관X
        }
        arr[loc - 1] = val;
        lazy[(loc - 1)/sqrt] = true;
    }

    static void cal(int start, int end) {
        long prod = 1;
        int s = (start - 1) / sqrt;
        int e = (end - 1) / sqrt;
        if(s == e) {
            for(int i = start - 1 ; i <= end - 1 ; i++) {
                prod = (prod * arr[i]) % mod;
            }
            sb.append(prod).append("\n");
            return;
        }

        for(int i = start - 1 ; i < (s + 1) * sqrt ; i++) {
            prod = (prod * arr[i]) % mod;
        }
        for(int i = s + 1 ; i < e ; i++) {
            if(zerocnt[i] != 0) {
                //0인게 블럭 내부에 있으면 걍 전체 0이니까 계산 안해도 됨
                sb.append(0).append("\n");
                return;
            } else {
                if(!lazy[i]) {
                    prod = (prod * bucket[i]) % mod;
                    //lazy가 false라는 말은 이 block은 개선사항이 없다는거
                    //= 그냥 그대로 쓰면 된다.
                } else {
                    //lazy가 true면 이 블록은 내부에 개선사항이 있었음
                    //블럭 단위 다시 계산한 뒤 lazy를 다시 false로.
                    long temp = 1;
                    for(int j = i * sqrt ; j < (i + 1) * sqrt ; j++) {
                        temp = (temp * arr[j]) % mod;
                    }
                    bucket[i] = temp;
                    lazy[i] = false;
                    prod = (prod * temp) % mod;
                }
            }
        }
        for(int i = e * sqrt ; i <= end - 1 ; i++) {
            prod = (prod * arr[i]) % mod;
        }
        sb.append(prod).append("\n");
        return;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        sqrt = (int)Math.sqrt(n);

        arr = new int[n];
        bucket = new long[1 + (n-1)/sqrt];
        zerocnt = new int[1 + (n-1)/sqrt];
        lazy = new boolean[1 + (n-1)/sqrt];

        Arrays.fill(bucket, 1);

        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            bucket[i / sqrt] = (bucket[i / sqrt] * arr[i]) % mod;
            if(arr[i] == 0) zerocnt[i / sqrt]++;
        }

        for(int i = 0 ; i < m + k ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1) modify(b, c);
            else cal(b, c);
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}