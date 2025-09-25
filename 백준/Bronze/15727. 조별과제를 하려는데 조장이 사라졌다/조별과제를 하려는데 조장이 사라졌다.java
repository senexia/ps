import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long L = Long.parseLong(br.readLine().trim());
        System.out.println((L + 4) / 5);
    }
}
