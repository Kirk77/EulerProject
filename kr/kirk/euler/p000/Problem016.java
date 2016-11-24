package kr.kirk.euler.p000;

import java.math.BigInteger;

/*
2^15 = 32768 의 각 자리수를 더하면 3 + 2 + 7 + 6 + 8 = 26 입니다.

2^1000의 각 자리수를 모두 더하면 얼마입니까?
 */

public class Problem016 {
	
	public static void main(String[] args) {

		System.out.println(Problem016.solution(2,15));
		System.out.println(Problem016.solution(2,1000));
	}

	private static long solution(int x, int y) {
		
		BigInteger b = BigInteger.valueOf(x);
		b = b.pow(y);
		long sum = 0;
		BigInteger t = BigInteger.valueOf(10);
		
		while( b.signum() != 0) {
			BigInteger[] r = b.divideAndRemainder(t);
			
			b = r[0];
			sum += r[1].longValue();
		}
		
		System.out.println("================================");
		return sum;
	}
}
