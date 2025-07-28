import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        String[] tempscore = br.readLine().split(" ");
        int[] score = new int[cnt];
        int max = -1;
        int sum = 0;
        for(int i = 0 ; i < cnt ; i++) {
            score[i] = Integer.parseInt(tempscore[i]);
        }
        for(int i = 0 ; i < cnt ; i++) {
            if(score[i] > max) {
                max = score[i];
            }
            sum += score[i];
        }

        double res = (double)sum * 100 / (max * cnt);


        bw.write(Double.toString(res));
        bw.flush();
        bw.close();
    }
}