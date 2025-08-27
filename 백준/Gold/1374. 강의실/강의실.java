import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
                else return Integer.compare(o2[2], o1[2]);
            }
        });
        PriorityQueue<Integer> end = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new int[] {a, b, c});
        }

        while(!pq.isEmpty()) {
            int[] cls = pq.poll();
            if(end.isEmpty()) end.offer(cls[2]);
            else {
                //이용 가능한 강의실이 있음
                if(end.peek() <= cls[1]) {
                    end.poll();
                    end.offer(cls[2]);
                } else {
                    //이용 가능한 강의실이 없음 -> 강의실 추가
                    end.offer(cls[2]);
                }
            }
        }
        System.out.println(end.size());
    }
}