import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if(n == 1) {
            bw.write("SciComLove\n");
        } else if(n == 2) {
            bw.write("SciComLove\n" + "SciComLove\n");
        } else {
            //do nothing
        }
        bw.flush();
        bw.close();
    }
}