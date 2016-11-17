package kr.kirk.euler;

import java.util.ArrayList;
import java.util.List;

/*

소수 3797에는 왼쪽부터 자리수를 하나씩 없애거나 (3797, 797, 97, 7) 오른쪽부터 없애도 (3797, 379, 37, 3) 모두 소수가 되는 성질이 있습니다.

이런 성질을 가진 소수는 단 11개만이 존재합니다. 이것을 모두 찾아서 합을 구하세요.

(참고: 2, 3, 5, 7은 제외합니다)


The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

*/

public class Problem037 {

	static List<Long> primes = new ArrayList<Long>();
	
	public static void main(String[] args) {
//		System.out.println(Problem037.solution(10));
		System.out.println(Problem037.solution(11));
	}

	private static long solution(int x) {
		long sum = 0;
		primes.clear();
		int nCount = 0;
		for (int i=2; nCount < x; i++) {
			if ( isPrime(i) && isRemainPrime(i)){
				System.out.println(i);
				sum += i;
				nCount++;
			}
		}
		System.out.println("=====================");
		return sum;
	}

	private static boolean isRemainPrime(long i) {
		if (i < 10) return false;
		long p = i;
		
		if ( p == 3797 ) {
			p = p * 1;
		}
		long r = 1;
		while (p>10) {
			p /= 10;
			r *= 10;
//			System.out.println( i + " check " + p + " | " + i%r);
			if ( ! primes.contains(p)) return false;
			if ( ! primes.contains(i%r)) return false;
		}
		
		return true;
	}

	private static boolean isPrime(long i) {
		double sqrt = Math.sqrt(i);
		for ( long l : primes) {
			if ( i % l == 0 ) return false;
			if ( l > sqrt ) break; // 제곱근 범위 까지만 체크.
		}
		primes.add(i);
		return true;
	}
}