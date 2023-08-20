package baekjoon.hash;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
// 패션왕 신해빈
public class P9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());

        // (headgear,1) 종류와 개수를 저장할 예정
        for (int i = 0; i < count; i++) {
            Map<String,Integer> map = new HashMap<>();
            int num = Integer.parseInt(br.readLine());
            for (int j = 0; j < num; j++) {
                String[] arr = br.readLine().split(" ");
                map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
            }
            int sum = 1;
            for (Integer value : map.values()) {
                sum *= (value+1); // 각 의상 종류별 선택 여부 + 그 옵셥을 선택하지 않은 경우
            }
            sum -= 1; // 모든 의상을 선택하지 않은 경우는 제외
            bw.write(sum+"\n");
        }
        bw.flush();
        bw.close();
    }
}
