package kr.kirk.euler.p000;

/*

세 변의 길이가 모두 자연수 {a, b, c}인 직각삼각형의 둘레를 p 로 둘 때, p = 120 을 만족하는 직각삼각형은 아래와 같이 세 개가 있습니다.

    {20, 48, 52}, {24, 45, 51}, {30, 40, 50} 

1000 이하의 둘레 p에 대해서, 직각삼각형이 가장 많이 만들어지는 p의 값은 얼마입니까?


If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?

*/

public class Problem039 {
	
	public static void main(String[] args) {
//		System.out.println(Problem039.solution(120));
		System.out.println(Problem039.solution(1000));
	}

	private static int solution(int x) {
		int n = x;
		int nCount = 0;
		
		for ( int i=x; i>2; i--) {
			int count = getRightTriangleCount(i);
			if ( count > nCount ) {
				nCount = count;
				n = i;
			}
		}
		return n;
	}

	private static int getRightTriangleCount(int x) {
		int n = 0;
		for ( int c=5; c<x/2; c++) {
			for ( int b=4; b<c; b++) {
				if ( c + b > x) continue;
				for ( int a=3; a<b; a++) {
					if ( a + b + c > x) continue;
					if ( a + b + c == x && a*a + b*b == c*c ) {
						System.out.println(a + ", " + b + ", " + c);
						n++;
					}
				}
			}
		}
		return n;
	}
}