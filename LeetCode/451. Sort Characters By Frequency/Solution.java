import java.io.*;
import java.util.*;

class Solution {
    public String frequencySort(String s) {
        int len = s.length();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0 ; i < len ; i++) {
            int k = s.charAt(i) - 'A';
            hm.put(k, hm.getOrDefault(k, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -Integer.compare(o1.getValue(), o2.getValue());
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < list.size() ; i++) {
            Map.Entry<Integer, Integer> e = list.get(i);
            for(int j = 0 ; j < e.getValue() ; j++) {
                sb.append((char)(e.getKey() + 'A'));
            }
        }
        return new String(sb);
    }
}