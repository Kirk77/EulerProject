package kr.kirk.euler.p000;

/*
125874를 2배 하면 251748이 되는데, 이 둘은 같은 숫자로 이루어져 있고 순서만 다릅니다.

2배, 3배, 4배, 5배, 6배의 결과도 같은 숫자로 이루어지는 가장 작은 수는 무엇입니까?

It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.

Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
*/

public class Problem052 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(solution());
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	private static long solution() {
		
		boolean bGoing = true;
		for ( long i=1; bGoing; i++) {
			int k;
			for ( k=2; k<=6; k++) {
				if ( isSameDigits( i, i*k)) continue;
				else break;
			}
			if (k == 7) return i;
		}
		return -1;
	}

	private static boolean isSameDigits(long a, long b) {

		String sa = String.valueOf(a);
		String sb = String.valueOf(b);
		
		if ( sa.length() != sb.length()) return false;
		
		for ( int i=0; i<sa.length(); i++) {
			if (sb.indexOf(sa.charAt(i)) < 0) return false;
		}
		return true;
	}
	
	
}