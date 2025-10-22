import java.io.*;
import java.util.*;

public class Main {

    /*
    가장 처음 모든칸 양분 5

    봄 :
        1. 각 나무가 나이만큼 양분을 먹고 나이가 1 증가.
           (나이가 어린 나무부터 먹음)
        2. 양분을 먹지 못한 나무는 즉시 죽는다.
    여름 :
        1. 죽은 나무에 대하여 (나이/2)만큼의 양분이 해당 칸에 추가
    가을 :
        1. 나이가 5의 배수인 나무가 있다면, 인접한 8방향에 나이가 1인 나무를 추가
    겨울 :
        1. 입력받은 배열만큼 각 칸에 양분을 추가한다.


    pq배열을 만든다.
    임시용 큐 배열 growQ, deadQ를 둔다.
    각 칸에 대하여
    힙에서 하나씩 빼면서 성장가능하면 나이 및 arr배열(양분) 갱신하면서 growQ에 넣고
    그게 안되면 deadQ에 넣는다.
    (봄)

    각 칸에 대하여 deadQ를 비우면서 양분 갱신
    (여름)

    각 칸에 대하여 growQ를 비우면서 pq에 넣는다.
    이과정에서 5의 배수라면 인접칸 pq배열에 넣어준다. (번식)
    (가을)

    각 칸에 대하여 양분 갱신
    (겨울)


     */

    static int n, m, k, year;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static PriorityQueue<Integer>[][] tree;
    static ArrayDeque<Integer>[][] deadQ;
    static ArrayDeque<Integer>[][] growQ;
    static int[][] arr, add;

    static void spring() {
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                while(!tree[i][j].isEmpty()) {
                    int curr = tree[i][j].poll();

                    if(arr[i][j] >= curr) {
                        growQ[i][j].offer(curr + 1);
                        arr[i][j] -= curr;
                    } else {
                        deadQ[i][j].offer(curr);
                    }
                }
            }
        }
    }

    static void summer() {
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                while(!deadQ[i][j].isEmpty()) {
                    int curr = deadQ[i][j].poll();
                    arr[i][j] += (curr / 2);
                }
            }
        }
    }

    static void autumn() {
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                while(!growQ[i][j].isEmpty()) {
                    int curr = growQ[i][j].poll();
                    if(curr % 5 == 0) {
                        for(int k = 0 ; k < 8 ; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                tree[nx][ny].offer(1);
                            }
                        }
                    }
                    tree[i][j].offer(curr);
                }
            }
        }
    }

    static void winter() {
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                arr[i][j] += add[i][j];
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        year = 0;

        arr = new int[n][n];
        add = new int[n][n];
        tree = new PriorityQueue[n][n];
        deadQ = new ArrayDeque[n][n];
        growQ = new ArrayDeque[n][n];

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                add[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = 5;
                tree[i][j] = new PriorityQueue<>();
                deadQ[i][j] = new ArrayDeque<>();
                growQ[i][j] = new ArrayDeque<>();
            }
        }

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            tree[x][y].offer(age);
        }

        while(year < k) {
            spring();
            summer();
            autumn();
            winter();
            year++;
        }

        int cnt = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                cnt += tree[i][j].size();
            }
        }
        System.out.println(cnt);

    }
}