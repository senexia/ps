import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(br.readLine());
        System.out.println(n % 2 != 0 ? "SK" : "CY");
        //돌게임 1에서 숫자범위만 커진듯?
    }
}