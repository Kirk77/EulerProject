package kr.kirk.euler;

/*
소수점 뒤에 양의 정수를 차례대로 붙여 나가면 아래와 같은 무리수를 만들 수 있습니다.

0.123456789101112131415161718192021...

이 무리수의 소수점 아래 12번째 자리에는 1이 옵니다 (위에서 붉게 표시된 숫자).

소수점 아래 n번째 숫자를 dn이라고 했을 때, 아래 식의 값은 얼마입니까?

d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000

 

An irrational decimal fraction is created by concatenating the positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If dn represents the nth digit of the fractional part, find the value of the following expression.

d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000

*/

public class Problem040 {
	
	static StringBuffer sb = new StringBuffer(".");
	public static void main(String[] args) {
		System.out.println(solution(1000000));
	}

	private static int solution(int x) {
		
		for( int i=1; sb.length()<=x; i++) {
			sb.append(i);
		}
		
		int n = 1;		
		while( x > 0) {
			n *= sb.charAt(x) - '0';
			x /= 10;
		}
		
		return n;
	}	
}