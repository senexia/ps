import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<Integer, ArrayList<Integer>> schedule = new HashMap<>();
        //n일에 점수가 m인 과제가 여러개 있으므로 해시셋 대신 리스트
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        TreeSet<Integer> ts = new TreeSet<>();    //순서대로 들어온다는 보장이 없음

        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            schedule.putIfAbsent(a, new ArrayList<>());
            schedule.get(a).add(b);
            ts.add(a);
        }

        int idx = ts.last();

        while(!(idx == 0)) {
            if(schedule.containsKey(idx)) {
                for(int i : schedule.get(idx)) {
                    pq.offer(i);
                }
            }
            if(!pq.isEmpty()) {
                sum += pq.poll();
            }
            idx--;
        }
        System.out.println(sum);

        /*
        1 2 3 4 5 6
        7 6 5 4 1 1

        뒤에서부터 거꾸로 채우기? (채울때는 그리디하게)
        6일일 때 6 5 하나밖에 없음

        4일일 때 4 60 / 4 40 / 4 10  ->  4 60 선택

        3일일 때 4 40 / 4 10 / 3 30  ->  4 40 선택

        2일일 때 4 10 / 3 30 / 2 50  ->  2 50 선택

        1일일 때 4 10 / 3 30 / 1 20  ->  3 30 선택

        5 + 60 + 40 + 50 + 30 = 185
        굿
        */
    }
}