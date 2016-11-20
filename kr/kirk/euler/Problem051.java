package kr.kirk.euler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
두 자리 숫자 *3의 첫번째 자리를 여러가지로 바꿨을 때 가능한 아홉 가지의 결과 중에서 13, 23, 43, 53, 73, 83의 여섯 개는 소수입니다.

56**3 의 3번째와 4번째 자리를 동일한 숫자로 바꿔서 만들어지는 10개의 다섯자리 숫자 중에서는 아래에서 보듯이 7개가 소수가 되며, 이것은 이런 식으로 7개의 소수가 만들어지는 첫번째 경우입니다. 
이 소수 집단의 첫번째 수인 56003은 이런 성질을 갖는 가장 작은 소수입니다.

56003, 56113, 56333, 56443, 56663, 56773, 56993

위의 예처럼 원래의 일부를 동일한 숫자로 치환했을 때 8개의 소수 집단이 만들어지는 경우를 찾고, 그 집단에 속한 가장 작은 소수를 구하세요.
치환하는 자리는 인접하지 않아도 되고, 가장 앞부분을 치환하는 경우 거기에 0은 올 수 없습니다.

By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.

Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
*/

/*
1digit
	3n : 0 3 6 9
	3n+1 : 1 4 7
	3n+2 : 2 5 8
	
2digits
	3n : 00 33 66 99
	3n+1 : 22 55 88
	3n+2 : 11 44 77
	
3digits
	3n : 000 111 222 333 444 555 666 777 888 999
	3n+1 : -
	3n+2 : -
 */
public class Problem051 {

	static int[] d = {0,1,2,3,4,5,6,7,8,9};
	static HashSet<String> numbers = new HashSet<String>();
	static Map<String, Integer> patternCounterMap = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(solution(8));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	private static long solution(int x) {
		
		for ( int digit = 5; digit<7; digit++) {
			int r = 3;
			for ( int i=(int) Math.pow(10, digit-r-1); i<Math.pow(10,  digit-r); i++) {
				String str = String.valueOf(i);
				int kk = 0;
				for ( int k=0; k<str.length(); k++) kk+= Integer.parseInt(str.charAt(k) + "");
				if ( kk %3==0) continue;
				
				for ( int k=0; k<r; k++) str += 'X' ;
				getPrimes( str, "", x);
				
				if ( numbers.size() >= x ) {
					for ( String s : numbers ) System.out.println(s);
					break;
				}
			}
		}
		return -1;
	}

	private static boolean getPrimes(String str, String prev, int x) {
		int n = str.length();
		if ( n == 0 ) {
			if ( !prev.endsWith("X")) {
				numbers.clear();
				
				Integer prevCount = patternCounterMap.get(prev);
				if ( prevCount != null) return true;
				
				for ( int dd : d) {
					String temp = prev.replaceAll("X", String.valueOf(dd));
					if ( !temp.startsWith("0") && isPrime(Integer.parseInt(temp))) {
						numbers.add(temp);
					}
				}
				patternCounterMap.put(prev, numbers.size());
				System.out.println(prev + " : " + numbers.size());
				if ( numbers.size() >= x) {
					return false;
				}
			}
		} else {
			for ( int k=0; k<n; k++) {
				if (getPrimes( str.substring(0, k) + str.substring(k+1, n), prev + str.charAt(k), x) == false) return false;
			}
		}
		return true;
	}

	private static boolean isPrime(int v) {
		double sqrt = Math.sqrt(v);
		for ( int i=2; i<sqrt; i++) {
			if ( v % i == 0 ) return false;
		}
		return true;
	}
	
	
}