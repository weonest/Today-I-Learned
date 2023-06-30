package BaekJun.garph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.*;

public class Baek1707 {

    static int T, V, E;
    static boolean[] visited;
    static boolean answer;
    static Node[] nodes;
    static class Node {

        int idx;
        int color;

        List<Node> child = new ArrayList<>();

        public Node(int idx) {
            this.idx = idx;
        }

        public void setColor(int color) {
            this.color = color;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            V = parseInt(st.nextToken());
            E = parseInt(st.nextToken());

            nodes = new Node[V + 1];
            visited = new boolean[20001];
            answer = true;

            for (int j = 1; j <= V; j++) {
                nodes[j] = new Node(j);
            }

            for (int k = 1; k <= E; k++) {
                st = new StringTokenizer(br.readLine());
                int p1 = parseInt(st.nextToken());
                int p2 = parseInt(st.nextToken());

                nodes[p1].child.add(nodes[p2]);
                nodes[p2].child.add(nodes[p1]);
            }

            for (int l = 1; l <= V; l++) {
                if (!visited[l]) {
                    visited[l] = true;
                    nodes[l].setColor(1);
                    if (!bfs(l)) {
                        answer = false;
                        break;
                    }
                }
            }
            if (answer == true) System.out.println("YES");
            else {
                System.out.println("NO");
            }
        }
    }

    public static boolean bfs(int idx) {
        Queue<Node> que = new LinkedList<>();
        que.add(nodes[idx]);

        while (!que.isEmpty()) {
            Node node = que.poll();

            if (checkVisitedChildColor(node)) {
                return false;
            }
            checkChildAndSetColor(que, node);
        }
        return true;
    }

    public static boolean checkVisitedChildColor(Node node) {
        for (Node child : node.child) {
            if (visited[child.idx] && node.color == child.color) {
                return true;
            }
        }
        return false;
    }

    public static void checkChildAndSetColor(Queue<Node> que, Node node) {
        for (Node child : node.child) {
            if (!visited[child.idx]) {
                visited[child.idx] = true;
                child.setColor(1 - node.color);
                que.add(child);
            }
        }
    }
}
