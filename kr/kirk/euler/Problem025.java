package kr.kirk.euler;

import java.math.BigInteger;

/*
피보나치 수열은 아래와 같은 점화식으로 정의됩니다.

Fn = Fn-1 + Fn-2  (단, F1 = 1, F2 = 1).
이에 따라 수열을 12번째 항까지 차례대로 계산하면 다음과 같습니다.

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
수열의 값은 F12에서 처음으로 3자리가 됩니다.

피보나치 수열에서 값이 처음으로 1000자리가 되는 것은 몇번째 항입니까?
*/

public class Problem025 {
	
	public static void main(String[] args) {
		System.out.println(Problem025.solution(3));
		System.out.println(Problem025.solution(1000));
	}

	private static long solution(int x) {

		if ( x ==1) return 1;
		
		long n = 3;
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		BigInteger c = a.add(b);
		while ( true ) {
			n++;
			a = b;
			b = c;
			c = a.add(b);
			
//			System.out.println( n + " : " + c);
			if ( c.toString().length() >= x) return n;
		}
	}
}