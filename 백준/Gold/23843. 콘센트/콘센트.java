import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> time = new PriorityQueue<>(Collections.reverseOrder());
        //역순 정렬 -> 큰거부터 넣으면 되는거 같은데
        /*
             8  1
         4   4  1

        = 9
        굿
         */
        //그러기 위해서는 끝나는 시간이 가장 조금 남은 콘센트를 찾아야 함
        //트리셋에 pq갖다박고 정렬 -> 하면 peek로 비교할때 널문제
        //
        int[] slot = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++) {
            time.offer(Integer.parseInt(st.nextToken()));
        }

        while(!time.isEmpty()) {
            int next = time.poll();
            int min = Integer.MAX_VALUE;
            int argmin = -1;
            for(int i = 0 ; i < m ; i++) {
                if(min > slot[i]) {
                    min = slot[i];
                    argmin = i;
                }
            }
            slot[argmin] += next;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < m ; i++) {
            if(max < slot[i]) max = slot[i];
        }
        System.out.println(max);
    }
}