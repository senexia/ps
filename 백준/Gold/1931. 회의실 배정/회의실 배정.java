import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
                else return Integer.compare(o1[0], o2[0]);
            }
        });

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pq.offer(new int[] {a, b});
        }

        int[] ab = pq.poll();
//        System.out.println(Arrays.toString(ab));
        int cnt = 1; //일단 하나 뽑았으니 1부터
        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            if(ab[1] <= temp[0]) {
                cnt++;
                ab[0] = temp[0];
                ab[1] = temp[1];
//                    System.out.println(Arrays.toString(temp));
            }
        }
        System.out.println(cnt);
    }
}