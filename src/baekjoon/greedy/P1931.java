package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 회의실 배정
public class P1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];


        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }
        Arrays.sort(arr, new Comparator<int[]>() { // 종료 시간을 기준으로 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) { // 종료시간이 같은 경우 시작시간이 빠른순으로 정렬
                    return o1[0] - o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        int count=0;
        int end_time=0;

        for (int i = 0; i < N; i++) {
            if (end_time <= arr[i][0]) { // 이전 종료시간보다 크거나 작은 경우 뽑힘
                end_time = arr[i][1]; // 새 회의 추가되므로 종료 시간 갱신
                count++;
            }
        }
        System.out.println(count);
    }

}
