package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.List;


/*
오일러는 다음과 같은 멋진 2차식을 제시했습니다.

    n2 + n + 41 

이 식의 n에다 0부터 39 사이의 숫자를 넣으면, 그 결과는 모두 소수가 됩니다.
하지만 n = 40일 때의 값 402 + 40 + 41 은 40×(40 + 1) + 41 이므로 41로 나누어지고, n = 41일 때 역시 412 + 41 + 41 이므로 소수가 아닙니다.

컴퓨터의 발전에 힘입어 n2 − 79n + 1601 이라는 엄청난 2차식이 발견되었는데, 이것은 n이 0에서 79 사이일 때 모두 80개의 소수를 만들어냅니다. 이 식의 계수의 곱은 -79 × 1601 = -126479가 됩니다.

아래와 같은 모양의 2차식이 있다고 가정했을 때,

    n2 + an + b   (단 | a | < 1000, | b | < 1000) 

0부터 시작하는 연속된 n에 대해 가장 많은 소수를 만들어내는 2차식을 찾아서, 그 계수 a와 b의 곱을 구하세요.


Euler discovered the remarkable quadratic formula:

n2+n+41

It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤39
. However, when n=40,402+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,412+41+41

is clearly divisible by 41.

The incredible formula n2−79n+1601
was discovered, which produces 80 primes for the consecutive values 0≤n≤79

. The product of the coefficients, −79 and 1601, is −126479.

Considering quadratics of the form:

    n2+an+b

, where |a|<1000 and |b|≤1000

where |n|
is the modulus/absolute value of n
e.g. |11|=11 and |−4|=4

Find the product of the coefficients, a
and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n=0.

*/

public class Problem027 {
	
	static List<Long> primes = new ArrayList<Long>();
	
	public static void main(String[] args) {
		System.out.println(Problem027.solution());
	}

	private static long solution() {
		int na = -999;
		int nb = -999;
		int nCount = 0;
		for ( int a = -999; a<1000; ++a) {
			for ( int b=-999; b<1000; ++b) {
				int n = getPrimeCount(a, b);
				if ( n > nCount ) {
					na = a;
					nb = b;
					nCount = n;
				}
			}
		}
		return na * nb;
	}
	
	private static int getPrimeCount(int a, int b) {
		int nCount = 0;
		for ( int n=0; n<10000; ++n) {
			if (isPrime(n*n + a*n + b)) {
				nCount++;
			}
			else break;
		}
		return nCount;
	}

	private static boolean isPrime(long i) {
		if (i<2) return false;
		double sqrt = Math.sqrt(i);
		for ( long l : primes) {
			if ( i % l == 0 ) return false;
			if ( l > sqrt ) break; // 제곱근 범위 까지만 체크.
		}
		primes.add(i);
		System.out.println(primes.size() + " => " + i);
		return true;
	}
}