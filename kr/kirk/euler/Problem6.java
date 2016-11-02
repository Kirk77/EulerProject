package kr.kirk.euler;


/*

1���� 10���� �ڿ����� ���� ������ ���ϸ� ������ �����ϴ� (������ ��).

    12 + 22 + ... + 102 = 385

1���� 10�� ���� ���� ������ �� ����� �����ϸ� ������ �����ϴ� (���� ����).

    (1 + 2 + ... + 10)2 = 552 = 3025

���� 1���� 10���� �ڿ����� ���� "���� ����"�� "������ ��" �� ���̴� 3025 - 385 = 2640 �� �˴ϴ�.

�׷��� 1���� 100���� �ڿ����� ���� "���� ����"�� "������ ��"�� ���̴� ���Դϱ�?
*/

public class Problem6 {

		
	public static void main(String[] args) {

		System.out.println("========================================================");
		System.out.println(Problem6.solution(1,10));
		System.out.println("========================================================");
		System.out.println(Problem6.solution(1,100));
		System.out.println("========================================================");
	}

	private static long solution(int n, int m) {
		
		long sum = 0;
		long sq = 0;
		for ( long i=n; i<=m; ++i) {
			sq += i*i; 
			sum += i;
		}
		return sum*sum - sq;
	}

}
