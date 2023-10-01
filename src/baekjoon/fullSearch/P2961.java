package baekjoon.fullSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

// 브루트포스(완전탐색) - 도영이가 만든 맛있는 음식
public class P2961 {
    static int N;
    static int[] S;
    static int[] B;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        B = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = stoi(st.nextToken());
            B[i] = stoi(st.nextToken());
        }
        // 트리 깊이, 신맛, 쓴맛, 선택한 음식 개수
        dfs(0, 1, 0, 0);
        System.out.println(answer);

    }
    // 완전탐색
    static void dfs(int level, int s, int b, int selectedCount) {
        if (level == N) { // 모든 조합 찾음
            if(selectedCount != 0 && Math.abs(s-b) < answer)// 1개 이상 선택하고 쓴맛, 신맛의 차이가 현재 최소값보다 작다면
                answer = Math.abs(s - b); // 가장 작은 값으로 변경
        }
        dfs(level+1,s*S[level],b+B[level],selectedCount+1); //선택
        dfs(level+1,s,b,selectedCount); //비선택
    }
    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
