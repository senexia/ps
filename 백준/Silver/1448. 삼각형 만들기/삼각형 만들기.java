import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i = n - 1 ; i - 2 >= 0 ; i--) {
            if(arr[i - 2] + arr[i - 1] > arr[i]) {
                System.out.println(arr[i - 2] + arr[i - 1] + arr[i]);
                return;
            }
        }
        System.out.println(-1);

        /*
        삼각형의 결정조건 :
        (나머지 두 변 길이 합) > (가장 긴 변 길이)

        그러면 정렬한 뒤에 i = n-1번째 값과, i = n-2, n-3번째 값의 합의 대소를 비교

        만약 부등식이 성립한다면 이 세 쌍이 삼각형을 이루므로, 합을 리턴
        성립 안한다면 세 쌍의 인덱스를 전부 1씩 줄여서 i = n-2, n-3, n-4에 대해서 다시 시도
        이를 반복. 가장 작은 인덱스가 음수가 된다면 -1을 return

        (k-2번째) + (k-1번째) > (k번째)
        인데, 부등식 만족을 안 하는 상황을 생각해보면 좌변을 키워야 함
        근데 좌변의 인덱스를 줄여봐야 좌변 합만 더 줄어들기 때문에
        이렇게 오른쪽의 3개만 보고 오른쪽 인덱스를 줄이는 식으로 하면 될 듯
         */
    }
}