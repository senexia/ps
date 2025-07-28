import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for(int i = 0 ; i < 9 ; i++) {
            int tempread = Integer.parseInt(br.readLine());
            if(tempread > max) {
                cnt = i+1;
                max = tempread;
            }
        }
        bw.write(Integer.toString(max) + "\n");
        bw.write(Integer.toString(cnt) + "\n");
        bw.flush();
        bw.close();
    }
}