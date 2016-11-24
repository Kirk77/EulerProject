package kr.kirk.euler.p000;

/*

숫자 1부터 시작해서 우측으로부터 시계방향으로 감아 5×5 행렬을 만들면 아래와 같이 됩니다.

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

여기서 대각선상의 숫자를 모두 더한 값은 101 입니다.

같은 방식으로 1001×1001 행렬을 만들었을 때, 대각선상의 숫자를 더하면 얼마가 됩니까?



Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?


1
3 5 7 9			2  ( 3x3 )
13 17 21 25		4  ( 5x5 )
31 37 43 49		6  ( 7x7 )
*/

public class Problem028 {
	
	public static void main(String[] args) {
		System.out.println(Problem028.solution(5));
		System.out.println(Problem028.solution(1001));
	}

	private static long solution(int x) {
		
		int sum = 1;
		int n = 2;
		int k = 1;
		for ( int i=3; i<=x*x; i+=n) {
			sum += i;
			
			System.out.println(k + " : " + i);
			
			if ( k > 0 && k%4== 0 )
				n += 2;
			k++;
		}
		
		return sum;
	}
}