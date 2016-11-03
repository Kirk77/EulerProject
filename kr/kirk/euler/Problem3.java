package kr.kirk.euler;

import java.util.ArrayList;
import java.util.List;


/*

어떤 수를 소수의 곱으로만 나타내는 것을 소인수분해라 하고, 이 소수들을 그 수의 소인수라고 합니다.
예를 들면 13195의 소인수는 5, 7, 13, 29 입니다.

600851475143의 소인수 중에서 가장 큰 수를 구하세요.

 */
public class Problem3 {

	static List<Long> primes = new ArrayList<Long>();
	static List<Long> p2 = new ArrayList<Long>();
	
	public static void main(String[] args) {

		System.out.println(Problem3.solution(13195L));
		System.out.println(Problem3.solution(600851475143L));

	}

	private static long solution(long d) {
				
		if ( d < 4 ) return d;

		primes.clear();
		p2.clear();
		primes.add(2L);
		primes.add(3L);
		
		// 모든 소수는 6n+1 또는 6n+5 ( = 6n-1 ) 형태이다.
		for ( long i = 6; i<=d; i += 6) {
			
			if ( check(i - 1, d) ) break;
			if ( check(i + 1, d) ) break;

		}
		return primes.get(primes.size()-1);
	}

	private static boolean check(long l, long d) {
		if ( isPrime(l) ) {
			if ( d % l == 0 ) {
				p2.add(l);
				if (isOver(d)) {
					System.out.println("========================================================");
					for ( long x : p2) System.out.print( x + ", ");
					System.out.println("");
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isOver(long d) {
		long s = 1;
		for ( long i : p2 ) s *= i;
		return d == s;
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
