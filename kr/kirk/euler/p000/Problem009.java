package kr.kirk.euler.p000;


/*
세 자연수 a, b, c 가 피타고라스 정리 a2 + b2 = c2 를 만족하면 피타고라스 수라고 부릅니다 (여기서 a < b < c ).
예를 들면 32 + 42 = 9 + 16 = 25 = 52이므로 3, 4, 5는 피타고라스 수입니다.

a + b + c = 1000 인 피타고라스 수 a, b, c는 한 가지 뿐입니다. 이 때, a × b × c 는 얼마입니까?
*/

public class Problem009 {
		
	public static void main(String[] args) {

		System.out.println("========================================================");
		System.out.println(Problem009.solution(1000));
		System.out.println("========================================================");
	}

	private static long solution(long d) {
		
		for ( long i=1; i<d; ++i) {
			
			for ( long j=i+1; j<d-i; ++j) {
				
				long k = d - i - j;
					
				if ( k*k == i*i + j*j ) {
						System.out.println(i + ", " + j + ", " + k);
						return i*j*k;
				}
			}
		}
		
		return -1;
	}

	
}
