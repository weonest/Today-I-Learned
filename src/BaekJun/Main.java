package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 상어초
public class Main {

    static int N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] students;
    static int[][] map;
    static int answer;
    static Map<Integer, List<Integer>> likeMap = new HashMap<>();


    static class Position implements Comparable<Position> {

        int x;
        int y;
        int likeSum;
        int emptySum;

        public Position(int x, int y, int likeSum, int emptySum) {
            this.x = x;
            this.y = y;
            this.likeSum = likeSum;
            this.emptySum = emptySum;
        }

        @Override
        public int compareTo(Position other) {
            // 인접 좋아하는 학생 수로 비교
            if (likeSum != other.likeSum)
                return -(likeSum - other.likeSum);

            // 인접 빈칸 수로 비교
            if (emptySum != other.emptySum)
                return -(emptySum - other.emptySum);

            // 행으로 비교
            if (x != other.x)
                return x - other.x;

            // 열로 비교
            return y - other.y;
        }
    }


    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        answer = 0;
        N = Integer.parseInt(br.readLine());
        students = new int[N * N];
        map = new int[N][N];

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            students[i] = student;
            likeMap.put(student, new ArrayList<>());
            for (int j = 0; j < 4; j++) {
                int like = Integer.parseInt(st.nextToken());
                likeMap.get(student).add(like);
            }
        }
    }

    static void solution() {
        for (int i = 0; i < students.length; i++) {
            Position pos = assignSeat(students[i]);
            map[pos.x][pos.y] = students[i];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 주변 학생 수에 따라 점수 합산
                int count = getPosition(i, j, map[i][j]).likeSum;
                if (count > 0) {
                    answer += (int) Math.pow(10, count - 1);
                }
            }
        }
        System.out.println(answer);
    }


    static Position assignSeat(int student) {

        PriorityQueue<Position> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[j][i] > 0) continue;
                Position pos = getPosition(j, i, student);
                pq.add(pos);
            }
        }
        return pq.poll();
    }

    static Position getPosition(int x, int y, int student) {
        int likeSum = 0;
        int emptySum = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            if (map[ny][nx] == 0) {
                emptySum++;
            }

            if (likeMap.get(student).contains(map[ny][nx])) {
                likeSum++;
            }
        }

        return new Position(x, y, likeSum, emptySum);
    }

}