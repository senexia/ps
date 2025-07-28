import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int cnt0 = 0;
        int cnt1 = 0;
        char curr;
        if(input.charAt(0) == '0') cnt0++;
        else cnt1++;
        curr = input.charAt(0);

        for(int i = 0 ; i < input.length() - 1 ; i++) {
            if(curr != input.charAt(i + 1)) {
                if (input.charAt(i + 1) == '0') cnt0++;
                else cnt1++;
                curr = input.charAt(i + 1);
            }
        }
        bw.write(String.valueOf(Math.min(cnt0, cnt1)));



        bw.flush();
        bw.close();
    }
}