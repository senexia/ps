import java.io.*;
import java.util.*;


public class Solution {
    static int hash(int x, int y) {
        return (x << 16) | y;
    }

    static int getX(int h) {
        return h >> 16;
    }
    static int getY(int h) {
        return h & 0xFFFF;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        HashSet<Integer> mine;    // 지뢰
        HashSet<Integer> mineAdj; // 지뢰 인접한 일반칸
        HashSet<Integer> free;    // 지뢰 안 인접한 일반칸
        HashSet<Integer> buffer;  // 루프 돌때 해시셋 원소 삭제가 안되므로 방문배열 대체용
        int rem = 0;

        int tc = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= tc ; t++) {
            sb.append("#").append(t).append(" ");
            mine = new HashSet<>(1200);
            mineAdj = new HashSet<>(1200);
            free = new HashSet<>(1200);
            buffer = new HashSet<>(1200);
            ArrayDeque<Integer> q = new ArrayDeque<>();

            int n = Integer.parseInt(br.readLine());
            int cnt = 0;

            for(int i = 0 ; i < n ; i++) {
                String s = br.readLine();
                for(int j = 0 ; j < n ; j++) {
                    char c = s.charAt(j);
                    if(c == '.') {
                        rem++;
                        free.add(hash(i, j));
                    }
                    else mine.add(hash(i, j));
                }
            }

            //지뢰랑 인접한거 전처리
            for(int m : mine) {
                int x = getX(m);
                int y = getY(m);

                for(int i = 0 ; i < 8 ; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    int adj = hash(nx, ny);

                    if(free.contains(adj)) {
                        free.remove(adj);
                        mineAdj.add(adj);
                    }
                }
            }

            //인접하지 않은거로 bfs
            //인접하지 않은 지뢰가 없다면 그냥 남은만큼 하는게 답임
            if(free.size() == 0) {
                sb.append(rem).append("\n");
                continue;
            }

            for(int empty : free) {
                if(buffer.contains(empty)) continue;
                cnt++;
                rem--;
                q.offer(empty);
                buffer.add(empty);

                while(!q.isEmpty()) {
                    int curr = q.poll();
                    int x = getX(curr);
                    int y = getY(curr);
                    for(int i = 0 ; i < 8 ; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        int next = hash(nx, ny);

                        if(free.contains(next) && !buffer.contains(next)) {
                            //지뢰 인접 X 인 칸의 옆칸도 지뢰 인접 X
                            //그러면 큐에 넣는다
                            rem--;
                            buffer.add(next);
                            q.offer(next);
                        } else if(mineAdj.contains(next) && !buffer.contains(next)) {
                            //지뢰 인접한 칸이므로 큐에 넣지는 않음.
                            rem--;
                            mineAdj.remove(next);
                        }
                    }
                }



            }
            sb.append(cnt + mineAdj.size()).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}