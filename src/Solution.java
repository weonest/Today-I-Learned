class Solution {
    public String solution(String new_id) {
        String answer = "";

        String s = new_id.toLowerCase();
        s = s.replaceAll("[^a-z-_.0-9]", "");

        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '.') {
                cnt++;
                if (cnt > 1) {
                    continue;
                } else {
                    sb.append(cur);
                }
            } else {
                sb.append(cur);
                cnt = 0;
            }
        }


        if (sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }

        if (sb.length() > 0) {
            if (sb.charAt(sb.length() - 1) == '.') {
                sb.setLength(sb.length() - 1);
            }
        }

        if (sb.length() == 0) {
            sb.append("a");
        }

        if (sb.length() > 15) {
            sb.setLength(15);
            if (sb.charAt(sb.length() - 1) == '.') {
                sb.setLength(sb.length() - 1);
            }
        }

        if (sb.length() <= 2) {
            while (sb.length() < 3) sb.append(sb.charAt(sb.length() - 1));
        }
        return answer = sb.toString();
    }
}