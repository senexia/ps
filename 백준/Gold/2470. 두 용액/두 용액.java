import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);
//        System.out.println(list);

        int s = 0;
        int e = list.size() - 1;

        if(list.get(s) >= 0) {
            System.out.println(list.get(s) + " " + list.get(s + 1));
        } else if(list.get(e) <= 0) {
            System.out.println(list.get(e - 1) + " " + list.get(e));
        } else {
            int sum = list.get(s) + list.get(e);
            int abs = Math.abs(sum);
            int r1 = list.get(s);
            int r2 = list.get(e);
            while(s < e) {
                sum = list.get(s) + list.get(e);
                int curr = Math.abs(sum);

                if(abs > curr) {
                    abs = curr;
                    r1 = list.get(s);
                    r2 = list.get(e);
                }
                if(sum < 0) {
                    s++;
                } else if(sum > 0) {
                    e--;
                } else {
                    break;
                }
            }
            System.out.println(Math.min(r1, r2) + " " + Math.max(r1, r2));
        }


    }
}