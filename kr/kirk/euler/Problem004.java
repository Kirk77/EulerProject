package kr.kirk.euler;



/*
앞에서부터 읽을 때나 뒤에서부터 읽을 때나 모양이 같은 수를 대칭수(palindrome)라고 부릅니다.

두 자리 수를 곱해 만들 수 있는 대칭수 중 가장 큰 수는 9009 (= 91 × 99) 입니다.

세 자리 수를 곱해 만들 수 있는 가장 큰 대칭수는 얼마입니까?		

A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.

*/

public class Problem004 {

		
	public static void main(String[] args) {

		System.out.println("========================================================");
		System.out.println(Problem004.solution(2));
		System.out.println("========================================================");
		System.out.println(Problem004.solution(3));
		System.out.println("========================================================");
//		System.out.println(Problem4.solution(4));
	}

	private static long solution(int d) {
		long a = (long) (Math.pow(10, d) -1);	// 999
		long b = a;
		long z = (long) Math.pow(10, d-1);	// 100
		
		long x = 0;
		long temp;
		
		for ( long i = a; i>=z; --i) {
		
			for ( long j = b; j>=z; --j) {
				
				temp = i * j;
				
				if ( temp < x) break;
				if ( isPalindrome(temp) ) {
					System.out.println(i + " * " + j + " = " + temp);
					x = ( x > temp) ? x : temp;
					break;
				}
			}
		}
		
		return x;
	}

	private static boolean isPalindrome(long temp) {

		byte[] sz = String.valueOf(temp).getBytes();
		
		for ( int i=0; i<sz.length; i++) {
			if (sz[i] != sz[sz.length-1-i]) return false; 
		}
		
		return true;
	}

}
