import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num != 0) {
                int norm = num > 0 ? num : -num;
                map.putIfAbsent(norm, new ArrayList<>());
                map.get(norm).add(num);
            } else {
                if(map.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    int k = map.firstKey();
                    List<Integer> ml = map.get(k);
                    Collections.sort(ml);
                    if(ml.size() == 1) {
                        sb.append(ml.get(0)).append("\n");
                        map.remove(k);
                    } else {
                        sb.append(ml.get(0)).append("\n");
                        ml.remove(0);
                    }
                }
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}