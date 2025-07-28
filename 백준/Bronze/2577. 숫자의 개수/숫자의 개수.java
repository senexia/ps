import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int prod = 1;
            prod *= Integer.parseInt(br.readLine());
            prod *= Integer.parseInt(br.readLine());
            prod *= Integer.parseInt(br.readLine());
            String s = Integer.toString(prod);

            int len = s.length();
            for(int i = 0 ; i < 10 ; i++) {
                bw.write(
                        String.valueOf(len - s.replaceAll(Integer.toString(i), "").length())
                        + "\n");
            }
            bw.flush();
            bw.close();
        }


}
