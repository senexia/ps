import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] fl = br.readLine().split(" ");
        int lines = Integer.parseInt(fl[0]);
        int tc = Integer.parseInt(fl[1]);
        int group = lines / 6; //6개 묶음 개수
        int price = 0;

        int[] six = new int[tc];
        int[] one = new int[tc];
        for(int i = 0 ; i < tc ; i++) {
            String[] tmp = br.readLine().split(" ");
            six[i] = Integer.parseInt(tmp[0]);
            one[i] = Integer.parseInt(tmp[1]);
        }

        int six_min = Integer.MAX_VALUE;
        int one_min = Integer.MAX_VALUE;

        for(int i = 0 ; i < tc ; i++) {
            if(six[i] < six_min) six_min = six[i];
            if(one[i] < one_min) one_min = one[i];
        }

        if(six_min < one_min * 6) {
            price += six_min * group;
            lines -= group * 6;

            if(six_min < one_min * lines) {
                price += six_min;
            } else {
                price += one_min * lines;
            }
        } else {
            price += one_min * lines;
        }
        bw.write(String.valueOf(price));


        bw.flush();
        bw.close();
    }
}