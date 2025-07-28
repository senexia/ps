import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        
        String[] tks = br.readLine().split(" ");
        
        int target = Integer.parseInt(br.readLine());
        int samecnt = 0;
        for(String s : tks) {
            if(Integer.parseInt(s) == target) {
                samecnt += 1;
            }
        }
        bw.write(Integer.toString(samecnt));
        
        
        bw.flush();
        bw.close();
    }
}