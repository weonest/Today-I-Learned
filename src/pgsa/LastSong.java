package pgsa;

import java.util.HashMap;
import java.util.Map;

class LastSong {

    static Map<String, String> map = new HashMap() {{
        put("C#", "c");
        put("D#", "d");
        put("F#", "f");
        put("G#", "g");
        put("A#", "a");
    }};

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        m = getMelody(m);
        int maxTime = 0;
        for (int i = 0; i < musicinfos.length; i++) {
            String[] tmp = musicinfos[i].split(",");
            String start = tmp[0];
            String end = tmp[1];
            int time = getTime(start, end);

            String title = tmp[2];
            String melody = getMelody(tmp[3]);
            String wholeSong = ""; // StringBuilder 로 하면 더 빠름

            for (int j = 0; j < time; j++) {
                if (j >= melody.length()) {
                    int idx = j % melody.length();
                    wholeSong += melody.charAt(idx);
                    continue;
                }
                wholeSong += melody.charAt(j);
            }

            if (wholeSong.contains(m)) {
                if (maxTime < time){
                    maxTime = time;
                    answer = title;
                }
            }
        }
        return answer;
    }

    static String getMelody(String melody) {
        for (String key : map.keySet()) {
            melody = melody.replace(key, map.get(key));
        }
        return melody;
    }

    static int getTime(String start, String end) {
        String[] startArr = start.split(":");
        String[] endArr = end.split(":");

        int h1 = Integer.parseInt(startArr[0]) * 60;
        int h2 = Integer.parseInt(endArr[0]) * 60;

        int m1 = Integer.parseInt(startArr[1]);
        int m2 = Integer.parseInt(endArr[1]);

        return (h2 + m2) - (h1 + m1);
    }
}