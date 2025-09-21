import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        if(n == 3) {
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
            return;
        }
        if(arr[0] >= 0) {
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
            return;
        }
        if(arr[n - 1] <= 0) {
            System.out.println(arr[n - 3] + " " + arr[n - 2] + " " + arr[n - 1]);
            return;
        }


        /*
        두용액과 다른건 포인터가 하나 더 추가됐따
        그럼 한 포인터는 시작할때 고정해두고
        나머지 두 포인터로 두용액때랑 똑같이 하면 되지 않을까
        이러면 n^2 + nlogn
        근데 느낌은 이렇게하면 될거같긴한데 왜되는지 증명을 못하겠음
         */
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        long sum = Long.MAX_VALUE;
        long temp = 0;
        for(int i = 0 ; i < n ; i++) {
            int s = 0;
            int e = n - 1;
            while(s < e) {
                if(s == i) {
                    s++;
                    continue;
                }
                if(e == i) {
                    e--;
                    continue;
                }
                temp = arr[i] + arr[s] + arr[e];
                long a = Math.abs(temp);
                if(sum > a) {
                    sum = a;
                    v1 = i;
                    v2 = s;
                    v3 = e;
                }
                if(temp > 0) e--;
                else if(temp < 0) s++;
                else {
                    pq.offer(v1);
                    pq.offer(v2);
                    pq.offer(v3);
                    long n1 = arr[pq.poll()];
                    long n2 = arr[pq.poll()];
                    long n3 = arr[pq.poll()];
                    System.out.println(n1 + " " + n2 + " " + n3);
                    System.exit(0);
                }
            }
        }
        pq.offer(v1);
        pq.offer(v2);
        pq.offer(v3);
        long n1 = arr[pq.poll()];
        long n2 = arr[pq.poll()];
        long n3 = arr[pq.poll()];
        System.out.println(n1 + " " + n2 + " " + n3);
    }
}