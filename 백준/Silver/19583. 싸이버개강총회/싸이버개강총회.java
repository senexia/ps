import java.io.*;
import java.util.*;


public class Main {
    static int parseTime(String s) {
        String[] temp = s.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int startTime = parseTime(st.nextToken());
        int endTime = parseTime(st.nextToken());
        int offTime = parseTime(st.nextToken());

        HashSet<String> before = new HashSet<>();
        HashSet<String> after = new HashSet<>();

        while(true) {
            String s = br.readLine();
            if(s == null || s.isEmpty()) break;

            String[] t = s.split(" ");
            int time = parseTime(t[0]);
            if(time <= startTime) before.add(t[1]);
            else if(time >= endTime && time <= offTime) after.add(t[1]);
        }

        int cnt = 0;
        if(before.size() > after.size()) {
            for(String s : after) {
                if(before.contains(s)) cnt++;
            }
        } else {
            for(String s : before) {
                if(after.contains(s)) cnt++;
            }
        }
        System.out.println(cnt);

    }
}