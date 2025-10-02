import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>();


        int n = Integer.parseInt(br.readLine());
        int max = 0;
        for(int i = 0 ; i < n ; i++) {
            String s = br.readLine();

            map.putIfAbsent(s, 0);
            int temp = map.get(s) + 1;
            if(max < temp) max = temp;
            map.put(s, temp);
        }

        for(String s : map.keySet()) {
            if(map.get(s) == max) pq.offer(s);
        }
        System.out.println(pq.peek());
    }

}