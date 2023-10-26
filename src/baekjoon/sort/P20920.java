package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 영단어 암기는 괴로워
public class P20920 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        int index=0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.length() >= M) { // 길이가 M 이상의 단어만 저장
                int val = map.getOrDefault(str,0)+1;
                map.put(str,val);
            }
        }
        List<String> words = new ArrayList<>(map.keySet());

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) != map.get(o2)){
                    return map.get(o2) - map.get(o1);
                } else if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        for (String word : words) {
            System.out.println(word);
        }
}
    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
