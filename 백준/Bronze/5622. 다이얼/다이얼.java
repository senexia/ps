import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String grandma = br.readLine();
        int len = grandma.length();
        int sum = 0;
        for(int i = 0 ; i < len ; i++) {
            int charDigit = grandma.charAt(i) - 65;
            if(charDigit < 15) {
                sum += (3 + charDigit/3);
            } else if(charDigit<19) {
                sum += 8;
            } else if(charDigit<22) {
                sum += 9;
            } else {
                sum += 10;
            }
            //System.out.println(sum);
        }

        bw.write(String.valueOf(sum));



        bw.flush();
        bw.close();
    }
}