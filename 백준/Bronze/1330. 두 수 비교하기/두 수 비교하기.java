import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] bounds = br.readLine().split(" ");

        int n1 = Integer.parseInt(bounds[0]);
        int n2 = Integer.parseInt(bounds[1]);

        if(n1>n2) bw.write(">");
        if(n1<n2) bw.write("<");
        if(n1==n2) bw.write("==");

        bw.flush();
        bw.close();
    }
}