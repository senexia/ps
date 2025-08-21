import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, TreeSet<String>> KgroupVmember = new HashMap<>();
        HashMap<String, String> KmemberVgroup = new HashMap<>();

        for(int i = 0 ; i < n ; i++) {
            String group = br.readLine();
            KgroupVmember.putIfAbsent(group, new TreeSet<>());
            int cnt = Integer.parseInt(br.readLine());

            for(int j = 0 ; j < cnt ; j++) {
                String member = br.readLine();
                KmemberVgroup.put(member, group);
                KgroupVmember.get(group).add(member);
            }
        }

        for(int i = 0 ; i < m ; i++) {
            String s = br.readLine();
            int type = Integer.parseInt(br.readLine());
            //0이면 s가 그룹명이므로 멤버 전부 출력
            //1이면 s가 이름이므로 그룹명 출력

            if(type == 0) {
                TreeSet<String> ts = KgroupVmember.get(s);
                while(!ts.isEmpty()) {
                    String f = ts.first();
                    sb.append(f).append("\n");
                    ts.remove(f);
                }
            } else {
                sb.append(KmemberVgroup.get(s)).append("\n");
            }

        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}