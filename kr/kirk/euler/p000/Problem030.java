package kr.kirk.euler.p000;

/*
각 자리의 숫자를 4제곱해서 더했을 때 자기 자신이 되는 수는 놀랍게도 단 세 개밖에 없습니다.

1634 = 14 + 64 + 34 + 44
8208 = 84 + 24 + 04 + 84
9474 = 94 + 44 + 74 + 44
(1 = 14의 경우는 엄밀히 말해 합이 아니므로 제외합니다)

위의 세 숫자를 모두 더하면 1634 + 8208 + 9474 = 19316 입니다.

그렇다면, 각 자리 숫자를 5제곱해서 더했을 때 자기 자신이 되는 수들의 합은 얼마입니까?

Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

1634 = 14 + 64 + 34 + 44
8208 = 84 + 24 + 04 + 84
9474 = 94 + 44 + 74 + 44
As 1 = 14 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
*/

public class Problem030 {
	
	static int[] d = new int[10];
	
	public static void main(String[] args) {
//		System.out.println(Problem030.solution(4));
		System.out.println(Problem030.solution(5));
	}

	private static long solution(int x) {
		
		for ( int i=0; i<10; i++) {
			d[i] = (int) Math.pow(i, x);
		}
		
		long sum = 0;
		for ( long i=2; i<10000000;i++) {
			long f = fetFifthPowers(i);
			if ( i == f) {
				System.out.println(f);
				sum += i;
			}
		}
		return sum;
	}

	private static long fetFifthPowers(long i) {
		byte[] bytes = String.valueOf(i).getBytes();
		
		long sum = 0;
		for ( byte b : bytes) {
			sum += d[b-'0'];
		}
		return sum;
	}
}