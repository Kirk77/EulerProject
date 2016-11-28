package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.List;

/*


네 개의 소수 3, 7, 109, 673은 상당히 특이한 성질이 있습니다. 넷 중에 아무것이나 두 개를 골라서 어떤 쪽으로 이어붙이던지 그 결과도 소수가 됩니다. 예를 들어 7과 109를 고르면 7109와 1097 또한 소수입니다.
3, 7, 109, 673는 이런 성질을 가진 네 소수 중에서 그 합이 792로 가장 작습니다,

다섯 소수 중에 어떤 두 개를 골라 이어붙여도 소수가 되는 수들을 찾아서, 그 합의 최소값을 구하세요.


The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating them in any order the result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.

Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.

*/

public class Problem060 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(solution(5));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	private static long solution(int x) {
		long[] p = new long[x];
		p[0] = 3;
		p[1] = 7;
		p[2] = 109;
		p[3] = 673;
		
		for ( long i=673 - 673%6; i<10000000; i+=6) {
			if ( isPrime(i-1) && checkPrimes(p, i-1) ) break;
			if ( isPrime(i+1) && checkPrimes(p, i+1) ) break;
		}
		long sum = 0;
		for (long l : p) sum += l;
		return sum;
	}

	private static boolean checkPrimes(long[] p, long l) {
		if ( p[3] == l ) return false;
		
		for ( int i=0; i<p.length-1; i++) {
			if ( !isPrime( Long.parseLong(p[i] +""+ l ))) return false;
			if ( !isPrime( Long.parseLong( l +""+ p[i] ))) return false;
		}
		System.out.println(l);
		p[4] = l;
		return true;
	}

	private static boolean isPrime(long k) {
		
		double sqrt = Math.sqrt(k);
		for ( int i=2; i<sqrt; i++) {
			if ( k % i == 0 ) return false;
		}
		return true;
	}
}