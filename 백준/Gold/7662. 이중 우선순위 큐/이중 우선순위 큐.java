import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < tc ; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            //<값, 해당 값 개수> -> 중복 삽입 가능하게
            int op = Integer.parseInt(br.readLine());
            for(int j = 0 ; j < op ; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                String ipt = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if(ipt.equals("I")) {
                    if(map.containsKey(n)) {
                        map.put(n, map.get(n) + 1);
                    } else {
                        map.put(n, 1);
                    }
                } else {
                    if(map.isEmpty()) continue;
                    else {
                        if(n > 0) {
                            int lk = map.lastKey();
                            if(map.get(lk) > 1) {
                                map.put(lk, map.get(lk) - 1);
                            } else {
                                map.remove(lk);
                            }
                        } else {
                            int fk = map.firstKey();
                            if(map.get(fk) > 1) {
                                map.put(fk, map.get(fk) - 1);
                            } else {
                                map.remove(fk);
                            }
                        }
                    }
                }
            }
            if(map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                String s = map.lastKey() + " " + map.firstKey();
                System.out.println(s);
            }
        }
    }
}