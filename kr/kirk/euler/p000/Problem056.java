package kr.kirk.euler.p000;

import java.math.BigInteger;

/*
구골(googol)은 10100을 일컫는 말로, 1 뒤에 0이 백 개나 붙는 어마어마한 수입니다.
100100은 1 뒤에 0이 2백 개가 붙으니 상상을 초월할만큼 크다 하겠습니다.
하지만 이 숫자들이 얼마나 크건간에, 각 자릿수를 모두 합하면 둘 다 겨우 1밖에 되지 않습니다.

a, b < 100 인 자연수 ab 에 대해서, 자릿수의 합이 최대인 경우 그 값은 얼마입니까?

A googol (10100) is a massive number: one followed by one-hundred zeros; 100100 is almost unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.

Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?
*/

public class Problem056 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(solution(100));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	private static long solution(int x) {
		long sum=0;
		for (int a = 1; a < 100; a++) {
			BigInteger A = BigInteger.valueOf(a);
			for (int b = 1; b < 100; b++) {
				long s = getDigitalSum(A.pow(b));
				if ( sum < s) sum = s;
			}
		}
		return sum;
	}

	private static long getDigitalSum(BigInteger p) {
		long sum=0;
		String pp = p.toString();
		for ( int k=0; k<pp.length(); k++) sum += pp.charAt(k)-'0';
		return sum;
	}
}