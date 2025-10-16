import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] dirById;
    static int[] coordById;
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    static ArrayDeque<Integer> q = new ArrayDeque<>();
    static ArrayDeque<Integer>[][] arr;
    static int[][] type;

    static int hash(int x, int y) {
        return 20 * x + y;
    }
    static int getX(int h) {
        return h / 20;
    }
    static int getY(int h) {
        return h % 20;
    }
    static void move(int id) {
        int dir = dirById[id];
        int hash = coordById[id];
        int x = getX(hash);
        int y = getY(hash);

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        //여기 원래 if(size != 1)있었는데 지움 오류나면 확인
        while(arr[x][y].peek() != id) {
            stack.push(arr[x][y].pop());
        }
        stack.push(arr[x][y].pop());

        if(nx < 0 || nx >= n || ny < 0 || ny >= n || type[nx][ny] == 2) {
            //방향 바꾸고 반대로 이동 (맵밖이거나 파란색인 경우)

            int newdir = reversedDir(dir);
            dirById[id] = newdir;
            nx = x + dx[newdir];
            ny = y + dy[newdir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || type[nx][ny] == 2) {
                //바꿧는데도 문제있으면 그냥 그대로
                while(!stack.isEmpty()) arr[x][y].push(stack.pop());
//                while(!stack.isEmpty()) q.offer(stack.pop());
//                while(!q.isEmpty()) arr[x][y].push(q.poll());
            } else {
//                int tempid = -1;
//                while(!stack.isEmpty()) {
//                    tempid = stack.pop();
//                    coordById[tempid] = hash(nx, ny);
//                    arr[nx][ny].push(tempid);
//                }

                if(type[nx][ny] == 1) {
                    //빨간색인경우
                    //1. 일단 뒤집고
                    //2. 그런다음 이동
//            while(!stack.isEmpty()) {
//                q.offer(stack.pop());
//            }
//
//            int tempid = -1;
//            while(!q.isEmpty()) {
//                tempid = q.poll();
//                coordById[tempid] = hash(nx, ny);
//                arr[nx][ny].push(tempid);
//            }

                    while(!stack.isEmpty()) {
                        q.push(stack.pop());
                    }

                    int tempid = -1;
                    while(!q.isEmpty()) {
                        tempid = q.pop();
                        coordById[tempid] = hash(nx, ny);
                        arr[nx][ny].push(tempid);
                    }

                } else {
                    int tempid = -1;
                    while(!stack.isEmpty()) {
                        tempid = stack.pop();
                        coordById[tempid] = hash(nx, ny);
                        arr[nx][ny].push(tempid);
                    }
                }
            }
        } else if(type[nx][ny] == 1) {
            //빨간색인경우
            //1. 일단 뒤집고
            //2. 그런다음 이동
//            while(!stack.isEmpty()) {
//                q.offer(stack.pop());
//            }
//
//            int tempid = -1;
//            while(!q.isEmpty()) {
//                tempid = q.poll();
//                coordById[tempid] = hash(nx, ny);
//                arr[nx][ny].push(tempid);
//            }

            while(!stack.isEmpty()) {
                q.push(stack.pop());
            }

            int tempid = -1;
            while(!q.isEmpty()) {
                tempid = q.pop();
                coordById[tempid] = hash(nx, ny);
                arr[nx][ny].push(tempid);
            }

        } else {
            int tempid = -1;
            while(!stack.isEmpty()) {
                tempid = stack.pop();
                coordById[tempid] = hash(nx, ny);
                arr[nx][ny].push(tempid);
            }
        }
    }

    static int reversedDir(int dir) {
        if(dir == 0) return 1;
        else if(dir == 1) return 0;
        else if(dir == 2) return 3;
        else return 2;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dirById = new int[k];
        coordById = new int[k];
        arr = new ArrayDeque[n][n];
        type = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                type[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = new ArrayDeque<>();
            }
        }

        for(int i = 0 ; i < k ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            arr[x][y].push(i);
            dirById[i] = d;
            coordById[i] = hash(x, y);
        }
        int time = 1;
        while(time <= 1000) {
            for(int i = 0 ; i < k ; i++) {
//                int currx = getX(coordById[i]);
//                int curry = getY(coordById[i]);
//                if(arr[currx][curry].size() >= 4) {
//                    System.out.println(time);
//                    return;
//                }
                move(i);
                int currx = getX(coordById[i]);
                int curry = getY(coordById[i]);
//                System.out.println("ID : " + i + ", coord : (" + currx + ", " + curry + ")");
                if(arr[currx][curry].size() >= 4) {
                    System.out.println(time);
                    return;
                }
            }
            time++;
        }
        System.out.println(-1);
    }
}