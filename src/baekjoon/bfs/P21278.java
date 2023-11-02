package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 호식이 두마리 치킨
public class P21278 {
    static int N, M;
    static final int INF = Integer.MAX_VALUE;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                map[i][j] = INF;
            }
        }
        for (int i = 0; i < M; i++) { //간선 정보 입력 받기
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }
        for (int k = 1; k <= N; k++)
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);

        int point1 = Integer.MAX_VALUE;
        int point2 = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                // 2개의 지점을 치킨집으로 선정
                int dis = distance(i, j);
                // 더 작은 값을 찾으면 치킨집 장소와 최솟값 갱신
                if (min > dis) {
                    point1 = i;
                    point2 = j;
                    min = dis;
                }
            }
        }
        // 왕복 거리이기 때문에 min*2 한 값을 출력
        System.out.println(point1 + " " + point2 + " " + min * 2);
    }
    static int distance(int x, int y) {
        int result = 0;
        for (int i = 1; i <= N; i++)
            result += Math.min(map[x][i], map[y][i]);

        return result;
    }
    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
