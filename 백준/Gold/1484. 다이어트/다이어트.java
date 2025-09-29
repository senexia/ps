import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> pq;
    static void solve(int p, int q) {
        /*
        1. g가 제곱수인 경우 -> p = q인 쌍이 생김
           이 경우 x와 y중 하나는 0이므로 불가능
        2. x+y=p, x-y=q라는 연립방정식과 x+y=q, x-y=p라는 연립방정식의 x좌표는 불변
           따라서 x가 정수인지만 확인. p,q는 정수이므로 x도 정수이므로 y는 자동으로 정수.
        3. 둘이 더했다고 생각하면 p+q가 짝수인지를 확인하면 됨
         */
        if(p == q) return;

        if((p + q) % 2 == 0) pq.offer((p + q) / 2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        /*
        기억 몸무게 x - G, 현재 몸무게 x
        G = x^2 - (x - G)^2
           = 2Gx - G^2

        G는 0이 아니므로  G = 2x - 1,   15 = 2x - 1,   x = 8
        x = 4는 어디서 튀어나왔을까

        아 G > 0인데, x^2보다 (x-G)^2이 더 커서 음수 될 수도 있네 절댓값 필요
        근데 동시에 몸무게도 음수일순 없으니까 기억 몸무게가 |x-G|여야될듯

        G = |2Gx - G^2|이고 G > 0에서 G = |G| 이므로
        1 = |2x - G|,   1 = |2x - 15|  ->  x = 8 말안됨 근데 이거 넣어봐도 말안됨

        그냥 문제가 G = (x+y)(x-y)인 x 구하라는 의미인가
        1. G 약수를 전부 구해서 저장
        2. 어떤 p가 G의 약수라면 G/p도 약수. x+y와 x-y가 각각 p와 G/p (또는 순서반대)인 경우 가능
        3. 연립방정식을 풀어서 x값이 정수인지 확인. 정수라면 힙에 저장
           (x, y가 정수면 x+y, x-y가 정수지만 역은 성립 안 하므로 x가 정수인지 직접 확인 필)
        4. 힙에서 다 빼면서 출력 힙사이즈 0이면 -1
         */

        int g = Integer.parseInt(br.readLine());
        List<Integer> divisor = new ArrayList<>();
        pq = new PriorityQueue<>();
        for(int i = 1 ; i * i <= g ; i++) {
            //g까지 다 안 돌고 sqrt(g)까지 도는 이유는
            //어차피 p <= sqrt(g)인 약수들만 다 구하면 짝이 되는 약수는 g/p로 바로 나오니까
            if(g % i == 0) divisor.add(i);
        }
        for(int p : divisor) solve(p, g / p);
        if(pq.isEmpty()) {
            System.out.println(-1);
            return;
        }
        while(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}