import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        HashSet<Character> moeum = new HashSet<>();
        HashSet<Character> allowed = new HashSet<>();

        allowed.add('e');
        allowed.add('o');

        moeum.add('a');
        moeum.add('e');
        moeum.add('i');
        moeum.add('o');
        moeum.add('u');
        while(true) {
            String s = br.readLine();
            int b = s.length() - 2;
            if(s.equals("end")) break;


            boolean result = false;
            boolean contains = false;
            boolean repeatedmoja = false;
            boolean doublerepeat = false;
            if(b == -1) {
                if(moeum.contains(s.charAt(0))) result = true;
            } else if(b == 0) {
                char c1 = s.charAt(0);
                char c2 = s.charAt(1);

                if(moeum.contains(c1) || moeum.contains(c2)) contains = true;

                if(c1 == c2 && !allowed.contains(c2)) {
                    doublerepeat = true;
                }
                if(contains && !doublerepeat) result = true;

            } else {
                for(int i = 0 ; i < b ; i++) {
                    char c1 = s.charAt(i);
                    char c2 = s.charAt(i + 1);
                    char c3 = s.charAt(i + 2);

                    if(moeum.contains(c1) || moeum.contains(c2) || moeum.contains(c3)) {
                        contains = true;
                    }
                    if(moeum.contains(c1) && moeum.contains(c2) && moeum.contains(c3)) {
                        repeatedmoja = true;
                    }
                    if(!moeum.contains(c1) && !moeum.contains(c2) && !moeum.contains(c3)) {
                        repeatedmoja = true;
                    }
                    if(c2 == c3 && !allowed.contains(c2)) {
                        doublerepeat = true;
                    }
                }
                if(s.charAt(0) == s.charAt(1) && !allowed.contains(s.charAt(0))) {
                    doublerepeat = true;
                }
                if(contains && !repeatedmoja && !doublerepeat) result = true;
            }



            sb.append("<").append(s).append("> is ");
            if(!result) {
                sb.append("not ");
            }
            sb.append("acceptable.\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}