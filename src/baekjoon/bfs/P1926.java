package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 그림
public class P1926 {
    static int n,m; //행,열 개수
    static int [][]pic; //그림 2차원 배열
    static boolean[][] isVisit; //방문여부
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 탐색을 위한 배열
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        pic = new int[n][m];
        isVisit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                pic[i][j] = stoi(st.nextToken());
            }
        }
        int picNumber = 0;
        int picMax = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pic[i][j] == 1 && !isVisit[i][j]) {
                    int area = bfs(i,j);
                    picMax = Math.max(area, picMax);
                    picNumber++; // bfs반복횟수=그림의 개수=picNumbe
                }
            }
        }
        System.out.println(picNumber);
        System.out.println(picMax);
    }

    static int bfs(int row,int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        isVisit[row][col] = true;
        int size = 1;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                row = temp[0] + dx[i];
                col = temp[1] + dy[i];

                if(row<0||row>n-1||col<0||col>m-1) continue; //범위를 벗어나는 경우
                if(isVisit[row][col]) continue; //방문이력이 있는 경우
                if (pic[row][col] == 1) {
                    size++;
                    isVisit[row][col]=true;
                    queue.add(new int[]{row, col});
                }
            }
        }
        return size;
    }

    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
