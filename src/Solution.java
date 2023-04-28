import java.util.*;

/*
그냥 3차원 배열 선언해서 to -> from 각각 다른 방향으로 true 표시해주기 
*/

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};

        boolean [][][] visited = new boolean[11][11][4];

        int x = 5;
        int y = 5;

        for(int i = 0; i < dirs.length(); i++){
            char in = dirs.charAt(i);
            int dir = 0;

            switch(in){
                case 'L':
                    dir = 0;
                    break;
                case 'U':
                    dir = 1;
                    break;
                case 'D':
                    dir = 2;
                    break;
                case 'R':
                    dir = 3;
                    break;
                default:
                    break;
            }

            int newX = x + dx[dir];
            int newY = y + dy[dir];

            if(newX<0||newX >=11||newY<0||newY>=11)continue;

            //이 방향으로 들어온 적이 없다면 
            if (!visited[newX][newY][3-dir]&&!visited[x][y][dir]){
                answer++;
                visited[newX][newY][3-dir] = true;
                visited[x][y][dir] = true;
            }

            x = newX;
            y = newY;
        }

        return answer;
    }
}