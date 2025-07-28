import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String temp = br.readLine().strip();
        if(temp.isEmpty()) bw.write("0");
        else bw.write(Integer.toString(temp.split(" ").length));


        bw.flush();
        bw.close();
    }
}