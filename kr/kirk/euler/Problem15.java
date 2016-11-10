package kr.kirk.euler;

/*

아래와 같은 2 × 2 격자의 왼쪽 위 모서리에서 출발하여 오른쪽 아래 모서리까지 도달하는 길은 모두 6가지가 있습니다 (거슬러 가지는 않기로 합니다).

그러면 20 × 20 격자에는 모두 몇 개의 경로가 있습니까?
 */

public class Problem15 {
	
	public static void main(String[] args) {

		System.out.println(Problem15.solution(2,2));
		System.out.println(Problem15.solution(20,20));
		System.out.println(Problem15.solution(25,25));
	}

	private static long solution(int x, int y) {
		
		long [][] position = new long[x+1][y+1];
		
		for ( int i=0; i<=x; ++i ) {
			for ( int j=0; j<=y; ++j ) {
				if ( i==0 || j==0 ) {
					position[i][j] = 1;
				}
				else {
					position[i][j] = position[i-1][j] + position[i][j-1];
				}
			}
		}
		
		return position[x][y];
	}
}
