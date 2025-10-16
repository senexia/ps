import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> s = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        /*
        오큰수랑 비슷한데 일단 등장횟수를 알아야 함
        입력먼저받고 배열을 돌면서 보면 횟수 구하는데만 n^2

        따라서 입력받을 때 등장횟수 카운팅
        이게 되는 이유는 '해당 수보다 오른쪽에서 등장한 횟수'가 아니라 그냥 '등장한 횟수'니까

        그런다음엔 그냥 모노톤스택 문제 되는듯?

        1 1 2 3 4 2 1 이라는 입력배열을 바탕으로
        3 3 2 1 1 2 3 라는 등장횟수 배열을 뽑아냄

        등장횟수 배열로 인덱스가 들어간 모노톤스택 돌리고, 결과배열에는 입력배열값을 넣자
         */

        int[] arr = new int[n]; //입력
        int[] app = new int[n]; //등장
        int[] res = new int[n];
        int[] cnt = new int[1000001];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++) {
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
            cnt[k]++;
        }

        for(int i = 0 ; i < n ; i++) {
            app[i] = cnt[arr[i]];
        }

//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(app));

        s.push(0);
        for(int i = 1 ; i < n ; i++) {
            while(!s.isEmpty()) {
                int peek = s.peek();
                if(app[peek] < app[i]) {
                    int temp = s.pop();
                    res[temp] = arr[i];
                } else if (app[peek] >= app[i]) {
                    break;
                }
            }
            s.push(i);
        }
//        for(int i = 1 ; i < n ; i++) {
//            while(!s.isEmpty() && app[s.peek()] < app[i]) {
//                res[i] = arr[s.pop()];
//            }
//            s.push(i);
//        }
        while(!s.isEmpty()) {
            res[s.pop()] = -1;
        }
        for(int i = 0 ; i < n ; i++) {
            sb.append(res[i]).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}