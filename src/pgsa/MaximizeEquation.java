package pgsa;

import java.util.*;
import java.util.stream.Collectors;

public class MaximizeEquation {
    Set<List<String>> permedOperators = new HashSet<>();
    public long solution(String expression) {
        long answer = 0;

        boolean[] visit = new boolean[3];

        String[] operatorArr = {"+", "-", "*"};

        List<Long> numbers = Arrays.stream(expression.replaceAll("[-\\+\\*]", " ").split(" "))
                .map(Long::parseLong).collect(Collectors.toList());

        List<String> operators = Arrays.stream(expression.replaceAll("[0-9]", "").split(""))
                .collect(Collectors.toList());

        perm(new ArrayList<>(), operatorArr, visit);

        for (List<String> strings : permedOperators) {
            answer = Math.max(answer, solve(strings, numbers, operators));
        }

        return answer;
    }

    void perm(ArrayList<String> list, String[] operatorArr, boolean[] visit) {
        if (list.size() == 3) {
            permedOperators.add(list);
            return;
        }
        for(int i = 0; i < operatorArr.length; i++) {
            if(!visit[i]) {
                ArrayList<String> tmp = new ArrayList<>(list);
                tmp.add(operatorArr[i]);
                visit[i] = true;
                perm(tmp, operatorArr, visit);
                visit[i] = false;
            }
        }
    }

    long solve(List<String> strings, List<Long> numbers, List<String> operations) {
        // 리스트에 remove 메서드를 사용하기 위해서 복사
        List<Long> numbersClone = new ArrayList<>(numbers);
        List<String> operationsClone = new ArrayList<>(operations);

        for (int i = 0; i < strings.size(); i++) {
            String operation = strings.get(i); // 현재 순위의 연산자

            for(int j = 0; j < operationsClone.size(); j++) {
                // 현재 순위의 연산자와 같은 경우
                if(operation.equals(operationsClone.get(j))) {
                    // 연산자 앞의 수와 뒤의 수를 구한뒤 연산
                    long front = numbersClone.get(j);
                    long back = numbersClone.get(j + 1);
                    long temp = calc(front, back, operation);

                    // 연산에 사용된 두수를 제거
                    numbersClone.remove(j+1);
                    numbersClone.remove(j);

                    // 연산에 사용된 연산자 제거
                    operationsClone.remove(j);

                    // 연산된 값을 추가
                    numbersClone.add(j, temp);

                    // 연산이 진행되는 경우 2개 -> 1개 가되므로 리스트의 사이즈에 변경이 일어남
                    // 이를 맞추기 위해서 j를 --하여 다움 for문에서 범위를 벗어나지 않게 함
                    j--;
                }
            }
        }
        // 절대값으로 변환해서 리턴
        return Math.abs(numbersClone.get(0));
    }

    long calc(long one, long two, String calc) {
        switch (calc) {
            case "-" :
                return one - two;
            case "+" :
                return one + two;
            default :
                return one * two;
        }
    }
}
