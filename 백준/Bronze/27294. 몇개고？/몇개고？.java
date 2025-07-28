import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] infos = br.readLine().split(" ");
        int time = Integer.parseInt(infos[0]);
        int drink = Integer.parseInt(infos[1]);
        if(time >= 12 && time <= 16 && drink == 0) {
            System.out.println("320");
        } else {
            System.out.println("280");
        }
        //bw.flush();
        //bw.close();
    }
}