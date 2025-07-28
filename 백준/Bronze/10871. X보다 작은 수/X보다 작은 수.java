import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line1 = br.readLine().split(" ");
        String[] nums = br.readLine().split(" ");
        String res = "";

        int target = Integer.parseInt(line1[1]);


        for(String s : nums) {
            if(Integer.parseInt(s) < target) {
                res += s;
                res += " ";
            }
        }
        bw.write(res);

        bw.flush();
        bw.close();
    }
}