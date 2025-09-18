import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        if(n == 1) {
            System.out.println(1);
            return;
            //2부터인줄 알았는데 1부터네 이래서 틀린듯
        }
        
        
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        int[] inc = new int[n];
        int[] dec = new int[n];

        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //dp로 풀 수 있다
        //이전 상태들이 다음 상태에 영향을 줌
        //애초에 n^2은 안되기도 하고

        int ans = 0;
        inc[0] = 1;
        dec[0] = 1;
        //inc, dec의 i번째 값 = i번째 값이 몇번째로 단조증가/단조감소 중인지
        //기본값은 0이 아닌 1로 줌. 하나만 있어도 증가/감소 상태로 볼 수 있으므로..

        for(int i = 1 ; i < n ; i++) {
            if(arr[i - 1] < arr[i]) {
                inc[i] = inc[i - 1] + 1;
                dec[i] = 1;
                if(ans < inc[i]) ans = inc[i];
            } else if(arr[i - 1] > arr[i]) {
                inc[i] = 1;
                dec[i] = dec[i - 1] + 1;
                if(ans < dec[i]) ans = dec[i];
            } else {
                inc[i] = inc[i - 1] + 1;
                dec[i] = dec[i - 1] + 1;
                int temp = Math.max(inc[i], dec[i]);
                if(ans < temp) ans = temp;
            }
        }
        System.out.println(ans);


    }
}