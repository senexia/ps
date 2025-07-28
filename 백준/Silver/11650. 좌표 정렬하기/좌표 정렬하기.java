import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        TreeSet<int[]> s = new TreeSet<>(
                (a, b) -> {
                    if(a[0] != b[0]) {
                        return Integer.compare(a[0], b[0]);
                    } else {
                        return Integer.compare(a[1], b[1]);
                    }
                }
        );
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            s.add(new int[] {a, b});
        }
        int[] t = new int[2];
        while(!s.isEmpty()) {
            t = s.pollFirst();
            bw.write(t[0] + " " + t[1] + "\n");
        }

        bw.flush();
        bw.close();

    }
}