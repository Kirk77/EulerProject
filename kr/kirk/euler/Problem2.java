package kr.kirk.euler;


/*

�Ǻ���ġ ������ �� ���� �ٷ� ���� �� �� ���� ���� ���� �˴ϴ�. 1�� 2�� �����ϴ� ��� �� ������ �Ʒ��� �����ϴ�.

    1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ... 

¦���̸鼭 4�鸸 ������ ��� ���� ���ϸ� �󸶰� �˴ϱ�?

 */
public class Problem2 {

	public static void main(String[] args) {

		System.out.println(Problem2.solution(4000000));

	}

	private static long solution(int d) {
		
		int a = 1;
		int b = 2;
		int temp = 0;
		
		int sum = 0;
		
		do {
			if ( b % 2 == 0) sum +=b;
			
			temp = b;
			b = a + b;
			a = temp;
			
		} while ( b <= d );
		
		return sum;
	}
}
