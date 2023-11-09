package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 아기상어2
public class P17086 {
    static int N,M,sea[][],answer;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};//좌우하상 좌하,좌상,우하,우상
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        sea = new int[N][M];

        for (int i = 0; i < N; i++) { //공간상태 입력받기
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                sea[i][j] = stoi(st.nextToken());
            }
        }
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(sea[i][j] == 1)
                    continue;//아기상어가 있는 곳은 검사하지않음
                tmp = bfs(i,j);
                answer = tmp > answer ? tmp : answer; //안전거리가 더 큰 값을 저장
            }
        }
        System.out.println(answer);
    }

    static int bfs(int x, int y) { //가장 가까운 상어가 있는 공간까지의 거리를 반환
        boolean isVisit[][] = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<int[]>();

        queue.add(new int[]{x, y, 0});
        isVisit[x][y] = true;

        while (!queue.isEmpty()) {
            int now[] = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int val = now[2];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(isVisit[nx][ny] == true) continue;
                if(sea[nx][ny] == 1) return val+1;
                isVisit[nx][ny] = true;
                queue.add(new int[]{nx, ny, val + 1});
            }
        }
        return 0;
    }

    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
