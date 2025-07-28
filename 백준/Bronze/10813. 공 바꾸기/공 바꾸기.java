import java.io.*;

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
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]) - 1;
            int end = Integer.parseInt(line[1]) - 1;

            int temp;
            temp = box[end];
            box[end] = box[start];
            box[start] = temp;


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