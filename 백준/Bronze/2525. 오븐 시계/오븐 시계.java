import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt = br.readLine().split(" ");
        int ih = Integer.parseInt(ipt[0]);
        int im = Integer.parseInt(ipt[1]);

        int duration = Integer.parseInt(br.readLine());

        int timetomin = ih*60 + im;
        if(timetomin + duration >= 60*24) {
            timetomin = timetomin + duration - 60*24;
        } else {
            timetomin += duration;
        }

        int oh = timetomin / 60;
        int om = (timetomin - oh*60) % 60;

        String output = oh + " " + om;
        bw.write(output);


        bw.flush();
        bw.close();
    }
}