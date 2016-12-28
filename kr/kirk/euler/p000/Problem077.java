package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.List;

/*
숫자 10을 소수의 합으로 나타내는 방법은 모두 다섯 가지가 있습니다.

7 + 3
5 + 5
5 + 3 + 2
3 + 3 + 2 + 2
2 + 2 + 2 + 2 + 2

소수의 합으로 나타내는 방법이 5000가지가 넘는 최초의 숫자는 얼마입니까?

*/
public class Problem077 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
//		System.out.println(solution(5));
		System.out.println(solution(5000));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}
	
	private static long solution(int x) {

		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);

		for (int i = 6; i < 100; i += 6) {
			if (isPrime(i-1)) primes.add(i-1);
			if (isPrime(i+1)) primes.add(i+1);
		}
		
		return checkNumbers(x, primes);
	}
	
	private static long checkNumbers(int x, List<Integer> primes) {

		int limit = 2;
		while (true) {
			long[] ways = new long[limit + 1];
			ways[0] = 1;
			for (int i = 0; i < primes.size(); i++)
				for (int j = primes.get(i); j <= limit; j++)
					ways[j] += ways[j - primes.get(i)];

			if (ways[limit] > x) return limit;
			limit++;
		}
	}

	private static boolean isPrime(int k) {
		double sqrt = Math.sqrt(k);
		for (int i = 2; i < sqrt; i++)
			if (k % i == 0) return false;
		return true;
	}
}