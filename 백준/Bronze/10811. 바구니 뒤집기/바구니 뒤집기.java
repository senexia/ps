import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] l1 = br.readLine().split(" ");
        int boxes = Integer.parseInt(l1[0]);
        int tries = Integer.parseInt(l1[1]);
        int[] box = new int[boxes];
        for(int i = 0 ; i < boxes ; i++) {
            box[i] = i+1;
        }

        for(int i = 0 ; i < tries ; i++) {
            String[] bound = br.readLine().split(" ");
            int st = Integer.parseInt(bound[0]) - 1;
            int ed = Integer.parseInt(bound[1]) - 1;
            while (st < ed) {
                int temp = box[st];
                box[st] = box[ed];
                box[ed] = temp;
                st++;
                ed--;
            }
        }
        String res = "";
        for(int n : box) {
            res += Integer.toString(n);
            res += " ";
        }

        bw.write(res);

        bw.flush();
        bw.close();
    }
}