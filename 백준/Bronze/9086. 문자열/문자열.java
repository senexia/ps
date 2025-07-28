import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < cnt ; i++) {
            String s = br.readLine();
            int len = s.length();
            if(len == 1) {
                bw.write(Character.toString(s.charAt(0)) + Character.toString(s.charAt(0)) + "\n");
            } else {
                bw.write(Character.toString(s.charAt(0)) + Character.toString(s.charAt(len - 1)) + "\n");
            }
        }


        bw.flush();
        bw.close();
    }
}