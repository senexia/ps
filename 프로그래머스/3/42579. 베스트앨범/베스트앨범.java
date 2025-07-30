import java.util.*;
import java.io.*;

public class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        TreeMap<String, Integer> playByGenre = new TreeMap<>();
        HashMap<String, List<int[]>> byGenre = new HashMap<>();
        List<int[]> sl;

        //playByGenre : 장르별 누적 플레이 수
        //byGenre : 해당 장르에 속하는 노래들의 (플레이 수, 고윳값) 쌍

        for(int i = 0 ; i < genres.length ; i++) {
            playByGenre.put(genres[i],
                    plays[i] + playByGenre.getOrDefault(genres[i], 0));
            sl = byGenre.getOrDefault(genres[i], new ArrayList<>());
            sl.add(new int[] {plays[i], i});
            byGenre.put(genres[i], sl);
        }


        List<Map.Entry<String,Integer>> sorted = new ArrayList<>(playByGenre.entrySet());
        sorted.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

/*
        앞서 저장한 재생횟수와 고유번호를 정렬
*/
        for(String k : byGenre.keySet()) {
            Collections.sort(byGenre.get(k), new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] != o2[0]) {
                        return -Integer.compare(o1[0], o2[0]);
                    } else {
                        return Integer.compare(o1[1], o2[1]);
                    }
                }
            });
        }

        List<Integer> ret = new ArrayList<>();
        for(var entry : sorted) {
            List<int[]> tl = byGenre.get(entry.getKey());
            Collections.sort(tl, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] != o2[0]) {
                        return -Integer.compare(o1[0], o2[0]);
                    } else {
                        return Integer.compare(o1[1], o2[1]);
                    }
                }
            });
            for(int i = 0 ; i < Math.min(2, tl.size()) ; i++) {
                ret.add(tl.get(i)[1]);
            }
        }
        return ret.stream().mapToInt(x -> x).toArray();
    }
}