package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 종이의 개수
public class P1780 {
    static int[][] board;
    static int GRAY = 0; // -1
    static int WHITE = 0; // 0
    static int BLACK = 0; // 1
    public static void main(String[] args) throws IOException {
        //9개의 정수를 입력받는다.
        //9개의 정수가 모두 같은 수라면 0,1,-1로 9개를 하나로 카운트한다.
        //9개의 정수가 모두 같지 않다면 개별적으로 0,1,-1을 카운트하도록 한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) { // NxN 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = stoi(st.nextToken());
            }
        }
        partition(0,0,N);

        System.out.println(GRAY);
        System.out.println(WHITE);
        System.out.println(BLACK);

    }

    static void partition(int row, int col, int size) {
        // 만일 같은 색상으로 이루어져있다면 해당 색상 카운트를 증가한다.
        if (colorCheck(row, col, size)) {
            if (board[row][col] == -1) {
                GRAY++;
            } else if (board[row][col] == 0) {
                WHITE++;
            } else {
                BLACK++;
            }
            return;
        }
        int newSize = size / 3;
        // 왼쪽 위, 중앙 위, 오른쪽 위
        partition(row, col, newSize);
        partition(row,col+newSize,newSize);
        partition(row,col+2*newSize,newSize);

        // 왼쪽 중간, 중앙 중간, 오른쪽 중간
        partition(row+newSize,col,newSize);
        partition(row+newSize,col+newSize,newSize);
        partition(row+newSize ,col+2*newSize,newSize);

        // 왼쪽 아래, 중앙 아래, 오른쪽 아래
        partition(row+2*newSize,col,newSize);
        partition(row+2*newSize,col+newSize,newSize);
        partition(row+2*newSize,col+2*newSize,newSize);

    }

    static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col]; // 블록의 시작점

        // 각 블럭의 시작점(row,col)부터 블럭의 끝(row + size,col + size)까지 검사
        for (int i = row; i < row+size; i++) { // row가 3이고 size3이면 345 검사
            for (int j = col; j < col+size; j++) {
                if (color != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
