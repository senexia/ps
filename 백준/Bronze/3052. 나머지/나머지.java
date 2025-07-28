import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] residue = new int[10];
        int cnt = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0 ; i < 10 ; i++) {
            hs.add(Integer.parseInt(br.readLine()) % 42);
        }
        cnt = hs.size();

        bw.write(Integer.toString(cnt));

        bw.flush();
        bw.close();
    }
}