package baekjoon.backtrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백트래킹 - N과 M(1)
public class P15649 {
    static int N,M;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1]; // 인덱스 1~N까지 활용하기 위해 N+1로 선언
        arr = new int[N + 1]; // 같은 이유로 N+1 선언
        bk(0);
        System.out.println(sb);
    }
    public static void bk(int num) {
        if (num == M) { // 인덱스가 마지막 위치에 도달하면 수열 출력
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        // 1~N개수의 수를 선택
        for (int i = 1; i <= N; i++) { // 1~3
            if(visited[i]) continue; // 방문한 적이 있는 경우 다음으로
            visited[i] = true; // 방문 표시
            arr[num] = i; // 해당위치에 i를 넣는다.
            bk(num+1); // 위치를 1 증가시키고   재귀->이곳에서는 visited[i]=true로 실행
            visited[i] = false; // 재귀함수에서 돌아와서는 다시 방문을 false로 변경(다음 경우의 수 위해)
        }
    }
}
