import java.io.*;
import java.util.*;

public class Main {
    /*
    000
    110
    001
    010


    000
    011
    101
    010
    순서 무관하다고 가정하면 i번째 전구의 상태는 i+1번째를 고른 뒤에는 변하지 않음
    1트) i-1, i, i+1번째 중 하나라도 다르면 누른다 -> 틀림

    2트) 어차피 왼 -> 오 로 진행한다고 하면 i+1번째는 나중에도 기회가 있으므로
    i번째를 누르는 기준을 i-1번째만 보고 선택

    그러면 첫번째는 누르는 경우, 안 누르는 경우 두 가지가 있으므로 둘다해보면 될듯
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int cnt1 = 0;
        int cnt2 = 0;

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] tgt = new int[n];

        String s1 = br.readLine();
        String s2 = br.readLine();
        for(int i = 0 ; i < n ; i++) {
            arr1[i] = s1.charAt(i) - '0';
            arr2[i] = arr1[i];
            tgt[i] = s2.charAt(i) - '0';
        }

        //첫번째 안누름
        for(int i = 1 ; i < n ; i++) {
            if(arr1[i - 1] != tgt[i - 1]) {
                for(int j = -1 ; j <= 1 ; j++) {
                    if(i + j >= 0 && i + j < n) {
                        arr1[i + j] = arr1[i + j] == 0 ? 1 : 0;
                    }
                }
                cnt1++;
            }
        }
        if(arr1[n - 1] != tgt[n - 1]) cnt1 = Integer.MAX_VALUE;

        //첫번째 누름
        arr2[0] = arr2[0] == 0 ? 1 : 0;
        arr2[1] = arr2[1] == 0 ? 1 : 0;
        cnt2++;
        for(int i = 1 ; i < n ; i++) {
            if(arr2[i - 1] != tgt[i - 1]) {
                for(int j = -1 ; j <= 1 ; j++) {
                    if(i + j >= 0 && i + j < n) {
                        arr2[i + j] = arr2[i + j] == 0 ? 1 : 0;
                    }
                }
                cnt2++;
            }
        }
        if(arr2[n - 1] != tgt[n - 1]) cnt2 = Integer.MAX_VALUE;
        int ret = Math.min(cnt1, cnt2);
        System.out.println(ret == Integer.MAX_VALUE ? -1 : ret);
    }
}