package baekjoon.hash;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

// 패션왕 신해빈
// 같은 로직, 출력만 BufferedWriter -> StringBuilder 변경
// BufferedWriter:144ms / StringBuilder:152ms 케이스에 따라 sb가 더 빠를수도, bw가 더 빠를수도 있다.
// -> 문자열을 출력하는 작업을 수행할 때는 BufferedWriter를 사용하고,
// -> 문자열을 조작하거나 결합할 때는 StringBuilder를 사용하는 것이 좋다고 한다.
public class P9375_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
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
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }
}
