package kr.kirk.euler.p000;

import java.util.Arrays;
import java.util.List;

/*
영국의 화폐 단위는 파운드(£)와 펜스(p)이고, 동전의 종류는 아래와 같습니다.

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), £2 (200p)
이 동전들을 가지고 2파운드를 만드는 방법은 다양할 것입니다. 예를 하나 들면 이렇습니다.

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
2파운드를 만드는 서로 다른 방법은 모두 몇가지나 있습니까?

In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
It is possible to make £2 in the following way:

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?
*/

public class Problem031 {

	public static void main(String[] args) {
		System.out.println(Problem031.solution(200));
	}

	private static int solution(int x) {
		List<Integer> list = Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200);
		return getCount( list, x);
	}

	private static int getCount(List<Integer> list, int x) {
		if ( list.size() ==1 ) return 1;
		
		int nCount = 0;
		int unit = list.get(list.size()-1);
		
		for ( int i = 0; i<=x; i+=unit) {
			nCount += getCount( list.subList(0,list.size()-1), x-i);
		}
		return nCount;
	}
}