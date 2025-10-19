import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    /*
        모노톤 스택 느낌으로 돌리면서
        단조성 깨지면 peek를 제외한 나머지를 가능한만큼 지우면 될 듯
        지우는 개수가 스택에 들어있는 개수보다 많다면,
        가장 마지막 애들을 지우는 식으로 = 전체 숫자 기준 왼쪽에 가까운 애들 = 스택 먼저 들어간 애들

        1924에서
        9를 보고있으면 단조감소가 깨짐. 가능한만큼 지우면 924. 9를 넣고
        9 -> 92 -> 924 
        에서 마지막에 4를 보면 또 단조성 깨짐. 남은 지우는 횟수 1이므로 2를 지우면 94
        
        만약 끝까지 봤는데 남으면?
        가장 작은 자리수 (스택에 남아있는 애들중 top에 가까운 애들) 애들을 남은 횟수만큼 싹 지우면 됨


     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
//        System.out.println((double)500000 * 4 / (1024 * 1024));

        int n = Integer.parseInt(st.nextToken());
        int left = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        boolean[] v = new boolean[n];

        String s = br.readLine();
        for(int i = 0 ; i < n ; i++) {
            arr[i] = s.charAt(i) - '0';
        }

        stack.push(0);
        for(int i = 1 ; i < n ; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i] && left > 0) {
                v[stack.pop()] = true;
                left--;
            }
            stack.push(i);
        }

        //지울게 더 남았다면 가장 작은 자리수를 지움
        for(int i = 0 ; i < left ; i++) {
            v[stack.pop()] = true;
        }
        for(int i = 0 ; i < n ; i++) {
            if(!v[i]) sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}