import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long cnt = 0;
        //설마 인트써서 틀렸나 ㅋㅋ
        
        
        
        /*
        네개를 한번에 다 돌면 4중포문이라 무조건 터짐

        분할정복 해보자

        일단 둘을 잡아서, 두 배열 p, q의 각 원소들의 합으로 가능한 모든 값을 구해
        그러면 4000^2 = 1600만.
        이 두개를 붙여서 3200만짜리 크기 배열을 만들어
        그런다음 정렬
        투포인터로 하면 되지않을까? 만약 이게 맞다면 여기서부턴 전형적인 문젠데
         */
        int n = Integer.parseInt(br.readLine());
        //12%에서 바로틀리는데 바로틀리는거 보면 n=1인경우 빼먹은거같음
        if(n == 1) {
            st = new StringTokenizer(br.readLine(), " ");
            int sum = 0;
            while(st.hasMoreTokens()) sum += Integer.parseInt(st.nextToken());
            System.out.println(sum == 0 ? "1" : "0");
            return;
        }

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }
        int ptr1 = 0;
        int ptr2 = 0;
        int[] arr1 = new int[n * n];
        int[] arr2 = new int[n * n];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                arr1[ptr1++] = a[i] + b[j];
                arr2[ptr2++] = c[i] + d[j];
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int s = 0;
        int e = n * n - 1;
        long fcnt = 1;
        long scnt = 1;
        while(s < n * n && e >= 0) {
            fcnt = 1;
            scnt = 1;

            int temp = arr1[s] + arr2[e];
            if(temp < 0) s++;
            else if(temp > 0) e--;
            else {
//                cnt++;
//                e--;
                //이부분 약간 구린거같음
                //중복값 있으면 어떡하지?
                /*
                만약
                arr1 : -1 0 0 1
                arr2 : -1 0 0 1
                이면 가능한 순서쌍은 (-1, 1), (1, -1)에 (0, 0) 4개 나와야 함

                 */
                boolean moved = false;
                while(e - 1 >= 0 && arr2[e - 1] == arr2[e]) {
                    scnt++;
                    e--;
                    moved = true;
                }
                while(s + 1 < n * n && arr1[s] == arr1[s + 1]) {
                    fcnt++;
                    s++;
                    moved = true;
                }
                //중복값 있으면 양쪽 중복값 개수 각각 곱해서 처리
                //없으면? 기본값이 1이니까 그냥 1 증가한거랑 같음
                //양쪽 둘 다 중복값 없어서 while문 안돌아서 포이터 안 움직일 수 있으니까
                //그거 감지하는 플래그 하나 두고
                cnt += fcnt * scnt;
                if(!moved) {
                    e--;
                    continue;
                }
                s++;
                e--;
            }
        }
        System.out.println(cnt);

    }
}