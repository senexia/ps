import java.io.*;
import java.util.*;

public class Main {
    static class State {
        int num;
        String ops;

        public State(int n, String s) {
            this.num = n;
            this.ops = s;
        }
    }

    static int[] digit = new int[4];
    static void digit(int x) {
        String s = Integer.toString(x);
        StringBuilder sb = new StringBuilder();

        if(s.length() != 4) {
            int defect = 4 - s.length();
            String rpt = "0".repeat(defect);
            sb.append(rpt).append(s);
        }
        String d = (s.length() == 4 ? s : new String(sb));
        for(int i = 0 ; i < 4 ; i++) {
            digit[i] = d.charAt(i) - '0';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        ArrayDeque<State> q = new ArrayDeque<>();
        //        num, calc
        //

        int tc = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= tc ; t++) {
            BitSet bs = new BitSet();
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            q.offer(new State(start, ""));

            while(true) {
                State curr = q.poll();
                int num = curr.num;
                String ops = curr.ops;
                if(num == to) {
                    sb.append(ops).append("\n");
                    q.clear();
                    break;
                }
                bs.set(num);


                //D : ops에서 1
                int next = (2 * num) % 10000;
                if(!bs.get(next)) {
                    q.offer(new State(next, ops.concat("D")));
                    bs.set(next);
                }

                //S : 2
                next = (num == 0 ? 9999 : num - 1);
                if(!bs.get(next)) {
                    q.offer(new State(next, ops.concat("S")));
                    bs.set(next);
                }

                digit(num);
                //L : 3
                //System.out.println(Arrays.toString(digit));
                next = digit[1] * 1000 + digit[2] * 100 + digit[3] * 10 + digit[0];
                if(!bs.get(next)) {
                    q.offer(new State(next, ops.concat("L")));
                    bs.set(next);
                }

                //R : 4
                next = digit[3] * 1000 + digit[0] * 100 + digit[1] * 10 + digit[2];
                if(!bs.get(next)) {
                    q.offer(new State(next, ops.concat("R")));
                    bs.set(next);
                }

            }
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);

    }
}