package kr.kirk.euler.p000;

/*

대칭수(palindrome)인 585는 2진수로 나타내도 10010010012가 되어 여전히 대칭수입니다.

10진법과 2진법으로 모두 대칭수인 1,000,000 이하 숫자의 합을 구하세요.

(주의: 첫번째 자리가 0이면 대칭수가 아님)




The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)

*/

public class Problem036 {

	public static void main(String[] args) {
		System.out.println(Problem036.solution(1000000));
	}

	private static long solution(int x) {
		long sum = 0;

		for (int i=1; i<=x; i++) {
			if ( isPalindrome(String.valueOf(i)) && isPalindrome(Integer.toBinaryString(i)))
				sum += i;
		}
		
		return sum;
	}

	private static boolean isPalindrome(String str) {

		byte[] bs = str.getBytes();
		
		for ( int i=0; i<bs.length/2; i++) if ( bs[i] != bs[bs.length-i-1]) return false;
		
		return true;
	}
}