import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr = new int[9][9];

    static boolean[][][] bucket = new boolean[3][3][10];
    //3x3 블록 내부 숫자 포함여부                블록   1~9
    static boolean[][] row = new boolean[9][10];
    //각 행 숫자 포함여부                  행   1~9
    static boolean[][] col = new boolean[9][10];
    //각 열 숫자 포함여부                  열   1~9

    static ArrayList<int[]> list = new ArrayList<>();
    //탐색 돌 좌표

    static int max;
    static boolean collapse = false;
    static void sudoku (int curr) {
        if(collapse) return;
        if(curr == max) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < 9 ; i++) {
                for(int j = 0 ; j < 9 ; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }
            sb.setLength(sb.length() - 1);
            System.out.print(sb);
            collapse = true;
            return;
        }
        int[] temp = list.get(curr);
        int x = temp[0];
        int y = temp[1];
        for(int i = 1 ; i <= 9 ; i++) {
            if(!bucket[x / 3][y / 3][i] && !row[x][i] && !col[y][i]) {
                bucket[x / 3][y / 3][i] = true;
                row[x][i] = true;
                col[y][i] = true;
                arr[x][y] = i;
                sudoku(curr + 1);
                bucket[x / 3][y / 3][i] = false;
                row[x][i] = false;
                col[y][i] = false;
                arr[x][y] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < 9 ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < 9 ; j++) {
                int curr = s.charAt(j) - '0';
                if(curr != 0) {
                    bucket[i / 3][j / 3][curr] = true;
                    row[i][curr] = true;
                    col[j][curr] = true;
                } else {
                    list.add(new int[] {i, j});
                }
                arr[i][j] = curr;
            }
        }

        max = list.size();
        sudoku(0);
    }
}