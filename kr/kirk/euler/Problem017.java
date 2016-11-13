package kr.kirk.euler;

/*
1부터 5까지의 숫자를 영어로 쓰면 one, two, three, four, five 이고,
각 단어의 길이를 더하면 3 + 3 + 5 + 4 + 4 = 19 이므로 사용된 글자는 모두 19개입니다.

1부터 1,000까지 영어로 썼을 때는 모두 몇 개의 글자를 사용해야 할까요?

참고: 빈 칸이나 하이픈('-')은 셈에서 제외하며, 단어 사이의 and 는 셈에 넣습니다.
  예를 들어 342를 영어로 쓰면 three hundred and forty-two 가 되어서 23 글자,
  115 = one hundred and fifteen 의 경우에는 20 글자가 됩니다.
 */

public class Problem017 {
	
	public static void main(String[] args) {

		System.out.println(Problem017.solution(1,5));
		System.out.println(Problem017.solution(1,1000));
	}

	private static long solution(int x, int y) {
	
		long sum = 0;
		
		for ( int i=x; i<=y; ++i ) {
			sum += getTextLength(i);
		}
		
		return sum;
	}

	private static long getTextLength(int i) {
		
		switch (i) {
			case 1:		return "one".length();
			case 2:		return "two".length();
			case 3:		return "three".length();
			case 4:		return "four".length();
			case 5:		return "five".length();
			case 6:		return "six".length();
			case 7:		return "seven".length();
			case 8:		return "eight".length();
			case 9:		return "nine".length();
			case 10:	return "ten".length();
			
			case 11:	return "eleven".length();
			case 12:	return "twelve".length();
			case 13:	return "thirteen".length();
			case 14:	return "fourteen".length();
			case 15:	return "fifteen".length();
			case 16:	return "sixteen".length();
			case 17:	return "seventeen".length();
			case 18:	return "eighteen".length();
			case 19:	return "nineteen".length();
			
			case 100:	return "onehundred".length();
			case 1000:	return "onethousand".length();
		}
		
		
		if ( i > 100 ) {
			int r = i%100;
			return getTextLength(i/100) + "hundred".length() + ( r == 0 ? 0 : "and".length() + getTextLength(r));
		}

		int d = i / 10;
		
		switch (d) {
			case 2:		return "twenty".length() + getTextLength(i%10);
			case 3:		return "thirty".length() + getTextLength(i%10);
			case 4:		return "forty".length() + getTextLength(i%10);
			case 5:		return "fifty".length() + getTextLength(i%10);
			case 6:		return "sixty".length() + getTextLength(i%10);
			case 7:		return "seventy".length() + getTextLength(i%10);
			case 8:		return "eighty".length() + getTextLength(i%10);
			case 9:		return "ninety".length() + getTextLength(i%10);
		}
		System.out.println("!!!!!!!!!!!!!!!!!!! " + i);
		return 0;
	}
}
