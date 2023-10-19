package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 트리의 부모 찾기
public class P11725 {
    static int N;
    static int[] parent; // 부모노드 저장
    static boolean[] isVisit; // 방문여부 확인
    static ArrayList<Integer> list[]; // 노트 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        isVisit = new boolean[N + 1];
        list = new ArrayList[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
        dfs(1);

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int index) {
        isVisit[index] = true;
        for (Integer i : list[index]) { // 연결된 모든 노드들 탐색
            if (!isVisit[i]) { // isVisited가 true:부모, false:자식
                parent[i] = index; // parent list에 각 노드들의 부모 값을 저장해준다
                dfs(i);
            }
        }
    }

    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
