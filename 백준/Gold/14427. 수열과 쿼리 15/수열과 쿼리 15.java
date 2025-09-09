import java.io.*;
import java.util.*;

public class Main {
    static class Val implements Comparable<Val>{
        int v;
        int idx;
        public Val(int v, int i) {
            this.v = v;
            this.idx = i;
        }
        @Override
        public int compareTo(Val val) {
            if(this.v != val.v) return Integer.compare(this.v, val.v);
            else return Integer.compare(this.idx, val.idx);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        TreeSet<Val> ts = new TreeSet<>();
        //세그먼트 트리 문제인줄 알았는데 그냥 매번 정렬로도 될 듯?
        //정렬은 최대한 레이지하게 2번 쿼리 전에 1번 쿼리가 들어온 경우에만 하는거로
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        Val[] seq = new Val[n + 1];
        for(int i = 1 ; i <= n ; i++) {
            int x = Integer.parseInt(st.nextToken());
            seq[i] = new Val(x, i);
            ts.add(seq[i]);
        }


        int q = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < q ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            if(a == 1) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                ts.remove(seq[b]);
                seq[b].v = c;
                ts.add(seq[b]);
                //이부분 만약 treeset에서 먼저 지우지 않고 값을 바꾸고 treeset에서 remove하려 하면
                //treeset은 값이 바뀌었다는 사실을 알지 못하므로, 제대로 수정이 안 됨
                //반드시 먼저 지우고 (바뀌기 전에 지우면 treeset이 뭘 지워야 할 지 스스로 알기때문에 제대로 삭제 가능)
                //인덱스따라 관리하는 seq배열에서 바꾼 뒤 add하면 된다
            } else {
                sb.append(ts.first().idx).append("\n");
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}