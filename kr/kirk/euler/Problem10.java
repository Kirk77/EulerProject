package kr.kirk.euler;

import java.util.ArrayList;
import java.util.List;


/*
10 이하의 소수를 모두 더하면 2 + 3 + 5 + 7 = 17 이 됩니다.

이백만(2,000,000) 이하 소수의 합은 얼마입니까?
*/

public class Problem10 {

	static List<Long> primes = new ArrayList<Long>();
		
	public static void main(String[] args) {

		System.out.println("========================================================");
		System.out.println(Problem10.solution(10));
		System.out.println("========================================================");
		System.out.println(Problem10.solution(2000000));
	}

	private static long solution(long d) {
	
		primes.clear();

		if ( d < 2 ) return getSum(primes);
		primes.add(2L);
		
		if ( d < 3 ) return getSum(primes); 
		primes.add(3L);

		for (long i=6; i+1<=d; i+=6) {
			
			isPrime(i-1);
			isPrime(i+1);
		}
		
		return getSum(primes);
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

	private static long getSum(List<Long> p) {
		long sum = 0;
		for ( long l : p) sum += l;
		
		return sum;
	}

	
}
