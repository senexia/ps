import java.io.*;
import java.util.*;

public class Main {
    static int sqrt;
    static int LAST_BLOCK_SIZE;
    static int LAST_INDEX;
    static int[] arr;
    static int[] odd;
    static int[] lazy;
    static StringBuilder sb = new StringBuilder();

    static void flip(int tgt) {
        int old = arr[tgt];
        int add = lazy[tgt / sqrt];
        arr[tgt]++;
        if((old + add) % 2 == 0) odd[tgt / sqrt]++;
        else odd[tgt / sqrt]--;
        //1개 단위로 뒤집고, 걔 포함된 버킷의 홀수 개수 변경
    }

    static void inv(int start, int end) {
        int s = start / sqrt;
        int e = end / sqrt;
        if(s == e) {
            for(int i = start ; i <= end ; i++) {
                flip(i);
            }
        } else {
            for(int i = start ; i < (s + 1) * sqrt ; i++) {
                flip(i);
            }
            for(int i = s + 1 ; i < e ; i++) {
                //블록의 모든 값이 뒤집어지므로, (전체 개수) - (현재 개수)가 다음 odd개수가 됨
                lazy[i]++;
                if(i == LAST_INDEX) {
                    odd[i] = LAST_BLOCK_SIZE - odd[i];
                } else {
                    odd[i] = sqrt - odd[i];
                }
            }
            for(int i = e * sqrt ; i <= end ; i++) {
                flip(i);
            }
        }
    }

    static void cal(int start, int end) {
        int s = start / sqrt;
        int e = end / sqrt;
        int cnt = 0;
        if(s == e) {
            int add = lazy[s];
            for(int i = start ; i <= end ; i++) {
                if((arr[i] + add) % 2 != 0) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
            return;
        }

        int add = lazy[s];
        for(int i = start ; i < (s + 1) * sqrt ; i++) {
            if((arr[i] + add) % 2 != 0) {
                cnt++;
            }
        }
        for(int i = s + 1 ; i < e ; i++) {
            cnt += odd[i];
        }
        add = lazy[e];
        for(int i = e * sqrt ; i <= end ; i++) {
            if((arr[i] + add) % 2 != 0) {
                cnt++;
            }
        }
        sb.append(cnt).append("\n");
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        sqrt = (int)Math.sqrt(n);

        //짝수 = 꺼짐, 홀수 = 켜짐
        arr = new int[n];
        odd = new int[1 + (n-1)/sqrt];
        lazy = new int[1 + (n-1)/sqrt];

        LAST_BLOCK_SIZE = (n == sqrt * sqrt ? sqrt : n - (sqrt * sqrt));
        //마지막 잔잔바리 블록 크기
        LAST_INDEX = (n-1)/sqrt;             //마지막 잔잔바리 블록 인덱스
        //블록 단위로 뒤집어버릴거라 해당 블록 인덱스를 알아야 함
        //다른 블록은 내부 원소 개수가 sqrt개라는걸 알고 있지만 얘는 모르므로 전처리
//        System.out.println(LAST_BLOCK_SIZE);

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            if(a == 0) inv(b, c);
            else cal(b, c);
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}