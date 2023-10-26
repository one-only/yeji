package baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 지름길
public class P1446 {
//    static List<int[]> list[];
//    static int N,D,res;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = stoi(st.nextToken()); // 지름길 개수
//        D = stoi(st.nextToken()); // 고속도로 길이
//        list = new ArrayList[10001];
//
//        for (int i = 0; i < list.length; i++) {
//            list[i] = new ArrayList<>();
//        }
//        res = Integer.MAX_VALUE;
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = stoi(st.nextToken());
//            int b = stoi(st.nextToken());
//            int leng = stoi(st.nextToken());
//            list[a].add(new int[]{b, leng});
//        }
//        int dp[] = new int[10001];
//        init(dp); //dp배열 초기화
//        for (int i = 0; i <= D; i++) { // 0~고속도로길이만큼 1씩 증가하며 지름길이면 다익스트라 적용
//            if (i != 0)
//                dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
//            if (list[i].size() > 0) {
//                for (int[] tmp : list[i]) {
//                    int val = tmp[1];
//                    int end = tmp[0];
//                    if (dp[end] > dp[i] + val) {
//                        dp[end] = dp[i] + val;
//                    }
//                }
//            }
//
//        }
//        System.out.println(dp[D]);
//    }
//    static void init(int arr[]) { //해당 원소의 인덱스 값으로 배열을 초기화
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i;
//        }
//    }
//
//    static int stoi(String str) {
//        return Integer.parseInt(str);
//    }
}
