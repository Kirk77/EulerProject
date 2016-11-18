package kr.kirk.euler;

/*
11 + 22 + 33 + ... + 1010 = 10405071317 입니다.

11 + 22 + 33 + ... + 10001000 의 마지막 10자리 숫자는 무엇입니까?

The series, 11 + 22 + 33 + ... + 1010 = 10405071317.

Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
*/

public class Problem048 {
	
	static final long tt = (long) Math.pow(10, 10);
	
	public static void main(String[] args) {
		System.out.println(solution(10));
		System.out.println(solution(1000));
	}

	private static long solution( int x) {
		long result = 0;
		
		for ( long  i = 1; i<=x; i++) {
			result = (result + getLast10Digits(i)) % tt;
		}
		return result;
	}

	private static long getLast10Digits(long i) {

		long d = 1;
		for ( int k = 0; k<i; k++) {
			d = ( d*i ) % tt;
		}
		return d;
	}
}