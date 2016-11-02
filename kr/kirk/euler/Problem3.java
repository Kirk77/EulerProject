package kr.kirk.euler;

import java.util.ArrayList;
import java.util.List;


/*

어떤 수를 소수의 곱으로만 나타내는 것을 소인수분해라 하고, 이 소수들을 그 수의 소인수라고 합니다.
예를 들면 13195의 소인수는 5, 7, 13, 29 입니다.

600851475143의 소인수 중에서 가장 큰 수를 구하세요.

 */
public class Problem3 {

	static List<Long> p = new ArrayList<Long>();
	static List<Long> p2 = new ArrayList<Long>();
	
	public static void main(String[] args) {

		System.out.println(Problem3.solution(600851475143L));

	}

	private static long solution(long d) {
				
		for ( long i = 2; i<=d; ++i) {
			
			if ( isPrime(i) ) {
				if ( d % i == 0 ) {
					p2.add(i);
					if (isOver(d)) {
						System.out.println("========================================================");
						for ( long x : p2) System.out.print( x + ", ");
						System.out.println("");
						return p2.get(p2.size()-1);
					}
				}
			}
		}
		return p.get(p.size()-1);
	}

	private static boolean isOver(long d) {
		long s = 1;
		for ( long i : p2 ) s *= i;
		return d == s;
	}

	private static boolean isPrime(long i) {
		for ( long l : p) {
			if ( i % l == 0) return false;
		}
		p.add(i);
		System.out.println(i);
		return true;
	}
}
