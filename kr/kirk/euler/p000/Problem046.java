package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.List;

/*

크리스티안 골드바흐는 모든 홀수인 합성수를 (소수 + 2×제곱수)로 나타낼 수 있다고 주장했습니다.

9 = 7 + 2×12
15 = 7 + 2×22
21 = 3 + 2×32
25 = 7 + 2×32
27 = 19 + 2×22
33 = 31 + 2×12

이 추측은 잘못되었음이 밝혀졌습니다.

위와 같은 방법으로 나타낼 수 없는 가장 작은 홀수 합성수는 얼마입니까?


It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

9 = 7 + 2×12
15 = 7 + 2×22
21 = 3 + 2×32
25 = 7 + 2×32
27 = 19 + 2×22
33 = 31 + 2×12

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?

*/

public class Problem046 {

	static List<Long> primes = new ArrayList<Long>();
	
	public static void main(String[] args) {
		System.out.println(solution());
	}

	private static long solution() {

		primes.add(2L);
		for (int i=3; ; i+=2) {
			if (isPrime(i)) continue;
			if (checkNumber(i) == false) {
				return i;
			}
		}
	}
	
	private static boolean checkNumber(int i) {
		for ( long l : primes) {
			int k = (int)Math.sqrt(( i - l ) / 2);
			if ( i == l + 2 * k * k) return true;
		}
		return false;
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