package kr.kirk.euler;

import java.util.ArrayList;
import java.util.List;


/*

� ���� �Ҽ��� �����θ� ��Ÿ���� ���� ���μ����ض� �ϰ�, �� �Ҽ����� �� ���� ���μ���� �մϴ�.
���� ��� 13195�� ���μ��� 5, 7, 13, 29 �Դϴ�.

600851475143�� ���μ� �߿��� ���� ū ���� ���ϼ���.

 */
public class Problem3 {

	static List<Long> p = new ArrayList<Long>();
	static List<Long> p2 = new ArrayList<Long>();
	
	public static void main(String[] args) {

		System.out.println(Problem3.solution(600851475143L));

	}

	private static long solution(long d) {
				
		for ( long i = 2; i<=d; ++i) {
			
			if ( isPrime(i) ) {
				i = p.get(p.size()-1);
				
				if ( d % i == 0 ) {
					p2.add(i);
					if (isOver(d)) {
						System.out.println("========================================================");
						for ( long x : p2) System.out.print( x + ", ");
						System.out.println("");
						return p2.get(p2.size()-1);
					}
				}
			}
		}
		return p.get(p.size()-1);
	}

	private static boolean isOver(long d) {
		long s = 1;
		for ( long i : p2 ) s *= i;
		return d == s;
	}

	private static boolean isPrime(long i) {
		for ( long l : p) {
			if ( i % l == 0) return false;
		}
		p.add(i);
		System.out.println(i);
		return true;
	}
}
