import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean stop = true;
        while(stop) {
            String nl = br.readLine();
            if(nl == null) {
                stop = false;
            } else {
                bw.write(nl + "\n");
            }
        }


        bw.flush();
        bw.close();
    }
}