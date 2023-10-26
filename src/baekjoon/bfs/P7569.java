package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토 https://www.acmicpc.net/problem/7569
class Tomato3d{
    private int z;
    private int x;
    private int y;

    public int getZ() {
        return z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Tomato3d(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}
public class P7569 {

    static int N,M,H;
    static int[][][] box;
    static ArrayList<Tomato3d> list = new ArrayList<Tomato3d>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = stoi(st.nextToken()); // 세로(열)
        N = stoi(st.nextToken()); // 가로(행)
        H = stoi(st.nextToken()); // 높이

        box = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = stoi(st.nextToken());
                    if (box[i][j][k] == 1) {
                        list.add(new Tomato3d(i, j, k));
                    }
                }
            }
        }
        int result = bfs() -1;
        LOOP:
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        result = -1;
                        break LOOP;
                    }
                }
            }
        }// LOOP끝
        System.out.println(result);
    }
    static int bfs(){
        int z = 0, x = 0, y = 0;
        int[] az = {-1, 0, 0, 0, 0, 1};
        int[] ay = {0, 0, 0, -1, 1, 0};
        int[] ax = {0, -1, 1, 0, 0, 0};

        Queue<Tomato3d> queue = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            queue.offer(list.get(i));
        }
        while (!queue.isEmpty()) {
            Tomato3d tomato = queue.poll();
            z = tomato.getZ();
            x = tomato.getX();
            y = tomato.getY();

            for (int i = 0; i < 6; i++) {
                int nz = z + az[i];
                int nx = x + ax[i];
                int ny = y + az[i];

                if (nx >= N || ny >= M || nz >= H ||
                        nx < 0 || ny < 0 || nz < 0) {
                    continue;
                }
                if(box[nz][nx][ny]==0){
                    queue.offer(new Tomato3d(nz, nx, ny));
                    box[nz][ny][ny] = box[z][x][y]+1;
                }
            }
        }
        return box[z][x][y];
    }
    static int stoi(String str) {
        return Integer.parseInt(str);
    }

}
