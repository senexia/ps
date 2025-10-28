import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine().toUpperCase();
        int[] freq = new int[26];

        int b = s.length();
        for(int i = 0 ; i < b ; i++) {
            freq[s.charAt(i) - 'A']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> o2[1] - o1[1]
        );
        for(int i = 0 ; i < 26 ; i++) {
            pq.offer(new int[] {i, freq[i]});
        }
        int[] t = pq.poll();

        int max = t[1];
        int argmax = t[0];
        if(!pq.isEmpty() && max == pq.peek()[1]) {
            System.out.println("?");
            return;
        }
        System.out.println((char)(argmax + 'A'));
    }
}