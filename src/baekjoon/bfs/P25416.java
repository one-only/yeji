package baekjoon.bfs;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 빠른 숫자 탐색
public class P25416 {
    static int[][] map = new int[5][5];
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        result = -1;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        bfs(stoi(st.nextToken()), stoi(st.nextToken()));
        System.out.println(result);
    }

    static int stoi(String str) {
        return Integer.parseInt(str);
    }

    static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisit = new boolean[5][5];
        queue.add(new int[]{row, col, 0}); // 현재위치저장{row,col,이동횟수}
        isVisit[row][col] = true; //현재 위치 방문 true

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                row = temp[0] + dx[i];
                col = temp[1] + dy[i];

                if (row < 0 || row > 4 || col < 0 || col > 4) { //범위를 벗어나는 경우
                    continue;
                } else if (map[row][col] == -1) { // -1칸은 이동할 수 없다.
                    continue;
                } else if (isVisit[row][col]) { //이미 방문한경우
                    continue;
                } else {
                    if(map[row][col] == 1){ // 1을 찾은 경우
                        result = temp[2] + 1;
                        break;
                    }
                    isVisit[row][col] = true; // 0인경우,방문체크
                    queue.add(new int[]{row,col,temp[2]+1});
                }
            }//for

            if(result != -1)
                break;
        }//while
    }
}
