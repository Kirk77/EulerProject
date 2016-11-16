package kr.kirk.euler;

import java.util.ArrayList;
import java.util.List;

/*

소수 중에서 각 자리의 숫자들을 순환시켜도 여전히 소수인 것을 circular prime이라고 합니다. 예를 들어 197은 971, 719가 모두 소수이므로 여기에 해당합니다.

이런 소수는 100 밑으로 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97 처럼 13개가 있습니다.

그러면 1,000,000 밑으로는 모두 몇 개나 있을까요?



The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?


*/

public class Problem035 {

	static List<Long> primes = new ArrayList<Long>();
	
	public static void main(String[] args) {
//		System.out.println(Problem035.solution(100));
		System.out.println(Problem035.solution(1000000));
	}

	private static int solution(int x) {
		int n = 0;
		for ( int i=2; i<x; i++) {
			if (isPrime(i) && isCircularPrime(i)) {
				System.out.println(i);
				n++;
			}
		}
		System.out.println("============================");
		return n;
	}
	
	private static boolean isCircularPrime(long p) {
		
		if (p<10) return true;
			
		long s = p;
		
		do {
			s = Long.parseLong(s%10 + "" + s/10);
			
			if ( !primes.contains(s)) return false;
		}while ( s != p);
		
		return true;
	}

	private static boolean isPrime(long i) {
		double sqrt = Math.sqrt(i);
		for ( long l : primes) {
			if ( i % l == 0 ) return false;
			if ( l > sqrt ) break; // 제곱근 범위 까지만 체크.
		}
		primes.add(i);
//		System.out.println(primes.size() + " => " + i);
		return true;
	}
}