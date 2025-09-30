import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[2 * n];
        int[] selected = new int[d + 1];
        //1-base로 n번 초밥이 선택되어진 개수를 저장
        int cnt = 0;
        int max = 0;

        for(int i = 0 ; i < n ; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
            sushi[i + n] = sushi[i];
        }

        //초기상태 설정
        int s = 0;
        int e = s + k - 1;
        for(int i = s ; i <= e ; i++) {
            if(selected[sushi[i]] == 0) {
                cnt++;
            }
            selected[sushi[i]]++;
        }

        if(selected[c] == 0) {
            max = cnt + 1;
        } else {
            max = cnt;
        }
        /*
        모듈러 연산은 비싸니까 배열 2배로 이어붙임
        s, e포인터 움직여서 선택된 종류 뭐있는지랑 선택된 개수 갱신

        이후 쿠폰 사용이 가능한지 여부를 파악한 뒤 max 갱신 시도
         */
        while(true) {
            if(selected[sushi[s]] == 1) cnt--;
            selected[sushi[s]]--;
            //원래 s에 대한 값 먼저 빼준 뒤 s, e 증가

            s++;
            e++;
            if(s == n) break;

            if(selected[sushi[e]] == 0) cnt++;
            selected[sushi[e]]++;

            if(selected[c] == 0) {
                max = Math.max(max, cnt + 1);
            } else {
                max = Math.max(max, cnt);
            }
        }
        System.out.println(max);
    }
}
