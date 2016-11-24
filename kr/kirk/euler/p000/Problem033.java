package kr.kirk.euler.p000;

/*
분수 49/98에는 재미있는 성질이 있습니다. 수학을 잘 모르는 사람이 분모와 분자에서 9를 각각 지워서 간단히 하려고 49/98 = 4/8 처럼 계산해도 올바른 결과가 됩니다.

이에 비해 30/50 = 3/5 같은 경우는 다소 진부한 예라고 볼 수 있습니다.

위와 같은 성질을 가지면서 '진부하지 않은' 분수는, 값이 1보다 작고 분자와 분모가 2자리 정수인 경우 모두 4개가 있습니다.

이 4개의 분수를 곱해서 약분했을 때 분모는 얼마입니까?



The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.

*/

public class Problem033 {

	public static void main(String[] args) {
		System.out.println(Problem033.solution());
	}

	private static long solution() {
		int a = 1;
		int b = 1;
		for (int i=11; i<100; i++) {
			for (int j=10; j<i; j++) {
				
				if (checkFaction(i,j)) {
					System.out.println( j + " / " + i);
					a *= j;
					b *= i;
				}
			}
		}
		System.out.println ( "------------> " + a + " / " + b + " = " + (double)a/b);
		return -1;
	}

	private static boolean checkFaction(int i, int j) {

		if ( i%10 == 0 && j%10 == 0) return false;
		
		double f1 = (double)j/i;
		if ( i/10 == j/10 && f1 == ((double)(j%10))/(i%10)) return true;
		if ( i%10 == j/10 && f1 == ((double)(j%10))/(i/10)) return true;
		if ( i/10 == j%10 && f1 == ((double)(j/10))/(i%10)) return true;
		if ( i%10 == j%10 && f1 == ((double)(j/10))/(i/10)) return true;
		
		return false;
	}
}