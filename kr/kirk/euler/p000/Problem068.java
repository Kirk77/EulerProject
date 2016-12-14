package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.List;

/*
아래와 같이 마방진과 유사한 성질을 가진 도형이 있습니다. 1부터 6까지의 숫자가 한번씩만 사용되었고, 선을 따라 합을 구하면 항상 9가 됩니다.

바깥으로 뻗친 가지 중에서 가장 숫자가 낮은 것부터 시작해서 직선들을 시계방향으로 돌아가며 나열하면, 도형의 모양을 숫자로 나타낼 수 있습니다. 위 그림의 예를 들면 4,3,2; 6,2,1; 5,1,3 과 같이 됩니다.

위 도형으로는 네 가지 다른 합계를 가지도록 배열할 수 있는데, 다음과 같은 여덟 개의 풀이가 존재합니다.
합계 	풀이
9 	4,2,3; 5,3,1; 6,1,2
9 	4,3,2; 6,2,1; 5,1,3
10 	2,3,5; 4,5,1; 6,1,3
10 	2,5,3; 6,3,1; 4,1,5
11 	1,4,6; 3,6,2; 5,2,4
11 	1,6,4; 5,4,2; 3,2,6
12 	1,5,6; 2,6,4; 3,4,5
12 	1,6,5; 3,5,4; 2,4,6

하나의 풀이에 대해서 각 숫자를 모두 이어붙이면 9자리의 숫자를 만들 수 있고, 그 중에서 가장 큰 것은 432621513이 됩니다.

이제 아래와 같은 도형에다 마방진의 성질을 가지도록 1부터 10까지의 숫자를 채우고, 같은 방식으로 풀이 숫자를 이어붙이면 16자리 또는 17자리의 숫자가 만들어집니다. 이 때, 16자리 숫자 중에서 가장 큰 것은 무엇입니까?

 */

public class Problem068 {
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(solution(3));
		System.out.println(solution(5));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	private static String solution(int x) {
		
		int all_line_sum = 0;
		
		for ( int i=1; i<=x*2; i++) {
			all_line_sum +=  i <= x ? i*2 : i; 
		}
		
		int line_sum = all_line_sum / x;
		
		List<int[]> list = new ArrayList<int[]>();
		
		for ( int i=x+1; i<x*2+1; i++) {
			for ( int j=x ; j>0; j--) {
				int k = line_sum - i - j;
				if ( k>0 && k<x+1 && j!=k ) {
					int [] line = {i,j,k};
					list.add(line);
				}
			}
		}

		StringBuffer sb = new StringBuffer();
		int tail = list.get(0)[2];
		int head = list.get(0)[0];
		
		print(list.get(0), sb);
		for ( int i=list.size()-1; i>0; i-- ) {
			if ( list.get(i)[1] == tail && list.get(i)[0] != head) {
				print(list.get(i), sb);
				tail = list.get(i)[2];
				head = list.get(i)[0];
			}
		}
		
		return sb.toString();
	}

	private static void print(int[] is, StringBuffer sb) {
		System.out.print("[");
		for ( int n : is) {
			System.out.print(n + ",");
			sb.append(n);
		}
		System.out.println("]");
	}
}
