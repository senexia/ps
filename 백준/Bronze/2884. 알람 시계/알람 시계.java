import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt = br.readLine().split(" ");
        int ih = Integer.parseInt(ipt[0]);
        int im = Integer.parseInt(ipt[1]);

        int timetomin = ih*60 + im;
        if(timetomin-45 >= 0) {
            timetomin = timetomin-45;
        } else {
            timetomin = timetomin + 24*60 - 45;
        }

        int oh = timetomin / 60;
        int om = (timetomin - oh*60) % 60;

        String output = oh + " " + om;
        bw.write(output);


        bw.flush();
        bw.close();
    }
}