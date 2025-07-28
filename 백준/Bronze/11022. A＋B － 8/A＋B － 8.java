import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++) {
            String[] nums = br.readLine().split(" ");
            bw.write("Case #" + i + ": " + nums[0] + " + " + nums[1] + " = " + Integer.toString(Integer.parseInt(nums[0]) + Integer.parseInt(nums[1])) + "\n");

        }

        bw.flush();
        bw.close();
    }
}