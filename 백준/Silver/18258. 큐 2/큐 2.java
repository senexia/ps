import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> q = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String query = st.nextToken();
            if(query.equals("push")) q.offer(Integer.parseInt(st.nextToken()));
            else if(query.equals("pop")) {
                if(q.isEmpty()) sb.append("-1\n");
                else sb.append(q.pollFirst()).append("\n");
            }
            else if(query.equals("size")) sb.append(q.size()).append("\n");
            else if(query.equals("empty")) sb.append(q.isEmpty() ? "1\n" : "0\n");
            else if(query.equals("front")) {
                if(q.isEmpty()) sb.append("-1\n");
                else sb.append(q.peekFirst()).append("\n");
            }
            else {
                if(q.isEmpty()) sb.append("-1\n");
                else sb.append(q.peekLast()).append("\n");
            }
        }
//        sb.setLength(sb.length() - 1);
        //stringindexOOB가 뜰 껀덕지가 이거밖에 없는데
        //null관련된거면 몰라도 위에선 인덱스를 건들지는 않으니까
        System.out.print(sb);
    }
}