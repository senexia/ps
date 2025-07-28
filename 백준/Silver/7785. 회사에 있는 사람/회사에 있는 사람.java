import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        HashSet<String> s = new HashSet<>();
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String type = st.nextToken();
            if(type.equals("enter")) s.add(name);
            else {
                if(s.contains(name)) s.remove(name);
            }
        }
        List<String> l = new ArrayList<>(s);
        Collections.sort(l);
        for(int i = l.toArray().length - 1 ; i >= 0 ; i--) {
          bw.write(l.get(i) + "\n");
        }
        bw.flush();
        bw.close();
    }
}