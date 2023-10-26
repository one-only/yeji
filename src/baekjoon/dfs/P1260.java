package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


//DFS와 BFS https://www.acmicpc.net/problem/1260
public class P1260 {
    static int N,M,V; // 정점 개수, 간선의 개수, 시작 정점 번호
    static List<Integer>[] arr;
    static boolean[] isVisit;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        V = stoi(st.nextToken());

        arr = new ArrayList[N + 1];
        isVisit = new boolean[N + 1];
        sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }
        for (int i = 0; i < arr.length; i++) {
            Collections.sort(arr[i]); // 리스트의 각 행을 오름차순 정렬
        }
        dfs(V);
        isVisit = new boolean[N + 1]; // 방문여부 초기화
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }

    static void dfs(int index) {
        isVisit[index] = true;
        sb.append(index+" "); //현재 방문한 값 저장
        for (int i : arr[index]) {
            if(!isVisit[i]) //방문하지 않았다면
                dfs(i); // 방문
        }
    }

    static void bfs(int index) {
        isVisit[index] = true;
        // 시작점도 Queue에 넣어줘야 한다.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);

        while (!queue.isEmpty()) {// Queue가 empty될 때까지 반복하고
            int a = queue.poll(); // 방문 정점을  확인, 출력 후
            sb.append(a + " ");
            for (int i : arr[a]) { // Queue에 넣어 순서대로 확인해준다.
                if (!isVisit[i]) {
                    queue.add(i);
                    isVisit[i] = true;
                }
            }
        }
    }

    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
