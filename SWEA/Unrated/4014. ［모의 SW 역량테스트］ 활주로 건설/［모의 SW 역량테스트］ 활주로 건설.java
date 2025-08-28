import java.io.*;
import java.util.*;


public class Solution {
    static int n;
    static int len;
    static int[][] arr;
    static ArrayDeque<Integer> stack = new ArrayDeque<>();

    static int checkRow(int r) {
        boolean[] v = new boolean[n];

        for(int i = 0 ; i < n - 1 ; i++) {
            //높이차 2이상 -> 설치불가
            if(arr[r][i] + 1 < arr[r][i + 1]) return 0;

            if(arr[r][i] + 1 == arr[r][i + 1]) {
                for(int j = 0 ; j < len ; j++) {
                    if(i - j < 0 || v[i - j] || arr[r][i - j] != arr[r][i]) {
                        //배열 밖으로 나가거나
                        //이미 설치된 지역이거나
                        //중간에 높이차가 또 발생해서 설치를 못하거나
                        return 0;
                    }
                }
                for(int j = 0 ; j < len ; j++) v[i - j] = true;
            }
        }
        for(int i = n - 1 ; i > 0 ; i--) {
            //높이차 2이상 -> 설치불가
            if(arr[r][i - 1] > arr[r][i] + 1) return 0;

            if(arr[r][i - 1] == arr[r][i] + 1) {
                for(int j = 0 ; j < len ; j++) {
                    if(i + j >= n || v[i + j] || arr[r][i + j] != arr[r][i]) {
                        //배열 밖으로 나가거나
                        //이미 설치된 지역이거나
                        //중간에 높이차가 또 발생해서 설치를 못하거나
                        return 0;
                    }
                }
                for(int j = 0 ; j < len ; j++) v[i + j] = true;
            }
        }
//        System.out.println("r = " + r + " : 1");
        return 1;
    }



    static int checkCol(int c) {
        boolean[] v = new boolean[n];

        for(int i = 0 ; i < n - 1 ; i++) {
            //높이차 2이상 -> 설치불가
            if(arr[i][c] + 1 < arr[i + 1][c]) return 0;

            if(arr[i][c] + 1 == arr[i + 1][c]) {
                for(int j = 0 ; j < len ; j++) {
                    if(i - j < 0 || v[i - j] || arr[i - j][c] != arr[i][c]) {
                        //배열 밖으로 나가거나
                        //이미 설치된 지역이거나
                        //중간에 높이차가 또 발생해서 설치를 못하거나
                        return 0;
                    }
                }
                for(int j = 0 ; j < len ; j++) v[i - j] = true;
            }
        }
        for(int i = n - 1 ; i > 0 ; i--) {
            //높이차 2이상 -> 설치불가
            if(arr[i - 1][c] > arr[i][c] + 1) return 0;

            if(arr[i - 1][c] == arr[i][c] + 1) {
                for(int j = 0 ; j < len ; j++) {
                    if(i + j >= n || v[i + j] || arr[i + j][c] != arr[i][c]) {
                        //배열 밖으로 나가거나
                        //이미 설치된 지역이거나
                        //중간에 높이차가 또 발생해서 설치를 못하거나
                        return 0;
                    }
                }
                for(int j = 0 ; j < len ; j++) v[i + j] = true;
            }
        }
//        System.out.println("c = " + c + " : 1");
        return 1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= tc ; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            len = Integer.parseInt(st.nextToken());
            arr = new int[n][n];

            for(int i = 0 ; i < n ; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0 ; j < n ; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for(int i = 0 ; i < n ; i++) {
                cnt += checkRow(i);
                cnt += checkCol(i);
            }
            sb.append(cnt).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}