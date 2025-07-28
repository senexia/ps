import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());

        int d1 = num2 % 10;              
        int d2 = (num2 / 10) % 10;
        int d3 = num2 / 100;

        int line1 = num1 * d1;           
        int line2 = num1 * d2;           
        int line3 = num1 * d3;           
        int result = num1 * num2;        

        bw.write(line1 + "\n");
        bw.write(line2 + "\n");
        bw.write(line3 + "\n");
        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
}