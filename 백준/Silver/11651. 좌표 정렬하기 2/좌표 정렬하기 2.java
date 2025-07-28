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
                    if(a[1] != b[1]) {
                        return Integer.compare(a[1], b[1]);
                    } else {
                        return Integer.compare(a[0], b[0]);
                    }
                }
        );
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            s.add(new int[]{a, b});
        }
        for(int[] a : s) {
            int x = a[0];
            int y = a[1];
            bw.write(x + " " + y + "\n");
        }
        bw.flush();
        bw.close();
    }
}