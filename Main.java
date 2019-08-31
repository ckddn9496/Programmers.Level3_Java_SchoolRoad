public class Main {

	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = {{2,2}}; // return 4
		// 예외 case...
//		int m = 7;
//		int n = 4;
//		int[][] puddles = {{2,1},{2,2},{2,3},{4,2},{4,3},{4,4},{6,2},{6,3}}; // return 2
	
		System.out.println(new Solution().solution(m, n, puddles));
	}

}
class Solution {
	private static int PUDDLE = -1;
    public int solution(int m, int n, int[][] puddles) {
    	int answer = 0;
        int[][] map = new int[n+1][m+1];
        map[1][1] = 1;
        for (int i = 0; i < puddles.length; i++) {
        	map[puddles[i][1]][puddles[i][0]] = PUDDLE;
        }
//        printMap(m,n,map);
        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= m; j++ ) {
        		if (map[i][j] == PUDDLE)
        			map[i][j] = 0;
        		else {
        			if (map[i][j] == 1) { // 첫번째 줄
        				map[i][j] += map[i][j-1];
        			} else {
        				map[i][j] = (map[i-1][j] + map[i][j-1]) % 1000000007;
        			}
        		}
        		if (j == m)
        			answer = map[i][j];
        	}
        }
        
        return answer;
    }
//    private void printMap(int m, int n, int[][] map) {
//    	for (int i = 1; i <= n; i++) {
//    		for (int j = 1; j <= m ; j++) {
//    			System.out.print(String.format("%4d", map[i][j]));
//    		}
//    		System.out.println();
//    	}
//    }
}