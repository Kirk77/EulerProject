package kr.kirk.euler;

import java.util.ArrayList;
import java.util.List;

/*
41은 소수이면서 다음과 같은 6개의 연속된 소수의 합으로도 나타낼 수 있습니다.

41 = 2 + 3 + 5 + 7 + 11 + 13
이것은 100 이하에서는 가장 길게 연속된 소수의 합으로 이루어진 소수입니다.

1000 이하에서는 953이 연속된 소수 21개의 합으로 가장 깁니다.

1백만 이하에서는 어떤 소수가 가장 길게 연속되는 소수의 합으로 표현될 수 있습니까?


The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?
*/

public class Problem050 {

	static List<Long> primes = new ArrayList<Long>();

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(solution(100));
		System.out.println(solution(1000));
		System.out.println(solution(1000000));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	private static long solution(long x) {

		primes.clear();
		primes.add(2L);
		primes.add(3L);
		for (int i = 6; i < x; i += 6) {
			isPrime(i - 1);
			isPrime(i + 1);
		}

		long sum = 0;
		for (long p : primes) {
			sum += p;
		}
		
		System.out.println( "=========================== " + x) ;
		long result = 0;
		int nCount = 0;
		
		for (int i = -1; i < primes.size(); i++) {
			long tempSum = sum;
			if (i > -1) {
				for (int ii = 0; ii <= i; ii++)
					tempSum -= primes.get(ii);
			}
			
			int j=primes.size()-1;
			for ( ; j > i && tempSum - primes.get(j) > x; j--) {
				tempSum -= primes.get(j);
			}
			
			for (; nCount < j-i; j--) {
				
				tempSum -= primes.get(j);
				
				if ( primes.contains(tempSum)) {
					nCount = j - i;
					result = tempSum;
					
					System.out.println(  (nCount -1)+ " : " + tempSum);
					break;
				}
			}
		}
		
		return result;
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