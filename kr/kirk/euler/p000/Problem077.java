package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
숫자 10을 소수의 합으로 나타내는 방법은 모두 다섯 가지가 있습니다.

7 + 3
5 + 5
5 + 3 + 2
3 + 3 + 2 + 2
2 + 2 + 2 + 2 + 2

소수의 합으로 나타내는 방법이 5000가지가 넘는 최초의 숫자는 얼마입니까?
*/
public class Problem077 {
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(solution(5));
//		System.out.println(solution(5000));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}
	
	private static long solution(long x) {
		List<Long> list = new ArrayList<Long>();
		list.add(2L);
		list.add(3L);
		for ( long i = 6; i<10000; i+=6) {
			if ( isPrime(i-1)) countX(i-1, x);
			if ( isPrime(i+1)) countX(i+1, x);
		}
		return -1;
	}

	private static boolean isPrime(long k) {
		double sqrt = Math.sqrt(k);
		for ( int i=2; i<sqrt; i++) {
			if ( k % i == 0 ) return false;
		}
		return true;
	}
}