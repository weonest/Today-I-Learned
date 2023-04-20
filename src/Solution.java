import java.util.*;

class Solution {
    class Document {
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Document> que = new LinkedList<>();

        int idx = 0;
        for (int i : priorities) {
            que.add(new Document(idx, i));
            idx++;
        }

        while (!que.isEmpty()) {

            int cur = que.peek().priority;

            boolean flag = false;

            for (Document document : que) {
                if (document.priority > cur) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                Document doc = que.poll();
                que.add(doc);
            } else {
                answer++;
                Document doc = que.poll();
                if (doc.index == location) {
                    return answer;
                }
            }
        }

        return answer;
    }
}