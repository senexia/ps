import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ipt = br.readLine();

        int[] idx = new int[26];
        Arrays.fill(idx, ipt.length() + 1);

        for(int j = 0 ; j < ipt.length() ; j++) {
            for(int i = 97 ; i <= 122 ; i++) {
                if(ipt.charAt(j) == i) {
                    if(idx[i-97] > j) idx[i-97] = j;
                }
            }
        }
        for(int i = 0 ; i <idx.length ; i++) {
            if(idx[i]==ipt.length()+1) idx[i]=-1;
            bw.write(Integer.toString(idx[i]) + " ");
        }
        bw.flush();
        bw.close();
    }
}