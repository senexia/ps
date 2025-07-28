import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sc = Integer.parseInt(br.readLine());

        if(sc >= 90) bw.write("A");
        else if(sc >= 80) bw.write("B");
        else if(sc >= 70) bw.write("C");
        else if(sc >= 60) bw.write("D");
        else bw.write("F");

        bw.flush();
        bw.close();
    }
}