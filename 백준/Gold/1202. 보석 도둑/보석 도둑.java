import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> mv = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer> v = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> m = new PriorityQueue<>();

        //우선 m을 오름차순으로 정렬
        //보석은 mv에 다 넣어두고
        //무게가 m 이하인 보석들의 가치를 v에 넣어둠
        //"무게가 m 이하이면서 가치가 최대인 보석"만 고르면 되는거같은데
        /*
        m = 11
        5 10

        m = 2
        2 99
        m = 10
        1 65
         */
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            mv.offer(new int[] {a, b});
        }
        for(int i = 0 ; i < k ; i++) {
            m.offer(Integer.parseInt(br.readLine()));
        }

        long sum = 0;
//        if(n <= k) {
//            while(!mv.isEmpty()) {
//                sum += mv.poll()[1];
//            }
//            System.out.println(sum);
//            return;
//        }

        while(!m.isEmpty()) {
            int weight = m.poll();
            while(!mv.isEmpty() && mv.peek()[0] <= weight) {
                v.offer(mv.poll()[1]);
            }

            if(v.isEmpty()) continue;
            sum += v.poll();
        }
        System.out.println(sum);
    }
}