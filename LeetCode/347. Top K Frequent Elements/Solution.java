import java.io.*;
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -Integer.compare(o1.getValue(), o2.getValue());
            }
        });
        /*
        nums에 포함된 unique한 값마다 버킷을 만들어서 담았다고 생각

        list 크기 = k <= n이므로 정렬비용 klogk인데
        k <= n이므로 klogk <= nlogn  (xlogx는 증가함수)이므로 조건 만족
        */
        int[] ret = new int[k];
        for(int i = 0 ; i < k ; i++) {
            ret[i] = list.get(i).getKey();
        }
        return ret;
    }
}
