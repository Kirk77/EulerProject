package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.List;

/*
 * 
오일러 피(phi) 함수 φ(n)은 n보다 작거나 같은 자연수 중 n과 서로 소인 숫자의 개수를 나타냅니다. 예를 들어 9 이하에서 9와 서로 소인 자연수는 1, 2, 4, 5, 7, 8이므로 φ(9)=6입니다.
또, 1은 어떤 자연수와도 서로 소이므로 φ(1)=1입니다.

φ(87109)의 값은 79180인데, 흥미롭게도 79180은 87109로 만들 수 있는 순열 중 하나입니다.

1 < n < 107 이고 φ(n)이 n의 순열이 되는 수 중에서, n/φ(n)이 최소인 n은 얼마입니까? 

*/

public class Problem070 {
	
	static List<Long> primes = new ArrayList<Long>();
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		System.out.println(solution(10000000));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	private static long solution(int x) {
		
		primes.clear();
		primes.add(2L);
		primes.add(3L);
		
		for (long i = 6; i <= Math.sqrt(x) * 2; i += 6) {
			if ( isPrime(i-1)) primes.add(i-1);
			if ( isPrime(i+1)) primes.add(i+1);
		}
		
		long result = 0;
		double minP = x;
		double temp = 0;

		for ( int i=0; i<primes.size(); i++) {
			for ( int j=i+1; j<primes.size(); j++) {
				long n = primes.get(i) * primes.get(j);
				if ( n > x) break;
				
				long phi = (primes.get(i)-1)*(primes.get(j)-1);
				temp = (double)n / phi;
				
				
				if ( temp < minP && check(n, phi)) {
//					System.out.println( n + " : " + phi + " -> " + temp);
					minP = temp;
					result = n;
				}
			}
		}
		return result;
	}

	private static boolean check(long n, long phi) {
		String s1 = String.valueOf(n);
		String s2 = String.valueOf(phi);

		if ( s1.length() != s2.length() ) return false;
		
		int[] c1 = new int[10];
		int[] c2 = new int[10];
		
		for ( int k=0; k<s1.length(); k++) {
			if ( s1.charAt(k) - '0' < 0 )
				k+=0;
			c1[s1.charAt(k) - '0'] ++;
			c2[s2.charAt(k) - '0'] ++;
		}
		
		for ( int k=0; k<c1.length; k++) {
			if ( c1[k] != c2[k] ) return false;
		}
		
		return true;
	}

	private static boolean isPrime(long k) {
		double sqrt = Math.sqrt(k);
		for ( int i=2; i<=sqrt; i++) {
			if ( k % i == 0 ) return false;
		}
		return true;
	}
}
