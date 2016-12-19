package kr.kirk.euler.p000;

/*
긴 철사를 구부려서 세 변이 정수인 직각삼각형을 만들 때, 그 방법이 한 가지 뿐인 경우는 12cm를 최소로 해서 아래와 같이 여러 개가 있습니다.

12 cm: (3,4,5)
24 cm: (6,8,10)
30 cm: (5,12,13)
36 cm: (9,12,15)
40 cm: (8,15,17)
48 cm: (12,16,20)

반면에 20cm의 경우처럼 세 변이 정수인 직각삼각형을 만들 수 없을 때도 있고, 여러 종류의 직각삼각형을 만들 수 있을 때도 있습니다. 
예를 들어 120cm의 철사로는 세 가지의 서로 다른 직각삼각형이 만들어집니다.

120 cm: (30,40,50), (20,48,52), (24,45,51)

그러면 길이가 1,500,000 이하인 철사를 가지고 세 변이 정수인 직각삼각형을 만들 때, 그 길이로는 한 가지 방법으로만 만들 수 있게 되는 경우는 모두 얼마나 됩니까?
*/
public class Problem075 {
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(solution(10000));
//		System.out.println(solution(1500000));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}
	
	private static long solution(int x) {
		int[] result = new int[x+1];
		
		for ( int a = 3; a<x/2; a++) {
			for ( int b = a+1; b<x/2; b++) {
				double k2 = Math.sqrt(a*a + b*b);
				int k = (int)k2;
				if ( a+b+k>x) break;
				if ( k == k2) {
					result[a+b+k]++;
				}
			}
		}
		int c = 0;
		for ( int n : result) if ( n==1 ) c++;
		return c;
	}
}