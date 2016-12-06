package kr.kirk.euler.p000;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/*
The 5-digit number, 16807=75, is also a fifth power. Similarly, the 9-digit number, 134217728=89, is a ninth power.
How many n-digit positive integers exist which are also an nth power?

다섯 자리 숫자인 16807은 7^5으로 5제곱수입니다. 또, 아홉 자리 숫자인 134217728은 8^9으로 9제곱수입니다.
n자리 숫자이면서 n제곱수도 되는 양의 정수는 모두 몇 개나 있습니까?
 */
public class Problem063 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(solution());
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	private static long solution() {

		Set<BigInteger> list = new HashSet<BigInteger>();
		
		for (long i = 1;i<10; i++) {
			for (int p = 1;p<100; p++) {
				BigInteger k =  BigInteger.valueOf(i).pow(p);
				int len = k.toString().length();
				if ( p == len) {
					System.out.println( i + " ^ " + p + " = " + k);
					list.add(k);
				}
				else if (p > len) break;
			}
		}
		return list.size();
	}
}