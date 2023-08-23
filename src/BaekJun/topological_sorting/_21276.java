package BaekJun.topological_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _21276 {

    static int N, M;

    static HashMap<String, Integer> map;

    static List<String> list = new ArrayList<>();

    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        indegree = new int[N];
        map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(st.nextToken());
            ans.add(new ArrayList<>());
        }
        Collections.sort(list);

        for (int i = 0; i < N; i++) {
            map.put(list.get(i), i);
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int down = map.get(st.nextToken());
            int up = map.get(st.nextToken());

            ans.get(up).add(down);
            indegree[down]++;
        }

        topologicalSort();
    }

    static void topologicalSort() {
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> root = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                root.add(i);
                q.offer(i);
            }
        }

        ArrayList<ArrayList<Integer>> children = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            children.add(new ArrayList<>());
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : ans.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    children.get(cur).add(next);
                    q.offer(next);
                }
            }
        }
        System.out.println(root.size());
        for (int idx : root) {
            System.out.println(list.get(idx) + " ");
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.print(list.get(i) + " " + children.get(i).size() + " ");
            children.get(i).sort(null); //null 로 정렬이 되는구나
            for (int idx : children.get(i)) {
                System.out.println(list.get(idx) + " ");
            }
            System.out.println();
        }
    }
}
