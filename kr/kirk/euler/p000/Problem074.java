package kr.kirk.euler.p000;

import java.util.ArrayList;
import java.util.List;

/*

145는 각 자릿수의 계승값을 모두 더했을 때 자기 자신이 되는 수로 잘 알려져 있습니다.

1! + 4! + 5! = 1 + 24 + 120 = 145

그보다 덜 유명하긴 하지만 169는 위와 같은 방법으로 계산해서 자기 자신으로 되돌아오는 데 가장 많은 단계를 거치는 숫자로, 그런 특성을 가진 숫자는 3개밖에 없다고 합니다.

169 → 363601 → 1454 → 169
871 → 45361 → 871
872 → 45362 → 872

어떤 숫자로 시작해도 결국 위와 같은 반복 루프에 들어간다는 사실은 어렵지 않게 증명이 가능한데, 몇 개 숫자의 예를 들면 다음과 같습니다.

69 → 363600 → 1454 → 169 → 363601 (→ 1454)
78 → 45360 → 871 → 45361 (→ 871)
540 → 145 (→ 145)

69로 시작하면, 반복이 일어나기 전에 다섯 번의 단계를 거친 다음에 루프에 들어갑니다. 1백만 이하의 숫자로 시작하는 경우는 최대 60번의 반복되지 않는 단계가 존재합니다.

1백만 이하의 숫자로 시작했을 때, 반복되지 않는 단계를 정확히 60번 거치는 경우는 모두 몇 번이나 됩니까?
*/
public class Problem074 {
	static long[] digits = {
		factorial(0),
		factorial(1),
		factorial(2),
		factorial(3),
		factorial(4),
		factorial(5),
		factorial(6),
		factorial(7),
		factorial(8),
		factorial(9),
	};
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
//		System.out.println(solution(540));
		System.out.println(solution(1000000));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}
	
	private static long solution(int x) {
		long nCount = 0;
		for ( long i = 1; i<=x; i++) {
			int p = getPCount(String.valueOf(i),new ArrayList<String>());
			if (p == 60) {
				System.out.println(i + " : " + p);
				nCount++;
			}
		}
		return nCount;
	}
	
	private static int getPCount(String i, List<String> arrayList) {
		while ( !arrayList.contains(i)) {
			arrayList.add(i);
			byte[] bs = i.getBytes();
			long newNumber = 0;
			for (byte b : bs) {
				newNumber += digits[b-'0'];
			}
			i = String.valueOf(newNumber);
		}
		return arrayList.size();
	}

	private static long factorial(long n) {
		if ( n < 2) return 1;
		return n * factorial(n-1);
	}
}