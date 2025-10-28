import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        HashSet<String> keywords = new HashSet<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++) {
            keywords.add(br.readLine());
        }

        for(int i = 0 ; i < m ; i++) {
            String[] words = br.readLine().split(",");
            for(String s : words) keywords.remove(s);

            sb.append(keywords.size()).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);

    }
}