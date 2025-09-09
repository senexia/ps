import java.io.*;
import java.util.*;

public class Main {
    static class Trie {
        Trie[] node;
        public Trie() {
            this.node = new Trie[10];
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] ipt;

        int tc = Integer.parseInt(br.readLine());
        for(int t = 0 ; t < tc ; t++) {
            Trie root = new Trie();
            /*
            시작 지점이 여러곳일 수 있음
            그 시작지점을 묶어놓고 관리하는 상위노드 root를 하나 두고 루트 아래부터 탐색시작
            루트는 아무값도 아닌 단순히 타고가는 형태를 관리하기 위함
            */
            int n = Integer.parseInt(br.readLine());
            ipt = new String[n];
            for(int i = 0 ; i < n ; i++) {
                ipt[i] = br.readLine();
            }
            Arrays.sort(ipt, Collections.reverseOrder());
            boolean legit = true;
            //트라이 만들면서 종료지점일 때 이미 존재하는 노드인지 확인
            //이런 지점이 하나라도 있으면 NO, 그렇지 않으면 YES
            //역순으로 넣으면 길이가 긴거부터 넣으니까 이렇게 되지 않나? 마지막 마킹용 boolean도 필요없고
            for(int i = 0 ; i < n ; i++) {
                if(!legit) break;

                Trie trie = root;
                int len = ipt[i].length();

                for(int j = 0 ; j < len ; j++) {
                    int idx = ipt[i].charAt(j) - '0';
                    if(j == len - 1) {
                        if(trie.node[idx] != null) {
                            legit = false;
                            break;
                        }
                        trie.node[idx] = new Trie();
                        continue;
                    }
                    if(trie.node[idx] == null) {
                        trie.node[idx] = new Trie();
                    }
                    trie = trie.node[idx];
                }
            }
            sb.append(legit ? "YES\n" : "NO\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}