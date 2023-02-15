import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, HashSet<String>> reporterMap = new HashMap<>();
        Map<String, Integer> reportedMap = new HashMap<>();
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));

        for (String s : reportSet) {
            String reporter = s.split(" ")[0];
            String reported = s.split(" ")[1];
            reporterMap.putIfAbsent(reporter, new HashSet<String>(){{ // 아마도 익명함수
                add(reported);
            }});
            reporterMap.get(reporter).add(reported);
            reportedMap.put(reported, reportedMap.getOrDefault(reported, 0) + 1);
        }


        for (String reported : reportedMap.keySet()) {
            int reportedCnt = reportedMap.get(reported);
            if (reportedCnt >= k) {
                for (int i = 0; i < id_list.length; i++) {
                    if (reporterMap.containsKey(id_list[i]) && reporterMap.get(id_list[i]).contains(reported)) {
                        answer[i]++;
                    }
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {

//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;
        Solution sol = new Solution();
        sol.solution(id_list, report, k);
    }
}