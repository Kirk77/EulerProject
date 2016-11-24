package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.List;

/*

서로 다른 두 개의 소인수를 갖는 수들이 처음으로 두 번 연달아 나오는 경우는 다음과 같습니다.

14 = 2 × 7
15 = 3 × 5

서로 다른 세 개의 소인수를 갖는 수들이 처음으로 세 번 연속되는 경우는 다음과 같습니다.

644 = 2² × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19

서로 다른 네 개의 소인수를 갖는 수들이 처음으로 네 번 연속되는 경우를 찾으세요. 그 첫번째 숫자는 얼마입니까?



The first two consecutive numbers to have two distinct prime factors are:

14 = 2 × 7
15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2² × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?

*/

public class Problem047 {

	static List<Long> primes = new ArrayList<Long>();
	
	public static void main(String[] args) {
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
	}

	private static long solution( int x) {
		primes.clear();
		int nCount = 0;
		
		for ( long i=2;;i++) {
			if ( isPrime(i)) {
				continue;
			} else {
				if (checkX( i, x)) {
					nCount++;
				} else {
					nCount = 0;
				}
			}
		
			if ( nCount == x-1) {
				return i - nCount;
			}
		}
	}
	
	private static boolean checkX(long i, int x) {
		List<Long> pF1 = new ArrayList<Long>();
		List<Long> pF2 = new ArrayList<Long>();
		
		for( long l : primes) {
			if ( i < l ) break;
			if ( i%l ==0 )
				pF1.add( l);
		}
		if ( pF1.size() != x) return false;

		
		for( long l : primes) {
			if ( i-1 < l ) break;
			if ( (i-1)%l ==0 )
				pF2.add( l);
		}
		if ( pF2.size() != x) return false;

		for ( long p1 : pF1) for( long p2 : pF2) if ( p1 == p2) return false;
		
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