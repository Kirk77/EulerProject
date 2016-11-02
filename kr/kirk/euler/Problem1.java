package kr.kirk.euler;

import java.util.HashSet;


/*

10���� ���� �ڿ��� �߿��� 3 �Ǵ� 5�� ����� 3, 5, 6, 9 �̰�, �̰��� ��� ���ϸ� 23�Դϴ�.

1000���� ���� �ڿ��� �߿��� 3 �Ǵ� 5�� ����� ��� ���ϸ� ���ϱ��?

 */
public class Problem1 {

	public static void main(String[] args) {
		System.out.println("========================================================");
		System.out.println(Problem1.solution(3,5,10));
		System.out.println("========================================================");
		System.out.println(Problem1.solution(3,5,1000));
		System.out.println("========================================================");

	}

	private static long solution(int x, int y, int l) {
		long sum = 0;
		
		HashSet<Integer> e = new HashSet<Integer>();
		
		getMultiples(x,l, e);
		getMultiples(y,l, e);
		
		for ( int n : e) {
//			System.out.print( n + ", " );
			sum += n;
		}
		
		return sum;
	}

	private static void getMultiples(int x, int l, HashSet<Integer> e) {
		
		for ( int i=1; x*i < l; ++i) {
			e.add(x*i);
		}
		
	}

}
