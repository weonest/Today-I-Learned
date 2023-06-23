package BaekJun.hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int S;
    static int E;
    static int Q;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = parse(st.nextToken());
        int E = parse(st.nextToken());
        int Q = parse(st.nextToken());

        Set<String> enter = new HashSet<>();
        int result = 0;
        String value;

        while ((value = br.readLine()) != null) {

            if (value.equals("")) break;

            st = new StringTokenizer(value);
            int time = parse(st.nextToken());
            String name = st.nextToken();

            if(time <= S){
                enter.add(name);
            }
            else if(E <= time && time <= Q && enter.contains(name) ){
                    enter.remove(name);
                    result++;
            }
        }

        System.out.println(result);
    }

    public static int parse(String time){
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
    }
}