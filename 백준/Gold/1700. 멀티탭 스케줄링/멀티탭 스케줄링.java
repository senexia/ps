import java.io.*;
import java.util.*;

public class Main {
    /*
    맨 처음 풀이
    지금 플러그에 들어가있는 번호를 저장해둘 hashset을 둔다.

    맨 처음 플러그 개수만큼은 그냥 set에 넣고, 배열 원소 하나씩 보면서
    이후에는 set에 포함이면 continue
    그렇지 않으면 각 set의 원소들에 대해 가장 나중에 쓰는애를 교체하면 되는듯

    testcase ac 돌려보니까 아이디어는 맞는데 맨처음에 다꽂는게 틀림

    왜? 예를 들어 n=4, k=6이라 하고 입력이 1 1 2 2 3 4라 하자.

    그러면 그냥 n개 꽂고 시작한다고 하면 1 1 2 2를 꽂고 3 4를 갱신하는 과정에서 cnt가 2로 찍힘
    근데 사실 손으로 해보면 1이랑 2는 이미 꽂혀있으니 3 4를 빈 두자리에 꽂으면 cnt는 0임
    그래서 그냥 n개 꽂는게 아니라 hashset사이즈가 n될때까지 꽂는다로 바꿔야 할듯
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n >= k) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine(), " ");

        int cnt = 0;
        int[] arr = new int[k];
        for(int i = 0 ; i < k ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> plug = new HashSet<>();
        int ptr = 0;
        while(plug.size() < n) {
            if(!plug.contains(arr[ptr])) {
                plug.add(arr[ptr]);
            }
            ptr++;
            if(ptr >= k) break;
        }
//        이부분이 맨처음에 틀린 코드
//        for(int i = 0 ; i < n ; i++) {
//            plug.add(arr[i]);
//        }

        for(int i = ptr ; i < k ; i++) {
            if(plug.contains(arr[i])) continue;

            int max = -1;
            int argmax = -1;
            for(int idx : plug) {
                int end = -1;
                int c = 0;
                for(int j = i ; j < k ; j++) {
                    if(arr[j] == idx) {
                        end = j;
                        break;
                    }
                    c++;
                }

                if(end == -1) {
                    argmax = idx;
                    break;
                }

                if(max < end) {
                    max = end;
                    argmax = idx;
                }
            }
            plug.remove(argmax);
            plug.add(arr[i]);
            cnt++;
        }
        System.out.println(cnt);


    }
}