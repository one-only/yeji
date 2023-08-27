package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//참고 https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-2578%EB%B2%88-%EB%B9%99%EA%B3%A0-%EC%9E%90%EB%B0%94Java

// 빙고 - StringTokenizer로 실패
public class P2578 {
    static int count = 0; // 빙고줄 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        // st 사용시 nosuchElement 오류난다. 한 군데서만 선언하고 두군데서 st로만 사용해도 동일한 오류.
        int[][] map = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int a = 1; a <= 25; a++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if(map[i][j]==num) map[i][j] = 0;
                }
            }
            rCheck(map);
            cCheck(map);
            leftCheck(map);
            rightCheck(map);
            if (count >= 3) {
                System.out.println(a);
                break;
            }
            count=0;
        }



    }
    // 가로줄 빙고
    public static void rCheck(int[][] arr) {
        for (int i = 0; i < 5; i++) {
            int zeroCount = 0;
            for (int j = 0; j < 5; j++) {
                if(arr[i][j]==0) zeroCount++;
            }
            if(zeroCount==5) count++;
        }
    }

    // 세로줄 빙고
    public static void cCheck(int[][] arr) {
        for (int i = 0; i < 5; i++) {
            int zeroCount = 0;
            for (int j = 0; j < 5; j++) {
                if(arr[j][i]==0) zeroCount++;
            }
            if(zeroCount==5) count++;
        }
    }
    // 왼쪽으로 내려가는 대각선
    public static void leftCheck(int[][] arr) {
        int zeroCount = 0;
        for (int i = 0; i < 5; i++) {
            if(arr[4-i][i]==0) zeroCount++;
        }
        if(zeroCount==5) count++;
    }

    // 오른쪽으로 내려가는 대각선
    public static void rightCheck(int[][] arr) {
        int zeroCount = 0;
        for (int i = 0; i < 5; i++) {
            if(arr[i][i]==0) zeroCount++;
        }
        if(zeroCount==5) count++;

    }
}
