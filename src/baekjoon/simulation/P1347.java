package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 미로 만들기 - 예제는 모두 통과하나 제출 통과X
public class P1347 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        char[][] map = new char[101][101];

        int direction = 2; // 초기에 남쪽을 바라보고 있다. 동서남북:0123
        int x = 50;
        int y = 50;
        int[] max = {50,50}; // x,y 최솟값
        int[] min = {50,50}; // x,y 최댓값

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                map[i][j] = '#';
            }
        }
        map[x][y] = '.';
        String move = br.readLine();
        for (int i = 0; i < move.length(); i++) {
            switch (move.charAt(i)) {
                case 'R':
                    direction+=1;
                    break;
                case 'L':
                    direction-=1;
                    break;
                case 'F':
                    direction%=4;
                    switch (direction) {
                        case 0: y+=1;
                            break;
                        case 1: x+=1;
                            break;
                        case 2: y-=1;
                            break;
                        case 3: x-=1;
                            break;
                    }
                    map[x][y]='.';

                    // x,y 값 검사
                    max = checkMax(x,y,max);
                    min = checkMin(x,y,min);
                    break;
            }
        }
        for (int i = max[1]; i >= min[1]; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = min[0]; j <= max[0]; j++) {
                sb.append(map[j][i]);
            }
            if(i==min[1])
                System.out.print(sb);
            else
                System.out.println(sb);
        }
    }
    public static int[] checkMax(int x,int y,int[] max) {
        if(x>max[0])
            max[0] = x;
        if(y>max[1])
            max[1] = y;
        return max;
    }
    public static int[] checkMin(int x,int y,int[] min) {
        if(x<min[0])
            min[0] = x;
        if(y<min[1])
            min[1] = y;
        return min;
    }
}
