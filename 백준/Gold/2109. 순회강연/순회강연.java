import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pd = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]) return Integer.compare(o2[1], o1[1]);
                else return Integer.compare(o2[0], o1[0]);
            }
        });
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());

        int sum = 0;
        if(n == 0) {
            System.out.println(0);
            return;
        }

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pd.offer(new int[] {a, b});
        }
        /*
        가장 늦은거부터 거꾸로 채우기 (가치 높은순)

         */
        int top = pd.peek()[1];
        for(int i = top ; i > 0 ; i--) {
            while(!pd.isEmpty() && pd.peek()[1] >= i) {
                p.offer(pd.poll()[0]);
            }
            //i일에 수행 가능한 강연 = (마감일 >= i인 강연)
            //을 전부 뽑아서 가치 내림차순으로 정렬
            if(!p.isEmpty()) sum += p.poll();

        }
        System.out.println(sum);
    }
}


