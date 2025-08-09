import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Character> s = new ArrayDeque<>();
        ArrayDeque<Character> temp = new ArrayDeque<>();
        String line = br.readLine();
        String bomb = br.readLine();
        int cnt = 0;

        for(int i = 0 ; i < line.length() ; i++) {
            char c = line.charAt(i);
            s.push(c); //일단 넣고

            if(c == bomb.charAt(bomb.length() - 1) && s.size() >= bomb.length()) {
                //폭탄문자열의 마지막 글자랑 일치한다면
                boolean detected = true;
                for(int j = bomb.length() - 1 ; j >= 0 ; j--) {
                    char t = s.pop();
                    temp.push(t);
                    if(t != bomb.charAt(j)) {
                        detected = false;
                        break;
                    }
                }
                if(detected) {
                    //전부 검사했고 전부 일치함
                    temp.clear(); //큐에 임시로 박아둔거 전부 정리
                    continue;
                } else {
                    //불일치 발생 -> 임시큐에 있던거 원복
                    while(!temp.isEmpty()) s.push(temp.pop());
                }
            }
        }
        if(s.size() == 0) {
            System.out.println("FRULA");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) sb.append(s.pollLast());
        System.out.println(sb);
    }
}