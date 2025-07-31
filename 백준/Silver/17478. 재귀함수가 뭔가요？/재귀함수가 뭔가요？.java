import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int depth = 0;
    static StringBuilder sb = new StringBuilder();
    static String[] recq =
            {"\"재귀함수가 뭔가요?\"",
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"",
            "라고 답변하였지."};

    static String[] reca =
            {"\"재귀함수가 뭔가요?\"",
            "\"재귀함수는 자기 자신을 호출하는 함수라네\"",
            "라고 답변하였지."};

    static void rec() {

        if(depth != n) {
            String header = "_".repeat(4 * depth);
            sb.append(header).append(recq[0]).append("\n");
            sb.append(header).append(recq[1]).append("\n");
            sb.append(header).append(recq[2]).append("\n");
            sb.append(header).append(recq[3]).append("\n");
            depth++;
            rec();
            sb.append(header).append(recq[4]).append("\n");
        } else {
            String ansheader = "_".repeat(4 * depth);
            sb.append(ansheader).append(reca[0]).append("\n");
            sb.append(ansheader).append(reca[1]).append("\n");
            sb.append(ansheader).append(reca[2]).append("\n");
            depth--;
            return;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
        rec();
        System.out.println(sb);
    }
}