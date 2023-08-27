package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// 빙고
// st -> sc 로 변경 (제출완료)
public class P2578_2 {
    public static int count = 0; // 빙고줄 개수
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int a = 1; a <= 25; a++) {
            int num = sc.nextInt();
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
