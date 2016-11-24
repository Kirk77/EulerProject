package kr.kirk.euler.p000;

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

	public static void main(String[] args) {
		// 아래 출력결과로 최대 7자리 수 2540160 를 최대범위로 판단.
		// for (long x=1; x<20; x++) System.out.println(x + " : " + digits[9] * x );
	
		System.out.println(Problem034.solution(7));
	}

	private static long solution(int x) {
		long sum = 0;
//		long limit = (long) Math.pow(10, x);
		long limit = 2540160 + 1;
		for ( long i=3; i<limit; i++) {
			if ( i == getSumFactorial(i)) {
				sum += i;
				System.out.println(i);
			}
		}		
		return sum;
	}

	private static long getSumFactorial(long i) {
		if (i == 0) return 0;
		return getSumFactorial(i/10) + digits[(int) (i%10)];
	}
	
	private static long factorial(long n) {
		if ( n < 2) return 1;
		return n * factorial(n-1);
	}
}