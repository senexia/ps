import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[2000][2000];
        /*
        넉넉하게 (x, y) -> (x + 1000, y + 1000)으로 대응시켜서 생각
        이후 모든 이동이 끝난다면 다시 (x - 1000, y - 1000)하면 됨
         */
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x + 1000][y + 1000] = true;
        }

        int x = 1000;
        int y = 1000;

        String q = br.readLine();
        for(int i = 0 ; i < m ; i++) {
            char c = q.charAt(i);
            if(c == 'L' && !arr[x - 1][y]) x--;
            else if(c == 'D' && !arr[x][y - 1]) y--;
            else if(c == 'R' && !arr[x + 1][y]) x++;
            else if(c == 'U' && !arr[x][y + 1]) y++;
        }
        x -= 1000;
        y -= 1000;
        System.out.println(x + " " + y);
    }

}