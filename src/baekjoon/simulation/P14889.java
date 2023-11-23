package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14889 {
    static int N;
    static int[][] map;
    static boolean[] isVisit;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisit = new boolean[N];

        //입력받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0,0);
        System.out.println(min);


    }
    //index: 인덱스, count:조합 개수(=재귀 깊이)
    static void combi(int index, int count) {
        //팀 조합이 완성될 경우
        if (count == N / 2) {
            // 방문한 팀과 방문하지 않은 팀의 각 팀의 점수를 구한 뒤 최솟값을 찾는다.
            diff();
            return;
        }
        for (int i = index; i < N; i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                combi(i + 1, count + 1);
                isVisit[i] = false; // 재귀가 끝나면 방문 취소.
            }
        }
    }
    // 두 팀의 능력치 차이를 계산하는 함수
    static void diff(){
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i+1; j < N; j++) {
                if(isVisit[i]!=isVisit[j])continue;
                if (isVisit[i] == true && isVisit[j] == true) {
                    team_start += map[i][j];
                    team_start += map[j][i];
                } else if (isVisit[i] == false && isVisit[j] == false) {
                    team_link += map[i][j];
                    team_link += map[j][i];
                }

            }
        }
        // 두 팀의 점수 차이(절댓값)
        int val = Math.abs(team_start - team_link);
        // 점수차가 0이라면 최솟값이므로 더 이상 탐색할 필요가 없으므로 종료한다.
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }
        min = Math.min(val,min);
    }

}
