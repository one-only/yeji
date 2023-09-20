package baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 이분탐색 - 숫자카드
public class P10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int myCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < myCount; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int numCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < numCount; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(set.contains(num))
                sb.append(1+" ");
            else
                sb.append(0+" ");
        }
        System.out.println(sb.toString());

    }
}
