class Solution {
    public int solution(String s) {
        // " abcabcbcbc  "
        int answer = s.length();
        int compression = 1;
        for (int i = 1; i <= s.length() / 2; i++) { // 절반으로 나누는 것이 최대이므로
            // i <= s.length 해줘야 함
            StringBuilder sb = new StringBuilder();
            String target = s.substring(0, i);

            for (int j = i; j <= s.length(); j += i) {
                int endIdx = Math.min(j + i, s.length());

                String cur = s.substring(j, endIdx); // 0, 1, 2, 3 에서 substring(1,2)면 1만 남음

                if (cur.equals(target)) {
                    compression++;
                } else {
                    if (compression >= 2) {
                        sb.append(compression);
                    }
                    sb.append(target);
                    target = cur;
                    compression = 1;
                }
            }
            sb.append(target);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}