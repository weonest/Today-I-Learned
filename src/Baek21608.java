import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek21608 {

    public static class Student implements Comparable<Student> {

        int x;
        int y;
        int likeCnt;
        int emptyCnt;

        public Student(int x, int y, int likeCnt, int emptyCnt) {
            this.x = x;
            this.y = y;
            this.likeCnt = likeCnt;
            this.emptyCnt = emptyCnt;
        }

        @Override
        public int compareTo(Student o) {
            if (this.likeCnt == o.likeCnt) { // 좋아하는 학생 수가 같고
                if (this.emptyCnt == o.emptyCnt) { // 비어있는 자리의 수도 같으면
                    if (this.x == o.x) {  // 행의 번호를 내림차순
                        return this.y - o.y;  // 위 조건이 여러개면 열의 번호부터 내림차순
                    }
                    return this.x - o.x;
                }
                return o.emptyCnt - this.emptyCnt; // 위 조건들이 아니라면 비어있는 자리 오름차순
            }
            return o.likeCnt - this.likeCnt; // 좋아하는 학생 수 오름차순
        }
    } // 위 compareTo 메서드를 통해 첫 번째 학생은 항상 [1, 1] 자리에 앉게 된다.
    // 따라서 뒤에서 좌표의 시작을 0, 0이 아닌 학생이 있는 1, 1 부터 시작하자


    static int N;

    static int[][] chairs;
    static int[] order; // 학생을 앉히는 순서

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static List<Integer>[] list; // 좋아하는 학생을 담는 컬렉션
    static PriorityQueue<Student> que = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        chairs = new int[N + 1][N + 1];
        order = new int[N * N + 1];

        list = new ArrayList[N * N + 1];

        for (int i = 1; i <= N * N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N * N; i++) {
            String[] s = br.readLine().split(" ");
            order[i] = Integer.parseInt(s[0]);

            for (int j = 1; j < 5; j++) {
                list[Integer.parseInt(s[0])].add(Integer.parseInt(s[j]));
            }
        }

        for (int i = 1; i <= N * N; i++) {
            solve(order[i]);
            que.clear();
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result += getPrice(i, j);
            }
        }
        System.out.println(result);

    }

    private static int getPrice(int a, int b) {
        int num = chairs[a][b];

        int newX, newY, likeCnt = 0;

        for (Integer now : list[num]) {
            for (int i = 0; i < 4; i++) {
                newX = a + dx[i];
                newY = b + dy[i];

                if (newY >= 1 && newY <= N && newX >= 1 && newX <= N) {
                    if (chairs[newY][newX] == now) {
                        likeCnt++;
                    }
                }
            }
        }
        if(likeCnt==0){
            return 0;
        }
        else if(likeCnt==1){
            return 1;
        }
        else if(likeCnt==2){
            return 10;
        }
        else if(likeCnt==3){
            return 100;
        }
        else{
            return 1000;
        }
    }

    private static void solve(int num) {
        int newX, newY;
        int emptyCnt, likeCnt;


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                emptyCnt = 0;
                likeCnt = 0;

                if (chairs[i][j] != 0) {
                    continue;
                }

                for (int k = 0; k < 4; k++) {
                    newY = i + dy[k];
                    newX = j + dx[k];

                    if (newY >= 1 && newY <= N && newX >= 1 && newX <= N) {
                        for (Integer now : list[num]) {
                            if (now == chairs[newY][newX]) {
                                likeCnt++;
                            }
                        }
                        if (chairs[newY][newX] == 0) {
                            emptyCnt++;
                        }
                    }
                }
                que.add(new Student(i, j, likeCnt, emptyCnt));
            }
        }
        Student poll = que.poll();
        chairs[poll.y][poll.x] = num;
    }
}
