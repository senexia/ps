import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return Integer.compare(o2[0], o1[0]);
                else return Integer.compare(o2[1], o1[1]);
            }
        });
        PriorityQueue<Integer> ramen = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pq.offer(new int[] {a, b});
        }

        int day = pq.peek()[0];

        for(int i = day ; i > 0 ; i--) {
            while(true) {
                if(!pq.isEmpty() && pq.peek()[0] == i) ramen.offer(pq.poll()[1]);
                else break;
            }
            if(!ramen.isEmpty()) {
                sum += ramen.poll();
            }
        }
        System.out.println(sum);
    }
}