import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = 1;

        while(true) {

            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int y = Integer.parseInt(st.nextToken());

            if(op.equals("!=")) {
                sb.append("Case ").append(tc).append(": ");
                sb.append(x != y ? "true" : "false");
            } else if(op.equals("<")) {
                sb.append("Case ").append(tc).append(": ");
                sb.append(x < y ? "true" : "false");
            } else if(op.equals(">")) {
                sb.append("Case ").append(tc).append(": ");
                sb.append(x > y ? "true" : "false");
            } else if(op.equals("<=")) {
                sb.append("Case ").append(tc).append(": ");
                sb.append(x <= y ? "true" : "false");
            } else if(op.equals(">=")) {
                sb.append("Case ").append(tc).append(": ");
                sb.append(x >= y ? "true" : "false");
            } else if(op.equals("==")) {
                sb.append("Case ").append(tc).append(": ");
                sb.append(x == y ? "true" : "false");
            } else {
                sb.setLength(sb.length() - 1);
                System.out.print(sb);
                return;
            }
            tc++;
            sb.append("\n");
        }
    }
}