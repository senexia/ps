import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++) {
            String[] ipt = br.readLine().split(",");
            sb.append(Integer.parseInt(ipt[0]) + Integer.parseInt(ipt[1])).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }

}