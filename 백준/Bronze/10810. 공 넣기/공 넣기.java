import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] l1 = br.readLine().split(" ");
        int boxes = Integer.parseInt(l1[0]);
        int tries = Integer.parseInt(l1[1]);
        int[] box = new int[boxes];

        for(int i = 0 ; i < tries ; i++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            int ballnum = Integer.parseInt(line[2]);

            for(int j = start-1 ; j <= end-1 ; j++) {
                box[j] = ballnum;
            }
        }
        String res = "";
        for(int i : box) {
            res += Integer.toString(i);
            res += " ";
        }

        bw.write(res);

        bw.flush();
        bw.close();
    }
}