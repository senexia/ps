import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BitSet bs = new BitSet();
        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()) {
            int tok = Integer.parseInt(st.nextToken());
            if(!bs.get(tok)) {
                //BitSet에 없음 -> 저장 후 출력
                bs.set(tok);
                sb.append(tok).append(" ");
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}