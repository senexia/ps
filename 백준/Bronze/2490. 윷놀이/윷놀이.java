import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < 3 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int z = 0;
            for(int j = 0 ; j < 4 ; j++) {
                if(Integer.parseInt(st.nextToken()) == 0) z++;
            }
            if(z == 0) System.out.println("E");
            else if(z == 1) System.out.println("A");
            else if(z == 2) System.out.println("B");
            else if(z == 3) System.out.println("C");
            else System.out.println("D");
        }
    }
}