import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = 1;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            }
        });
        PriorityQueue<Integer> cls = new PriorityQueue<>();

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pq.offer(new int[] {a, b});
        }

        int[] ab = pq.poll();
        cls.offer(ab[1]);

        while(!pq.isEmpty()) {
            ab = pq.poll();

            if(cls.peek() <= ab[0]) {
                //강의실 종료시간 <= 시작시간
                cls.poll();
                cls.offer(ab[1]);
                //해당 강의실 이용
            } else {
                //강의실 종료시간 > 시작시간
                cls.offer(ab[1]);
                cnt++;
                //새 강의실 이용
            }
        }
        System.out.println(cnt);

    }
}