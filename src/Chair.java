import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chair {

    static int answer = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int R;
    static int C;
    static int M;

    static Person[][] graph;
    static boolean[][] visit;

    public class Person {
        String name;
        int teamNum;

        public Person(String name, int teamNum) {
            this.name = name;
            this.teamNum = teamNum;
        }
    }

    public int solution(String[] teams, int r, int c) {
        R = r;
        C = c;
        M = r * c;
        visit = new boolean[R + 2][C + 2];
        graph = new Person[R + 2][C + 2];

        List<Person> list = memToPer(teams);


        permutation(list, new Person[M], new boolean[list.size()], 0);

        return answer;
    }

    public void permutation(List<Person> list, Person[] out, boolean[] visited, int depth) {

        if (depth == M) {
            int idx = 0;
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    graph[i][j] = out[idx];
                    visit[i][j] = true;
                    idx++;
                }
            }

            for (int x = 1; x <= C; x++) {
                for (int y = 1; y <= R; y++) {
                    if (visit[y][x]) {
                        if (!canBeFriendly(x, y)) {
                            return;
                        }
                    }
                }
            }

            answer++;
            System.out.println("answer = " + answer);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = list.get(i);
                permutation(list, out, visited, depth + 1);
                visited[i] = false;
            }
        }
    }

    public boolean canBeFriendly(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (visit[newY][newX]) {
                if (graph[y][x].teamNum == graph[newY][newX].teamNum) {
                    return false;
                }
            }
        }
        return true;
    }


    public List<Person> memToPer(String[] teams) {
        List<Person> member = new ArrayList<>();

        int teamNum = 1;

        for (String s : teams) {
            String[] arr = s.split(" ");
            if (arr.length > 1) {
                int idx = 0;

                while (idx < arr.length) {
                    member.add(new Person(arr[idx], teamNum));
                    idx++;
                }
            } else {
                member.add(new Person(arr[0], teamNum));
            }
            teamNum++;
        }

        return member;
    }


    public static void main(String[] args) {
        String[] teams = {"Willy Andy", "Green Ethan", "Nick", "Rok"};
        int r = 2;
        int c = 3;

        Chair chair = new Chair();
        chair.solution(teams, r, c);

    }
}// d d d d d d
//
//
