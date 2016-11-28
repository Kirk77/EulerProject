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

	static List<Long> primes  = new ArrayList<Long>();
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
//		System.out.println(solution(4));
		System.out.println(solution(5));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	private static long solution(int x) {

		primes.clear();
		primes.add(2L);
		primes.add(3L);
		for (long i = 6; i < 10000; i += 6) {
			if (isPrime(i - 1)) primes.add(i-1);
			if(isPrime(i + 1)) primes.add(i+1);
		}
		
		for (int a = 1; a < primes.size()-4; a++) {
			for (int b = a + 1; b < primes.size()-3; b++) {
				if ( !isPrimeSet( primes.get(a),primes.get(b))) continue;
				for (int c = b + 1; c < primes.size()-2; c++) {
					if ( !isPrimeSet(primes.get(a), primes.get(c))
							|| !isPrimeSet(primes.get(b), primes.get(c))) continue;
					for (int d = c + 1; d < primes.size()-1; d++) {
						if ( !isPrimeSet(primes.get(a), primes.get(d))
								|| !isPrimeSet(primes.get(b), primes.get(d))
								|| !isPrimeSet(primes.get(c), primes.get(d))
						) continue;
						for (int e=d+1; e<primes.size(); e++) {
							if ( !isPrimeSet(primes.get(a), primes.get(e))
									|| !isPrimeSet(primes.get(b), primes.get(e))
									|| !isPrimeSet(primes.get(c), primes.get(e))
									|| !isPrimeSet(primes.get(d), primes.get(e))
							) continue;	
							System.out.println( String.format("[%d,%d,%d,%d,%d]", primes.get(a),primes.get(b),primes.get(c),primes.get(d),primes.get(e)));
							return primes.get(a)+primes.get(b)+primes.get(c)+primes.get(d)+primes.get(e);
						}
					}
				}
			}
		}
		return -1;
	}

	private static boolean isPrimeSet(long a, long b) {

		if ( isPrime(Long.parseLong(String.format("%d%d", a, b)))
				&& isPrime(Long.parseLong(String.format("%d%d", b, a)))) return true;
		
		return false;
	}

	private static boolean isPrime(long k) {
		double sqrt = Math.sqrt(k);
		for ( int i=2; i<sqrt; i++) {
			if ( k % i == 0 ) return false;
		}
		return true;
	}
}