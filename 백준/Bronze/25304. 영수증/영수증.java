import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tot = Integer.parseInt(br.readLine());
        int cnt = Integer.parseInt(br.readLine());

        String re = "";
        for(int i = 0 ; i < cnt ; i++) {
            re += br.readLine();
            re += " ";
        }
        String[] infos = re.split(" ");
        for(int i = 0 ; i < cnt ; i++) {
            tot -= Integer.parseInt(infos[2*i]) * Integer.parseInt(infos[2*i + 1]);
        }
        if(tot == 0) bw.write("Yes");
        else bw.write("No");

        bw.flush();
        bw.close();
    }
}