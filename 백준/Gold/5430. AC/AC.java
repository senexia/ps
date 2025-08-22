import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < tc ; t++) {
            String ops = br.readLine();
            int opcnt = ops.length(); //연산 개수

            int len = Integer.parseInt(br.readLine()); //문자열 개수
            st = new StringTokenizer(br.readLine(), ",[]");

            int[] arr = new int[len];
            for(int i = 0 ; i < len ; i++) arr[i] = Integer.parseInt(st.nextToken());

            boolean error = false;
            boolean increasing = true; //기본적으로 오름차순
            boolean zeroflag = false;

            int s = 0;
            int e = len - 1;

            for(int i = 0 ; i < opcnt ; i++) {
                if(ops.charAt(i) == 'D' && len != 0) {
                    if(increasing) s++;
                    else e--;
                    len--;
                } else if(ops.charAt(i) == 'D' && len == 0) {
                    sb.append("error").append("\n");
                    error = true;
                    break;
                } else {
                    increasing = !increasing;
                }
            }
            if(error) continue;

            if(len == 0) {
                sb.append("[]").append("\n");
                continue;
            }

            sb.append("[");
            if(increasing) {
                for(int i = s ; i <= e ; i++) {
                    sb.append(arr[i]).append(",");
                }
                sb.setLength(sb.length() - 1);
                sb.append("]").append("\n");
            } else {
                for(int i = e ; i >= s ; i--) {
                    sb.append(arr[i]).append(",");
                }
                sb.setLength(sb.length() - 1);
                sb.append("]").append("\n");
            }


        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}