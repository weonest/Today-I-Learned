import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(N);

        while (true) {
            int num = 0;
            int tmp = list.get(list.size()-1);

            while (tmp != 0) {
                num += (int) Math.pow(tmp % 10, p);
                tmp /= 10;
            }

            if (list.contains(num)) {
                int ans = list.indexOf(num);
                bw.write(ans + "\n");
                break;
            }

            list.add(num);
        }

        bw.flush();
        bw.close();
        br.close();

    }


}

