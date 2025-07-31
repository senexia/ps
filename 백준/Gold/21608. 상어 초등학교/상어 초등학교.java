import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] classRoom = new int[n][n];
        int[] student = new int[n * n + 1];
        int[] orderbynumber = new int[n * n + 1];


        List<List<Integer>> good = new ArrayList<>();
        for (int i = 0; i < n * n + 1; i++) good.add(new ArrayList<>());

        //애들 정보 입력받기
        for (int i = 1; i <= n * n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int ipt = Integer.parseInt(st.nextToken());
            student[i] = ipt;
            orderbynumber[ipt] = i;
            for (int j = 0; j < 4; j++) {
                good.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }
//        System.out.println(Arrays.toString(student));
//        for(int i = 1 ; i <= n * n ; i++) {
//            map.put(student[i], i);
//        }
//        System.out.println(good);
        classRoom[1][1] = student[1];
        for(int k = 2; k <= n * n ; k++) {
            int currStudent = student[k];
            int maxEmpty = 0;
            int maxGood = 0;
            int minX = 500;
            int minY = 500;

            //호감학생이 배치되어 있는지 먼저 확인
            List<Integer> hogam = good.get(k);
            for(int x = 0 ; x < n ; x++) {
                for(int y = 0 ; y < n ; y++) {
                    int emptyslot = 0; // 인접 빈자리
                    int goodslot = 0;  // 인접 호감친구
                    //각 자리마다 4방탐색
                    if(classRoom[x][y] == 0) {
                        for(int i = 0 ; i < 4 ; i++) {
                            int nx = x + dx[i];
                            int ny = y + dy[i];

                            if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                //범위 밖으로 나가지 않는다면,
                                //1. 빈자리거나
                                //2. 일반 사람과 인접하거나
                                //3. 호감 사람과 인접
                                if(classRoom[nx][ny] == 0) {
                                    //0이면 빈자리
                                    emptyslot++;
                                } else {
                                    //0이 아니면 사람이 있음 -> 호감 리스트에 있는지 확인
                                    if(hogam.contains(classRoom[nx][ny])) {
                                        goodslot++;
                                    }
                                }
                            }
                        }
                        //일단 인접 호감 학생이 가장 많아야 함.
                        //그 이후는 인접 빈 자리가 많아야 함
                        //그 이후는 행 적은거, 열 적은거
                        if(maxGood < goodslot) {
                            maxGood = goodslot;
                            maxEmpty = emptyslot;
                            minX = x;
                            minY = y;
                        } else if(maxGood == goodslot) {
                            if(maxEmpty < emptyslot) {
                                maxEmpty = emptyslot;
                                minX = x;
                                minY = y;
                            } else if (maxEmpty == emptyslot) {
                                if(minX > x) {
                                    minX = x;
                                    minY = y;
                                } else if(minX == x) {
                                    if(minY > y) {
                                        minY = y;
                                    }
                                }
                            }
                        }

                    }

                }
            }
            classRoom[minX][minY] = currStudent;

        }
//        for(int[] ar : classRoom) System.out.println(Arrays.toString(ar));

        int sum = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                int cnt = 0;

                int idx = orderbynumber[classRoom[i][j]];
                List<Integer> ho = good.get(idx);
                for(int k = 0 ; k < 4 ; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if(ho.contains(classRoom[nx][ny])) cnt++;
                    }
                }
                if(cnt == 1) sum += 1;
                if(cnt == 2) sum += 10;
                if(cnt == 3) sum += 100;
                if(cnt == 4) sum += 1000;

            }
        }
        System.out.println(sum);
    }
}