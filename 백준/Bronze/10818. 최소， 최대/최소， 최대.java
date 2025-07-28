import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        String[] n1 = br.readLine().split(" ");
        int[] n2 = new int[cnt];
        for(int i = 0 ; i < cnt ; i++) {
            n2[i] = Integer.parseInt(n1[i]);
        }


        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num : n2) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }


        bw.write(Integer.toString(min) + " " + Integer.toString(max));

        bw.flush();
        bw.close();
    }
}