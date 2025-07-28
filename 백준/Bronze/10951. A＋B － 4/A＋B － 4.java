import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            String s = br.readLine();
            if(s == null) break;
            String[] nums = s.split(" ");
            bw.write(Integer.toString(Integer.parseInt(nums[0]) + Integer.parseInt(nums[1])) + "\n");
        }

        bw.flush();
        bw.close();
    }
}