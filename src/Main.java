import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {


    public static void main(String[] args) throws IOException {
        int sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] tmp = {3, 4, 5, 1, 2, 8, 3, 21};

        Stack<Integer> stack = new Stack<>();

        List<Integer> list = Arrays.stream(tmp).boxed().collect(Collectors.toList());

        list.sort(Comparator.naturalOrder());
        System.out.println("list = " + list);


        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            

            switch (command[0]) {
                case "push":
                    push(stack, Integer.parseInt(command[1]));
                    break;
                case "pop":
                    System.out.println(pop(stack));
                    break;
                case "size":
                    System.out.println(size(stack));
                    break;
                case "empty":
                    System.out.println(empty(stack));
                    break;
                case "top":
                    System.out.println(top(stack));
                    break;
            }

        }
    }

    public static void push(Stack<Integer> stack, int n) {
        stack.push(n);
    }

    public static int pop(Stack<Integer> stack) {
        int n = -1;
        if (!stack.isEmpty()) {
            n = stack.pop();
        }
        return n;
    }

    public static int size(Stack<Integer> stack) {
        int n = 0;
        if (!stack.isEmpty()) n = stack.size();
        return n;
    }

    public static int empty(Stack<Integer> stack) {
        int n = 0;
        if (stack.isEmpty()) n = 1;
        return n;
    }

    public static int top(Stack<Integer> stack) {
        int n = -1;
        if (!stack.isEmpty()) {
            n = stack.peek();
        }
        return n;
    }
}
//public class Main {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//		int n = Integer.parseInt(br.readLine());
//
//        // Stack 객체 생성.
//		Stack<Integer> stack = new Stack<>();
//
//        // 동일.
//		for(int i = 0;i<n;i++) {
//			String cons = br.readLine();
//
//			if(cons.contains("push")) { // 동일.
//				String spt[] = cons.split(" ");
//				stack.push(Integer.parseInt(spt[1]));
//			}else if(cons.contains("pop")) { // 동일.
//				if(stack.empty()) bw.write(-1+"\n"); // 별도의 empty() 체크가 필요하다.
//				else bw.write(stack.pop()+"\n");
//			}else if(cons.contains("size")) { // 동일.
//				bw.write(stack.size()+"\n");
//			}else if(cons.contains("empty")) { // 동일.
//				if(stack.empty()) bw.write(1+"\n"); // 별도의 empty() 체크가 필요하다.
//				else bw.write(0+"\n");
//			}else if(cons.contains("top")) { // 동일.
//				if(stack.empty())bw.write(-1+"\n");	// 별도의 empty() 체크가 필요하다.
//				else bw.write(stack.peek()+"\n");
//			}
//		}
//
//		bw.flush();
//		bw.close();
//		br.close();
//
//	}
//
//}
 