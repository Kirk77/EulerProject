package kr.kirk.euler;

import java.math.BigInteger;

/*

n! 이라는 표기법은 n × (n − 1) × ... × 3 × 2 × 1을 뜻합니다.

예를 들자면 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800 이 되는데,
여기서 10!의 각 자리수를 더해 보면 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27 입니다.

100! 의 자리수를 모두 더하면 얼마입니까?
 */

public class Problem20 {
	
	public static void main(String[] args) {


		System.out.println(Problem20.solution(10));
		System.out.println(Problem20.solution(100));
	}

	private static long solution(long n) {
		
		BigInteger f = factorial(n);
		
		BigInteger sum = BigInteger.ZERO;
		BigInteger t = BigInteger.TEN;
		
		while ( f.signum() != 0) {
			BigInteger[] r = f.divideAndRemainder(t);
			f = r[0];
			sum = sum.add(r[1]);
		}
		
		return sum.longValue();
	}

	private static BigInteger factorial(long n) {
		
		if ( n == 1) return BigInteger.ONE;
		return BigInteger.valueOf(n).multiply(factorial(n-1));
	}
}
