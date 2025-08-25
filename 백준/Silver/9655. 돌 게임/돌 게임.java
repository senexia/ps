import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        /*
        1개면 : 상근이
        2개면 : 1개 갖고가면 창영이
        3개면 : 상근이
        4개면 : 1개 갖고가면 창영이 3개 갖고가도 창영이
        5개면 : 1개 갖고가면 창영이가 1개 갖고간 뒤 3개, 창영이가 3개 갖고가면 1개
        걍 홀수면 상근이가 이기네

         */
        System.out.println(Integer.parseInt(br.readLine()) % 2 == 0 ? "CY" : "SK");

    }
}