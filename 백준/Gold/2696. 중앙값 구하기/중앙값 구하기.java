import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        // 가운데를 말해요에서 좀 더 꼰 문제인듯
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= tc ; t++) {
            int n = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();
            int mid = 0;

            ArrayList<Integer> input = new ArrayList<>();  //입력을 이상하게 주니까 그냥 여기에 다넣고 시작
            ArrayList<Integer> midval = new ArrayList<>(); //여기에 다넣고 출력만 정리

            for(int i = 0 ; i < n / 10 ; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0 ; j < 10 ; j++) {
                    input.add(Integer.parseInt(st.nextToken()));
                }
            }
            if(n % 10 != 0) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int i = 0 ; i < n % 10 ; i++) {
                    input.add(Integer.parseInt(st.nextToken()));
                }
            }

            for(int i = 0 ; i < input.size() ; i++) {
                if(i == 0) {
                    mid = input.get(i);
                    midval.add(mid);
                    continue;
                }
                int next = input.get(i);
                if(mid <= next) right.offer(next);
                else left.offer(next);
                //일단 넣고, i%2 == 0번째일 때만 균형을 맞춰줌. left.size == right.size가 되게
                //그러면 가운데에 남는 하나가 mid값임

                if(i % 2 == 0) {
                    int lsize = left.size();
                    int rsize = right.size();
                    int diff = Math.abs(lsize - rsize);
                    if(lsize == rsize) {
                        //이미 균형이 맞춰짐
                        midval.add(mid);
                    } else if(lsize > rsize) {
                        //왼쪽을 오른쪽으로 이동
                        for(int j = 0 ; j < diff / 2; j++) {
                            right.offer(mid);
                            mid = left.poll();
                        }
                        midval.add(mid);
                        //균형 다 잡았으면 미드값 추가
                    } else {
                        //오른쪽을 왼쪽으로 이동
                        for(int j = 0 ; j < diff / 2; j++) {
                            left.offer(mid);
                            mid = right.poll();
                        }
                        midval.add(mid);
                    }
                }
            }

            int midsize = midval.size();
            sb.append(midsize).append("\n");
            for(int i = 0 ; i < midsize ; i++) {
                sb.append(midval.get(i)).append(" ");
                if(i > 0 && i % 9 == 0) {
                    sb.setLength(sb.length() - 1);
                    sb.append("\n");
                }
                //0부터 시작하므로 10으로 나누는게 아니라 9로 나눠줘야 1줄에 10개가 들어갔다고 볼 수 있음
            }
            if(midsize % 10 != 0) {
                sb.append("\n");
            }
            //10 20이렇게 애초에 데이터 개수가 10의 배수면 마지막에 줄넘김이 붙어있어서 상관없지만
            //그게 아니면 마지막에 줄넘김 하나 더 붙여야
            
            
            
//            int midsize = midval.size();
//            int cnt = 0;
//            for(int i = 0 ; i < midsize / 10 ; i++) {
//                for(int j = 0 ; j < 10 ; j++) {
//                    sb.append(midval.get(cnt)).append(" ");
//                    cnt++;
//                }
//                sb.setLength(sb.length() - 1);
//                sb.append("\n");
//            }
//            if(midsize % 10 != 0) {
//
//            }
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}


