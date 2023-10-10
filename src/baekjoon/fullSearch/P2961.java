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
    // 완전탐색-모든 음식 조합을 탐색한다.
    // level: 현재 음식을 선택하거나 선택하지 않으르 때의 레벨(깊이)를 나타낸다.
    // s: 현재까지 선택한 음식들의 신맛의 곱
    // b: 현재까지 선택한 음식들의 쓴맛의 합
    // selectCount: 현재까지 선택한 음식의 개수
    static void dfs(int level, int s, int b, int selectedCount) {
        if (level == N) { // 모든 조합 찾음
            if(selectedCount != 0 && Math.abs(s-b) < answer)// 1개 이상 선택하고 쓴맛, 신맛의 차이가 현재 최소값보다 작다면
                answer = Math.abs(s - b); // 가장 작은 값으로 변경
        }//answer가 업데이트 되었을 수고 있고, 그렇지 않을수도 있다.
        dfs(level+1,s*S[level],b+B[level],selectedCount+1); // 해당 음식을 선택
        dfs(level+1,s,b,selectedCount); // 해당 음식을 비선택(현재 레벨의 음식을 선택하지 않는 경우)
    }
    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
