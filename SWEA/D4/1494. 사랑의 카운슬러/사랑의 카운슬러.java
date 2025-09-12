import java.io.*;
import java.util.*;

public class Solution {
    static long sumX;
    static long sumY;
    static int n;

    static int[] x;
    static int[] y;

    static long ans;
    static void comb(int cnt, int start, long sx, long sy) {
        if(cnt == n / 2) {
            long temp = (sumX - 2 * sx) * (sumX - 2 * sx) + (sumY - 2 * sy) * (sumY - 2 * sy);
            if(ans > temp) ans = temp;
            return;
            //음아정 끼리 더하는데 도대체 어케 음수가 나오지
            //캐스팅이 안돼서 오버플로우 나는건가
        }
        for(int i = start ; i < n ; i++) {
            comb(cnt + 1, i + 1, sx + x[i], sy + y[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        //선택하는애 A1(a1, b1), A2(a2, b2)
        //받는애    B1(c1, d1), B2(c2, d2)
        //순서대로 선택했을 때 두 벡터는
        //   (c1-a1, d1-b1), (c2-a2, d2-b2)
        //합벡터 : (c1+c2-a1-a2,d1+d2-b1-b2)

        //크로스로 선택했을 때 두 벡터는
        //   (c2-a1, d2-b1), (c1-a2, d1-b2)
        //합벡터 : (c1+c2-a1-a2,d1+d2-b1-b2)

        //합벡터 결과에 An이 Bn을 고르는 순서는 영향을 주지 않으므로 조합으로 될듯
        //합벡터 x : (골라지는 애 x 합) - (고르는 애 x 합)
        //합벡터 y : (골라지는 애 y 합) - (고르는 애 y 합)
        //전체 x좌표 전체 y좌표 합을 전처리해두고
        //조합으로 뽑으면서 고른애들 x합 y합 누적으로
        // n/2개 뽑았을 때 누적한 합이 골라지는 애들 x합, y합이라고 해보면
        // (전체합) = (골라지는애) + (고르는애) -> (합벡터 성분) = (전체합 성분) - 2 * (고르는 애)
        // 굿

        int tc = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= tc ; t++) {
            sb.append("#").append(t).append(" ");
            n = Integer.parseInt(br.readLine());
            x = new int[n];
            y = new int[n];
            sumX = 0;
            sumY = 0;
            ans = Long.MAX_VALUE;
            for(int i = 0 ; i < n ; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                x[i] = a;
                y[i] = b;
                sumX += a;
                sumY += b;
            }
            comb(0, 0, 0, 0);

            sb.append(ans).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}