package baekjoon.Queue;

import java.io.*;
import java.util.StringTokenizer;
// 백준 - 큐
// 방식1 큐 직접 구현
public class P10845 {
    private final int[] arr = new int[10000];
    private int front = -1; // 데이터 꺼내는 위치
    private int rear = -1; // 데이터 추가하는 위치
    public void push(int x){
        //배열이 다 찼을때
//        if(rear == arr.length-1)
//            throw new RuntimeException("queue is full");
        rear++;
        arr[rear] = x;
    }
    public int pop() {
        // front == rear 일때 큐가 비어있음
        if(rear == front)
            return -1;
        front++;
        return arr[front];
    }
    public int isEmpty() {
        if (rear == front) return 1;
        else return 0;
    }
    public int size(){
        return rear - front;
    }
    // 큐의 가장 앞의 정수 출력한다.
    public int front(){
        if (rear == front) 
            return -1;
        return arr[front+1];
    }
    // 큐의 가장 뒤의 정수 출력
    public int back() {
        if(rear == front)
            return -1;
        return arr[rear];
    }
    public static void main(String[] args) throws IOException {
        // 참고해서 구현하고 보니 실제로 데이터가 빠져나가고 그 자리가 비워져서 데이터들이 앞으로
        // 당겨지는 형식이 아니고 인덱스로 접근하여 push,pop을 구현한 것 처럼 하는 방식이다.
        // 즉 pop을 하더라도 데이터가 사라지는 것이아니라 실제론 데이터가 그 자리에 그대로 있고 인덱스만 바뀐다.
        P10845 queue = new P10845();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str) {
                case "push":
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write(Integer.toString(queue.pop())+"\n");
                    break;
                case "size":
                    bw.write(Integer.toString(queue.size())+"\n");
                    break;
                case "empty":
                    bw.write(Integer.toString(queue.isEmpty())+"\n");
                    break;
                case "front":
                    bw.write(Integer.toString(queue.front())+"\n");
                    break;
                case "back":
                    bw.write(Integer.toString(queue.back())+"\n");
                    break;
            }
        }
        bw.flush();
        bw.close();

    }//main
}
