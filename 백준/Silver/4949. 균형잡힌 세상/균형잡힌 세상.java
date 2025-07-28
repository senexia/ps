import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            boolean empty = true;
            boolean valid = true;
            boolean residue = false;
            Stack<Character> s = new Stack<>();
            String l = br.readLine();
            if(l.equals(".")) break;
            for(int i = 0 ; i < l.length() ; i++) {
                if(l.charAt(i) == '(' || l.charAt(i) == '[') {
                    empty = false;
                    s.push(l.charAt(i));
                } else if(l.charAt(i) == ')') {
                    empty = false;
                    if(s.isEmpty() || s.peek() == '[') {
                        valid = false;
                        break;
                    } else {
                        s.pop();
                    }
                } else if(l.charAt(i) == ']') {
                    empty = false;
                    if(s.isEmpty() || s.peek() == '(') {
                        valid = false;
                        break;
                    } else {
                        s.pop();
                    }
                } else {
                    //Not parenthesis
                }
            }
            if(s.isEmpty()) {
                residue = false;
            } else {
                residue = true;
            }
            if((valid || empty) && !residue) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
