import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());
        int[] idx = new int[6];
        int[] len = new int[6];
        int[] cnt = new int[5];
        boolean[] find = new boolean[6];

        int a1 = 1; //큰넓
        int a2 = 1; //작넓

        for(int i = 0 ; i < 6 ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            idx[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
            cnt[idx[i]]++;
        }

        for(int i = 1 ; i < 5 ; i++) {
            //하나밖에 없으면 긴 변임
            if(cnt[i] == 1) {
                for(int j = 0 ; j < 6 ; j++) {
                    if(idx[j] == i) {
                        //긴 변의 좌우에 인접한 변은 짧은 변이 아님.
                        find[(j + 1) % 6] = true;
                        find[(j + 5) % 6] = true;
                        //긴 변의 길이를 찾아서 큰넓이 먼저 구함
                        a1 *= len[j];
                    }
                }
            }
        }

        //남은 false인 변이 짧은 변이므로 작은 넓이가 나옴
        for(int i = 0 ; i < 6 ; i++) {
            if(!find[i]) a2 *= len[i];
        }

        System.out.println((a1 - a2) * k);
    }
}