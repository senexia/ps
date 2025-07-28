import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String isbn = br.readLine();
        int sum = 0;
        int idx = 0;
        int x = 0;
        for(int i = 0 ; i < isbn.length() ; i++) {
            if(isbn.charAt(i) != '*') {
                if(i % 2 == 0) {
                    sum += isbn.charAt(i) - '0';
                } else {
                    sum += 3 * (isbn.charAt(i) - '0');
                }
            } else {
                idx = i;
            }
        }
        for(int i = 0 ; i < 10 ; i++) {
            if(idx % 2 == 0) {
                if((sum + i) % 10 == 0) {
                    x = i;
                    break;
                }
            } else {
                if((sum + 3 * i) % 10 == 0) {
                    x = i;
                    break;
                }
            }
        }
        System.out.println(x);
    }
}