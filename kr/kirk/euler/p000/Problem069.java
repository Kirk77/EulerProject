package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*

오일러의 피(phi)함수 φ(n)은 n보다 작거나 같으면서 n과 서로 소인 숫자의 개수를 나타냅니다. 예를 들어, 9보다 작거나 같으면서 9와 서로 소인 것은 1, 2, 4, 5, 7, 8이므로 φ(9)=6이 됩니다.
n 	서로 소인 수 	φ(n) 	n/φ(n)
2 	1 	1 	2
3 	1, 2 	2 	1.5
4 	1, 3 	2 	2
5 	1, 2, 3, 4 	4 	1.25
6 	1, 5 	2 	3
7 	1, 2, 3, 4, 5, 6 	6 	1.1666...
8 	1, 3, 5, 7 	4 	2
9 	1, 2, 4, 5, 7, 8 	6 	1.5
10 	1, 3, 7, 9 	4 	2.5

위에서 보듯이 n ≤ 10인 경우 n/φ(n)의 값은 n=6일때 최대가 됩니다.

n이 1,000,000 이하의 자연수일 때, n/φ(n)는 언제 최대가 됩니까?
 */

public class Problem069 {
	
	static List<Integer> primes = new ArrayList<Integer>();
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
//		System.out.println(solution(10));
		System.out.println(solution(1000));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	private static long solution(int x) {
		
		primes.clear();
		primes.add(2);
		primes.add(3);
		
		for (int i=6; i<=x; i+=6) {
			if ( isPrime(i-1)) primes.add(i-1);
			if ( isPrime(i+1)) primes.add(i+1);
		}
		
		int result = 0;
		double maxP = 0;
		double temp = 0;
		for ( int i=2; i<=x; i++) {
			if ( i ==30) 
				i += 0;
			temp = (double)i / getPhi(i);
			if ( temp > maxP) {
				maxP = temp;
				result = i;
			}
		}
		System.out.println( result + " : " + result / maxP + " -> " + maxP);
		return result;
	}

	private static boolean isPrime(long k) {
		double sqrt = Math.sqrt(k);
		for ( int i=2; i<=sqrt; i++) {
			if ( k % i == 0 ) return false;
		}
		return true;
	}
	
	private static int getPhi(int n) {

		if ( isPrime(n)) return n-1;
		
		HashSet<Integer> s = new HashSet<Integer>();
	
		for (int p : primes) {
			if ( p > n) break;
			if ( n % p == 0) {
				for (int pk=p; pk<n; pk+=p) {
					s.add(pk);
				}
			}
		}
		return n-1-s.size();
	}
}
