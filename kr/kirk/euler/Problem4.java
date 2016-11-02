package kr.kirk.euler;



/*
�տ������� ���� ���� �ڿ������� ���� ���� ����� ���� ���� ��Ī��(palindrome)��� �θ��ϴ�.

�� �ڸ� ���� ���� ���� �� �ִ� ��Ī�� �� ���� ū ���� 9009 (= 91 �� 99) �Դϴ�.

�� �ڸ� ���� ���� ���� �� �ִ� ���� ū ��Ī���� ���Դϱ�?		
*/

public class Problem4 {

		
	public static void main(String[] args) {

		System.out.println("========================================================");
		System.out.println(Problem4.solution(2));
		System.out.println("========================================================");
		System.out.println(Problem4.solution(3));
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
