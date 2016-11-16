package kr.kirk.euler;

/*

숫자 145에는 신기한 성질이 있습니다. 각 자릿수의 팩토리얼(계승)을 더하면  1! + 4! + 5! = 1 + 24 + 120 = 145 처럼 자기 자신이 됩니다.

이렇게 각 자릿수의 팩토리얼을 더하면 자기 자신이 되는 모든 수의 합을 구하세요.

단, 1! = 1 과 2! = 2 의 경우는 덧셈이 아니므로 제외합니다.



145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.


*/

public class Problem034 {

	static long[] digits = {
		factorial(0),
		factorial(1),
		factorial(2),
		factorial(3),
		factorial(4),
		factorial(5),
		factorial(6),
		factorial(7),
		factorial(8),
		factorial(9),
	};
	
	static int n = 1;
	static long min = 0;
	static long max = 0;
	
	public static void main(String[] args) {
		System.out.println(Problem034.solution(10));
	}

	private static long solution(long x) {
		
		for (long i=1; i<=x; i++) {
			min = (long) Math.pow(10, i-1);
			max = (long) Math.pow(10, i);
			
			checkSumFactorials(i, 0);
		}
		return -1;
	}
	
	private static long checkSumFactorials(long i, long l) {
		if ( i == 0 ) {
			if (min <= l && l < max)
				System.out.println((n++) + " : " + l);
			return l;
		}
		
		for ( long d : digits ) {
			checkSumFactorials(i-1, d + l);
		}
		return 0;
	}

	private static long factorial(int n) {
		if ( n == 0) return 0;
		if ( n == 1) return 1;
		return n * factorial(n-1);
	}
}