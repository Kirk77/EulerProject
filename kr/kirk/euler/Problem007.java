package kr.kirk.euler;

import java.util.ArrayList;
import java.util.List;


/*
소수를 크기 순으로 나열하면 2, 3, 5, 7, 11, 13, ... 과 같이 됩니다.

이 때 10,001번째의 소수를 구하세요.


By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?

*/

public class Problem007 {

	static List<Long> primes = new ArrayList<Long>();
		
	public static void main(String[] args) {

		System.out.println("========================================================");
		System.out.println(Problem007.solution(10001));
		System.out.println("========================================================");
	}

	// n 번째  소수 구하기
	private static long solution(long n) {
	
		if ( n==1 ) return 2;
		if ( n==2 ) return 3;
		
		primes.clear();
		primes.add(2L);
		primes.add(3L);
		
		// 모든 소수는 6n+1 또는 6n+5 ( = 6n-1 ) 형태이다.
		for ( long i=6;; i+=6 ) {
			if ( isPrime(i-1)) {
				if ( primes.size() == n) return primes.get(primes.size()-1);
			}
			if ( isPrime(i+1)) {
				if ( primes.size() == n) return primes.get(primes.size()-1);
			}
		}
	}

	private static boolean isPrime(long i) {
		double sqrt = Math.sqrt(i);
		for ( long l : primes) {
			if ( i % l == 0 ) return false;
			if ( l > sqrt ) break; // 제곱근 범위 까지만 체크.
		}
		primes.add(i);
		System.out.println(primes.size() + " => " + i);
		return true;
	}
}
