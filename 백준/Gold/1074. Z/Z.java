import java.io.*;
import java.util.*;

public class Main {
    static int sum = 0;
    static void z(int r, int c, int n) {
        if(n == 2) {
            if(r == 0 && c == 0) return;
            if(r == 0 && c == 1) {
                sum += 1;
                return;
            }
            if(r == 1 && c == 0) {
                sum += 2;
                return;
            }
            if(r == 1 && c == 1) {
                sum += 3;
                return;
            }
        }
        int ind = n / 2;
        if(r < ind && c < ind) {
            //왼쪽 위
            z(r, c, ind);
        } else if(r < ind && c >= ind) {
            sum += ind * ind * 1;
            z(r, c - ind, ind);
        } else if(r >= ind && c < ind) {
            sum += ind * ind * 2;
            z(r - ind, c, ind);
        } else {
            sum += ind * ind * 3;
            z(r - ind, c - ind, ind);
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        z(r,c, (int) Math.pow(2, n));
        System.out.println(sum);
    }
}