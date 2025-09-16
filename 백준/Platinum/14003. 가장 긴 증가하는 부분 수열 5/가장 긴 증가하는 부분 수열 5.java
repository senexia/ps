import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];
        int[] prev = new int[n];
        Arrays.fill(prev, -1);

        int ptr = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < n ; i++) {
            if(i == 0 || lis[ptr - 1] < arr[i]) {
                lis[ptr] = arr[i];
                prev[i] = ptr;
                ptr++;
            } else {
                int key = Arrays.binarySearch(lis, 0, ptr, arr[i]);
                key = key < 0 ? -key - 1 : key;
                lis[key] = arr[i];
                prev[i] = key;
            }
        }
        sb.append(ptr).append("\n");
        int i = prev.length - 1;
        while(i >= 0) {
            if(prev[i] == ptr - 1) {
                stack.push(arr[i]);
                ptr--;
            }
            i--;
        }

        while(!stack.isEmpty()) sb.append(stack.pop()).append(" ");
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
//        System.out.println("len : " + ptr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(lis));
//        System.out.println(Arrays.toString(prev));
    }
}