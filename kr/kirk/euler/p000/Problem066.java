package kr.kirk.euler.p000;

import java.math.BigInteger;

/*


Consider quadratic Diophantine equations of the form:

x2 – Dy2 = 1

For example, when D=13, the minimal solution in x is 6492 – 13×1802 = 1.

It can be assumed that there are no solutions in positive integers when D is square.

By finding minimal solutions in x for D = {2, 3, 5, 6, 7}, we obtain the following:

32 – 2×22 = 1
22 – 3×12 = 1
92 – 5×42 = 1
52 – 6×22 = 1
82 – 7×32 = 1

Hence, by considering minimal solutions in x for D ≤ 7, the largest x is obtained when D=5.

Find the value of D ≤ 1000 in minimal solutions of x for which the largest value of x is obtained.



다음과 같은 2차 디오판토스 방정식이 있습니다.

x2 – Dy2 = 1

(역주: 디오판토스 방정식은 정수해만 허용하는 부정다항방정식입니다. 그 중에서도 여기 나온 형태는 펠의 방정식이라고 하는데, x/y로 √D의 근사값을 구하는 데 이용됩니다.)

예를 들어서 D=13일 때 x를 최소화하는 해는 6492 – 13×1802 = 1 이 됩니다.

D가 제곱수일 경우에는 위 식을 만족하는 자연수 해는 없다고 볼 수 있습니다.

D = {2, 3, 5, 6, 7} 에 대해서 x를 최소화하는 자연수 해를 찾아보면, 아래와 같은 결과를 얻게 됩니다.

32 – 2×22 = 1
22 – 3×12 = 1
92 – 5×42 = 1
52 – 6×22 = 1
82 – 7×32 = 1

위에서 보듯이 D ≤ 7 인 경우에 대해 x를 최소화하는 해를 구하면, x의 값이 가장 큰 것은 D=5일 때입니다.

D ≤ 1000 인 경우에 대해 x를 최소화하는 해를 구하면, 가장 큰 x의 값을 갖는 D는 얼마입니까?


http://www.nicklib.com/library/algo/p/pellEqu_t.html
 */
public class Problem066 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(solution(7));
		System.out.println(solution(1000));
		System.out.println("실행시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	/*
	private static long solution(int n) {
		int result = 0;
		long pmax = 0;
		 
		for(int D = 2; D <= n; D++){
		    long limit = (int)Math.sqrt(D);
		    if (limit * limit == D) continue;
		 
		    long m = 0;
		    long d = 1;
		    long a = limit;
		 
		    long xk = 1;
		    long x = a;
		 
		    long yk = 0;
		    long y = 1;
		 
			while (x * x - D * y * y != 1) {
				m = d * a - m;
				d = (D - m * m) / d;
				a = (limit + m) / d;

				long xk_1 = xk;
				xk = x;
				long yk_1 = yk;
				yk = y;

				x = a * xk + xk_1;
				y = a * yk + yk_1;
			}
		 
		    if (x > pmax) {
		        pmax = x;
		        result = D;
		    }
		}
		return result;
	}
	*/
	
	private static long solution(int n) {
		int result = 0;
		BigInteger pmax = BigInteger.ZERO;
		 
		for(int D = 2; D <= n; D++){
		    long limit = (int)Math.sqrt(D);
		    if (limit * limit == D) continue;
		 
		    BigInteger m = BigInteger.ZERO;
		    BigInteger d = BigInteger.ONE;
		    BigInteger a = BigInteger.valueOf(limit);
		 
		    BigInteger xk = BigInteger.ONE;
		    BigInteger x = a;
		 
		    BigInteger yk = BigInteger.ZERO;
		    BigInteger y = BigInteger.ONE;
		 
			while (x.multiply(x).compareTo(y.multiply(y).multiply(BigInteger.valueOf(D)).add(BigInteger.ONE)) != 0) {
				m = d.multiply(a).add(m.negate());
				d = m.multiply(m).negate().add(BigInteger.valueOf(D)).divide(d);
				a = m.add(BigInteger.valueOf(limit)).divide(d);

				BigInteger xk_1 = xk;
				xk = x;
				BigInteger yk_1 = yk;
				yk = y;

				x = a.multiply(xk).add(xk_1);
				y = a.multiply(yk).add(yk_1);
			}
		 
		    if (x.compareTo(pmax) > 0) {
		        pmax = x;
		        result = D;
		    }
		}
		return result;
	}
}