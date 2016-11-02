package kr.kirk.euler;


/*

1 ~ 10 ������ � ���ε� ������ �������� ���� ���� ���� 2520�Դϴ�.

�׷��� 1 ~ 20 ������ � ���ε� ������ �������� ���� ���� ���� ���Դϱ�?	
*/

public class Problem5 {

		
	public static void main(String[] args) {

		System.out.println("========================================================");
		System.out.println(Problem5.solution(1,10));
		System.out.println("========================================================");
		System.out.println(Problem5.solution(1,20));
		System.out.println("========================================================");
	}

	private static long solution(long n, long m) {
		
		if ( n == m ) return n;
		
		long x = n;
		for ( long i = n+1; i<=m; ++i ) {
			x = lcm(x, i);
		}
		
		return x;
	}

	// �ּҰ����
	private static long lcm(long x, long i) {
		
		if ( x == i ) return x;
		
		long big =  x > i ? x : i;
		long small = x > i ? i : x;
		
		long r = 1;
		
		while (r>0) {
			r = big % small;
			big = small;
			small = r;
		}
		
		return x * i / big;
	}

}
