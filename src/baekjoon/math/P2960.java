package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 수학 - 에라토스테네스의 체
public class P2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);

        List<Integer> list = new ArrayList<>();
        // 2부터 N까지의 정수를 저장
        for (int i = 2; i <= N; i++) {
            list.add(i);

        }
        while (!list.isEmpty()) {
            // 가장 작은 수 저장
            int target = list.get(0);
            int mul = 1;
            while (target * mul <= list.get(list.size() - 1)) {
                // 해당 항목이 이미 지워져 존재하지 않는 경우 -> 다음 항목을 지우도록
                while (!list.contains(target * mul)) {
                    // 곱이 리스트의 마지막 숫자보다 클 경우
                    if (target * mul > list.get(list.size() - 1)) {
                        target++;
                        mul=1;
                    }
                    // 리스트 안에 존재할 경우
                    else {
                        mul++;
                    }
                }
                list.remove(Integer.valueOf(target * mul));
                if (count == K) {
                    System.out.println(target*mul);
                    System.exit(0);
                }
                mul++;
                count++;
            }
        }
    }
}
