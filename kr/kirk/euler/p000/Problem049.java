package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1487, 4817, 8147은 3330씩 늘어나는 등차수열입니다. 이 수열에는 특이한 점이 두 가지 있습니다.

세 수는 모두 소수입니다.
세 수는 각각 다른 수의 자릿수를 바꿔서 만들 수 있는 순열(permutation)입니다.
1자리, 2자리, 3자리의 소수 중에서는 위와 같은 성질을 갖는 수열이 존재하지 않습니다. 하지만 4자리라면 위엣것 말고도 또 다른 수열이 존재합니다.

그 수열의 세 항을 이었을 때 만들어지는 12자리 숫자는 무엇입니까?

The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?
*/

public class Problem049 {

	static List<Long> primes = new ArrayList<Long>();

	public static void main(String[] args) {
		System.out.println(solution());
	}

	private static String solution() {
		
		primes.add(2L);
		primes.add(3L);
		for ( int i=6; i<10000; i+=6) {
			isPrime(i-1);
			isPrime(i+1);
		}
		
		for ( Long p : primes ) {
			if ( p < 1000 ) continue;
			for ( Long q : primes ) {
				if ( q <= p ) continue;
				if ( isPermutation( p, q)) {
					Long r = q + q - p;
					if ( isPermutation(q, r) && primes.contains(r)) {
						System.out.println( String.format("%d%d%d", p,q,r));
					}
				}
			}
		}
		return "";
	}

	private static boolean isPermutation(Long q, Long r) {

		byte[] bq = String.valueOf(q).getBytes();
		byte[] br = String.valueOf(r).getBytes();

		Arrays.sort(bq);
		Arrays.sort(br);
		
		for ( int i=0; i< bq.length; i++) {
			if ( bq[i] != br[i]) return false;
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