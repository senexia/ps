import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        double h = Integer.parseInt(st.nextToken());
        double w = Integer.parseInt(st.nextToken());
        double n = Integer.parseInt(st.nextToken());
        double m = Integer.parseInt(st.nextToken());

        System.out.println((int)(Math.ceil(h / (n + 1)) * Math.ceil(w / (m + 1))));
    }
}