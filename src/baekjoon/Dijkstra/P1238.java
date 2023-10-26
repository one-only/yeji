package baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 파티 골드3
public class P1238 {
//    static final int INF = Integer.MAX_VALUE;
//    static List<ArrayList<Node>> list = new ArrayList<>();
//    static List<ArrayList<Node>> backlist = new ArrayList<>();
//    static int N, M, X;
//
//    static class Node implements Comparable<Node> {
//        int roadNum;
//        int time;
//
//        public Node(int roadNum, int time) {
//            this.roadNum = roadNum;
//            this.time = time;
//        }
//
//        @Override
//        public int compareTo(Node node) {
//            return time - node.time;
//        }
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = stoi(st.nextToken());
//        int M = stoi(st.nextToken());
//        int X = stoi(st.nextToken());
//
//        list = new ArrayList<>();
//        for (int i = 0; i < M; i++) {
//            // 시작점, 끝점, 소요시간
//        }
//        for (int i = 0; i <= N; i++) {
//            list.add(new ArrayList<>());
//            backlist.add(new ArrayList<>());
//        }
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//
//            int n = Integer.parseInt(st.nextToken());
//            int m = Integer.parseInt(st.nextToken());
//            int t = Integer.parseInt(st.nextToken());
//
//            list.get(n).add(new Node(m,t));
//            backlist.get(m).add(new Node(n, t));
//        }
//        int max = Integer.MIN_VALUE;
//
//        int goResult[] = dijkstra(list);
//    }
//    static int[] dijkstra(List<ArrayList<Node>>list) {
//        PriorityQueue<Node> queue = new PriorityQueue<>();
//
//        boolean visit[] = new boolean[N + 1];
//        int dist[] = new int[N + 1];
//        Arrays.fill(dist,INF); // dist배열을 INF로 초기화
//        dist[X] = 0;
//
//        queue.offer(new Node(X, 0));
//
//        while (!queue.isEmpty()) {
//            Node qNode = queue.poll();
//            int num = qNode.roadNum;
//
//            if(visit[num]) continue;
//
//            visit[num] = true;
//            for (Node node : list.get(num)) {
//                if (!visit[node.roadNum] && dist[node.roadNum] > (dist[num] + node.time)) {
//                    dist[node.roadNum] = dist[num] + node.time;
//                    queue.offer(new Node(node.roadNum, dist[node.roadNum]));
//                }
//            }
//        }
//        return dist;
//    }
//    static int stoi(String str) {
//        return Integer.parseInt(str);
//    }
}
