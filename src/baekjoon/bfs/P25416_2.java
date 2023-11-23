package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P25416_2 {
    static int[][] map = new int[5][5];
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int count = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int row = stoi(st.nextToken());
        int col = stoi(st.nextToken());
        bfs(row,col);
        System.out.println(count);

    }

    static void bfs(int row,int col) {
        Queue<int[]> queue = new LinkedList<>();
        boolean [][]isVisit = new boolean[5][5];
        queue.add(new int[]{row, col, 0});
        isVisit[row][col] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                row = temp[0] + dx[i];
                col = temp[1] + dy[i];
                if (row >= 0 && row <= 4 && col >= 0 && col <= 4
                        && !isVisit[row][col] && map[row][col] != -1) {
                    if (map[row][col] == 1) {
                        count = temp[2]+1;
                        break;
                    }
                    queue.add(new int[]{row,col,temp[2]+1});
                    isVisit[row][col] = true;
                }
            }
            if (count != -1) break;
        }
    }

    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
