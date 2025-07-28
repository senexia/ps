import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            boolean b = true;
            String ipt = br.readLine();
            if(ipt.equals("0")) break;
            for(int i = 0 ; i <= ipt.length()/2 ; i++) {
                if(!(ipt.charAt(i) == ipt.charAt(ipt.length()-1-i))) {
                    b = false;
                    break;
                }
            }
            if(b) bw.write("yes\n");
            else bw.write("no\n");
        }
        bw.flush();
        bw.close();
    }
}
