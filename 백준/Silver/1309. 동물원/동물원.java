import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        일단 2 * n크기의 동물원에는 최대 n마리의 사자를 배치시킬 수 있다.

        처음 시도는 1마리배치, ..., n-1마리 배치를 각각 이전단계를 활용해서 계산하려했는데 잘안됨
        (0마리 배치 -> 1개 는 이전이랑 독립적인 케이스라고 생각하고 나중에 1더해주는식으로)
        이렇게하면 약간 N^2되는 느낌도 있어서 시간초과 될거같기도 하고

n=1 (1 + 2 = 3개)
XX

XO	OX

n=2 (1 + 4 + 2 = 7개)
XX
XX

XO	OX	XX	XX
XX	XX	OX	XO

OX	XO
XO	OX

n=3 (1 + 6 + 8 + 2 = 17개)
XX
XX
XX

OX	XO	XX	XX	XX	XX
XX	XX	OX	XO	XX	XX
XX	XX	XX	XX	OX	XO

XO	XO	XO	OX	OX	OX	XX	XX
XX	XX	OX	XX	XX	XO	OX	XO
OX	XO	XX	OX	XO	XX	XO	OX

OX	XO
XO	OX
OX	XO

n=4 (41개) = 1 + x + y + z + 2

선형점화식 가정 (항 2개부터)
41 = 17a + 7b
17 = 7a + 3b
풀면 a = 2, b=1인데?

a_n = 2a_(n-1) + a_(n-2)?

         */
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[100001];
        arr[1] = 3;
        arr[2] = 7;
        arr[3] = 17;
        arr[4] = 41;
        for(int i = 5 ; i <= n ; i++) {
            arr[i] = (2 * arr[i - 1] + arr[i - 2]) % 9901;
        }
        System.out.println(arr[n]);
    }

}