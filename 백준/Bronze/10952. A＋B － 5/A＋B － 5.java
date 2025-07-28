import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            String[] nums = br.readLine().split(" ");
            if((nums[0].equals("0")) && (nums[1].equals("0"))) break;
            bw.write(Integer.toString(Integer.parseInt(nums[0]) + Integer.parseInt(nums[1])) + "\n");
        }

        bw.flush();
        bw.close();
    }
}