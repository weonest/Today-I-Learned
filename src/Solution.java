import java.util.*;

class Solution {
    char[] words = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        int answer = 0;



        List<String> list = new ArrayList<>();

        for(int i = 0; i < words.length; i++){
            dfs(list, String.valueOf(words[i]));
        }

        for(String s : list) {
            if(list.contains(word)){
                answer = list.indexOf(word) + 1;
            }
        }

        return answer;
    }

    void dfs(List<String> list, String s) {
        if (s.length() == words.length + 1) return;

        if (!list.contains(s)) list.add(s);

        for(int i = 0; i < words.length; i++){
            dfs(list, s + String.valueOf(words[i]));
        }
    }
}