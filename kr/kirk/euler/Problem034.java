package kr.kirk.euler;

import java.math.BigInteger;

/*

숫자 145에는 신기한 성질이 있습니다. 각 자릿수의 팩토리얼(계승)을 더하면  1! + 4! + 5! = 1 + 24 + 120 = 145 처럼 자기 자신이 됩니다.

이렇게 각 자릿수의 팩토리얼을 더하면 자기 자신이 되는 모든 수의 합을 구하세요.

단, 1! = 1 과 2! = 2 의 경우는 덧셈이 아니므로 제외합니다.



145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.


*/

public class Problem034 {

	public static void main(String[] args) {
		System.out.println(Problem034.solution());
	}

	private static BigInteger solution() {
		
		for ( BigInteger i=BigInteger.ONE; i.compareTo(BigInteger.TEN.pow(10)) < 0; i = i.add(BigInteger.ONE)) {
			BigInteger sf = getSumFactorial(i);
			if ( i.compareTo(sf) == 0)
				System.out.println(i + " : " + sf);
		}
		
		return BigInteger.ZERO;
	}
	
	private static BigInteger getSumFactorial(BigInteger i) {
		if (i.compareTo(BigInteger.ZERO) == 0) return BigInteger.ZERO;
		return getSumFactorial(i.divide(BigInteger.TEN)).add(factorial(i.remainder(BigInteger.TEN)));
	}

	private static BigInteger factorial(BigInteger n) {
		if ( n.compareTo(BigInteger.ZERO) == 0) return BigInteger.ZERO;
		if ( n.compareTo(BigInteger.ONE) == 0) return BigInteger.ONE;
		return n.multiply(factorial(n.add(BigInteger.ONE.negate())));
	}
}